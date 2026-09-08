package com.danako.gemistry.common.menu;

import com.danako.gemistry.common.block.GemistryBlocks;
import com.danako.gemistry.core.GemistryAttunementTheme;
import com.danako.gemistry.tag.GemistryTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.EventHooks;

import java.util.List;
import java.util.Optional;

public class AttunementTableMenu extends AbstractContainerMenu {

    public static final int ITEM_SLOT = 0;
    public static final int LAPIS_SLOT = 1;
    public static final int GEM_SLOT = 2;
    private static final int OWN_SLOT_COUNT = 3;
    private static final float ATTUNEMENT_COST_MULTIPLIER = 1.3F;
    private static final int ATTUNEMENT_COST_FLAT_BONUS = 2;
    private static final int ATTUNEMENT_LEVEL_BONUS = 1;
    private static final Identifier EMPTY_SLOT_GEM = Identifier.fromNamespaceAndPath("gemistry", "container/slot/gem");
    private static final int MAX_FALLBACK_COST_PROBE = 20;
    public final int[] costs = new int[3];
    public final int[] enchantClue = new int[]{-1, -1, -1};
    public final int[] levelClue = new int[]{-1, -1, -1};
    private final Container attuneSlots;
    private final ContainerLevelAccess access;
    private final RandomSource random = RandomSource.create();
    private final DataSlot enchantmentSeed = DataSlot.standalone();

    public AttunementTableMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public AttunementTableMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(GemistryMenuTypes.ATTUNEMENT_TABLE.get(), containerId);
        this.access = access;

        this.attuneSlots = new SimpleContainer(OWN_SLOT_COUNT) {
            @Override
            public void setChanged() {
                super.setChanged();
                AttunementTableMenu.this.slotsChanged(this);
            }
        };
        this.addSlot(new Slot(this.attuneSlots, ITEM_SLOT, 25, 36) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.isEnchantable();
            }
        });

        this.addSlot(new Slot(this.attuneSlots, LAPIS_SLOT, 16, 54) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.LAPIS_LAZULI);
            }

            @Override
            public Identifier getNoItemIcon() {
                return net.minecraft.resources.Identifier.withDefaultNamespace("container/slot/lapis_lazuli");
            }
        });

        this.addSlot(new Slot(this.attuneSlots, GEM_SLOT, 34, 54) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(GemistryTags.ATTUNEMENT_CATALYSTS);
            }

            @Override
            public Identifier getNoItemIcon() {
                return EMPTY_SLOT_GEM;
            }
        });

        this.addStandardInventorySlots(inventory, 8, 84);

        this.addDataSlot(DataSlot.shared(this.costs, 0));
        this.addDataSlot(DataSlot.shared(this.costs, 1));
        this.addDataSlot(DataSlot.shared(this.costs, 2));
        this.addDataSlot(this.enchantmentSeed).set(inventory.player.getEnchantmentSeed());
        this.addDataSlot(DataSlot.shared(this.enchantClue, 0));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 1));
        this.addDataSlot(DataSlot.shared(this.enchantClue, 2));
        this.addDataSlot(DataSlot.shared(this.levelClue, 0));
        this.addDataSlot(DataSlot.shared(this.levelClue, 1));
        this.addDataSlot(DataSlot.shared(this.levelClue, 2));
    }

    private static EnchantmentInstance buffLevel(EnchantmentInstance instance) {
        int maxLevel = instance.enchantment().value().getMaxLevel();
        int buffed = Math.min(instance.level() + ATTUNEMENT_LEVEL_BONUS, maxLevel);
        return buffed == instance.level() ? instance : new EnchantmentInstance(instance.enchantment(), buffed);
    }

    private static Optional<TagKey<Enchantment>> getThemeTag(ItemStack gemStack) {
        if (gemStack.isEmpty()) {
            return Optional.empty();
        }
        for (GemistryAttunementTheme theme : GemistryAttunementTheme.values()) {
            if (gemStack.is(theme.catalystTag())) {
                return Optional.of(theme.themeTag());
            }
        }
        return Optional.empty();
    }

    private static boolean isGem(ItemStack stack) {
        return stack.is(GemistryTags.ATTUNEMENT_CATALYSTS);
    }

    @Override
    public void slotsChanged(Container container) {
        if (container != this.attuneSlots) {
            return;
        }

        ItemStack itemStack = container.getItem(ITEM_SLOT);
        ItemStack gemStack = container.getItem(GEM_SLOT);
        Optional<TagKey<Enchantment>> theme = getThemeTag(gemStack);
        if (itemStack.isEmpty() || !itemStack.isEnchantable() || theme.isEmpty()) {
            for (int i = 0; i < 3; ++i) {
                this.costs[i] = 0;
                this.enchantClue[i] = -1;
                this.levelClue[i] = -1;
            }
            return;
        }

        this.access.execute((level, pos) -> {
            float bookshelves = 0.0F;
            for (BlockPos offset : EnchantingTableBlock.BOOKSHELF_OFFSETS) {
                if (EnchantingTableBlock.isValidBookShelf(level, pos, offset)) {
                    bookshelves += level.getBlockState(pos.offset(offset)).getEnchantPowerBonus(level, pos.offset(offset));
                }
            }

            this.random.setSeed(this.enchantmentSeed.get());

            int previousCost = 0;
            for (int i = 0; i < 3; ++i) {
                int rawCost = EnchantmentHelper.getEnchantmentCost(this.random, i, (int) bookshelves, itemStack);
                int cost = Math.round(rawCost * ATTUNEMENT_COST_MULTIPLIER) + ATTUNEMENT_COST_FLAT_BONUS;
                cost = Math.max(cost, previousCost + 1);
                cost = Math.max(cost, i + 1);

                cost = EventHooks.onEnchantmentLevelSet(level, pos, i, (int) bookshelves, itemStack, cost);
                previousCost = cost;

                this.enchantClue[i] = -1;
                this.levelClue[i] = -1;

                List<EnchantmentInstance> list = this.getEnchantmentList(level.registryAccess(), itemStack, i, cost, theme.get());
                if (!list.isEmpty()) {
                    EnchantmentInstance ench = list.get(this.random.nextInt(list.size()));
                    this.enchantClue[i] = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).asHolderIdMap().getId(ench.enchantment());
                    this.levelClue[i] = ench.level();
                } else {
                    cost = 0;
                }

                this.costs[i] = cost;
            }

            this.broadcastChanges();
        });
    }

    @Override
    public boolean clickMenuButton(Player player, int buttonId) {
        if (buttonId < 0 || buttonId >= this.costs.length) {
            return false;
        }

        ItemStack itemStack = this.attuneSlots.getItem(ITEM_SLOT);
        ItemStack currency = this.attuneSlots.getItem(LAPIS_SLOT);
        ItemStack gemStack = this.attuneSlots.getItem(GEM_SLOT);
        Optional<TagKey<Enchantment>> theme = getThemeTag(gemStack);
        int enchantmentCost = buttonId + 1;

        if (theme.isEmpty()) {
            return false;
        }

        if ((currency.isEmpty() || currency.getCount() < enchantmentCost) && !player.hasInfiniteMaterials()) {
            return false;
        }

        boolean canAfford = player.experienceLevel >= enchantmentCost && player.experienceLevel >= this.costs[buttonId];
        if (this.costs[buttonId] <= 0 || itemStack.isEmpty() || !(canAfford || player.hasInfiniteMaterials())) {
            return false;
        }

        this.access.execute((level, pos) -> {
            List<EnchantmentInstance> newEnchantments = this.getEnchantmentList(level.registryAccess(), itemStack, buttonId, this.costs[buttonId], theme.get());
            if (newEnchantments.isEmpty()) {
                return;
            }

            player.onEnchantmentPerformed(itemStack, enchantmentCost);
            ItemStack enchanted = itemStack.getItem().applyEnchantments(itemStack, newEnchantments);
            this.attuneSlots.setItem(ITEM_SLOT, enchanted);
            CommonHooks.onPlayerEnchantItem(player, enchanted, newEnchantments);
            currency.consume(enchantmentCost, player);
            if (currency.isEmpty()) {
                this.attuneSlots.setItem(LAPIS_SLOT, ItemStack.EMPTY);
            }
            player.awardStat(Stats.ENCHANT_ITEM);
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ENCHANTED_ITEM.trigger(serverPlayer, enchanted, enchantmentCost);
            }

            this.attuneSlots.setChanged();
            this.enchantmentSeed.set(player.getEnchantmentSeed());
            this.slotsChanged(this.attuneSlots);
            level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
        });

        return true;
    }

    private List<EnchantmentInstance> getEnchantmentList(RegistryAccess registryAccess, ItemStack itemStack, int slot, int enchantmentCost, TagKey<Enchantment> themeTag) {
        this.random.setSeed(this.enchantmentSeed.get() + slot);
        Optional<HolderSet.Named<Enchantment>> themed = registryAccess.lookupOrThrow(Registries.ENCHANTMENT).get(themeTag);
        if (themed.isEmpty()) {
            return List.of();
        }

        List<EnchantmentInstance> list = EnchantmentHelper.selectEnchantment(this.random, itemStack, enchantmentCost, themed.get().stream());
        for (int probe = 1; list.isEmpty() && probe <= MAX_FALLBACK_COST_PROBE; probe++) {
            list = EnchantmentHelper.selectEnchantment(this.random, itemStack, enchantmentCost + probe, themed.get().stream());
        }

        return list.stream().map(AttunementTableMenu::buffLevel).toList();
    }

    public int getLapisCount() {
        ItemStack lapis = this.attuneSlots.getItem(LAPIS_SLOT);
        return lapis.isEmpty() ? 0 : lapis.getCount();
    }

    public int getGemCount() {
        ItemStack gem = this.attuneSlots.getItem(GEM_SLOT);
        return gem.isEmpty() ? 0 : gem.getCount();
    }

    public int getEnchantmentSeed() {
        return this.enchantmentSeed.get();
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute((level, pos) -> this.clearContainer(player, this.attuneSlots));
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, GemistryBlocks.ATTUNEMENT_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack clicked = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            clicked = stack.copy();

            if (slotIndex == ITEM_SLOT || slotIndex == LAPIS_SLOT || slotIndex == GEM_SLOT) {
                if (!this.moveItemStackTo(stack, OWN_SLOT_COUNT, OWN_SLOT_COUNT + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (stack.is(Items.LAPIS_LAZULI)) {
                if (!this.moveItemStackTo(stack, LAPIS_SLOT, LAPIS_SLOT + 1, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (isGem(stack)) {
                if (!this.moveItemStackTo(stack, GEM_SLOT, GEM_SLOT + 1, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                Slot itemSlot = this.slots.get(ITEM_SLOT);
                if (itemSlot.hasItem() || !itemSlot.mayPlace(stack)) {
                    return ItemStack.EMPTY;
                }
                ItemStack single = stack.copyWithCount(1);
                stack.shrink(1);
                itemSlot.setByPlayer(single);
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == clicked.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
        }

        return clicked;
    }
}