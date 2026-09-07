package com.danako.gemistry.client.screen;

import com.danako.gemistry.common.menu.AttunementTableMenu;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.cursor.CursorTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EnchantmentNames;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.book.BookModel;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;
import java.util.Optional;

public class AttunementTableScreen extends AbstractContainerScreen<AttunementTableMenu> {

    private static final Identifier[] ENABLED_LEVEL_SPRITES = new Identifier[]{Identifier.withDefaultNamespace("container/enchanting_table/level_1"), Identifier.withDefaultNamespace("container/enchanting_table/level_2"), Identifier.withDefaultNamespace("container/enchanting_table/level_3")};
    private static final Identifier[] DISABLED_LEVEL_SPRITES = new Identifier[]{Identifier.withDefaultNamespace("container/enchanting_table/level_1_disabled"), Identifier.withDefaultNamespace("container/enchanting_table/level_2_disabled"), Identifier.withDefaultNamespace("container/enchanting_table/level_3_disabled")};
    private static final Identifier ENCHANTMENT_SLOT_DISABLED_SPRITE = Identifier.withDefaultNamespace("container/enchanting_table/enchantment_slot_disabled");
    private static final Identifier ENCHANTMENT_SLOT_HIGHLIGHTED_SPRITE = Identifier.withDefaultNamespace("container/enchanting_table/enchantment_slot_highlighted");
    private static final Identifier ENCHANTMENT_SLOT_SPRITE = Identifier.withDefaultNamespace("container/enchanting_table/enchantment_slot");

    private static final Identifier BG_LOCATION = Identifier.fromNamespaceAndPath("gemistry", "textures/gui/container/attunement_table/attunement_table.png");
    private static final Identifier BOOK_LOCATION = Identifier.fromNamespaceAndPath("gemistry", "textures/entity/attunement/attunement_table_book.png");

    private static final int BAR_LEFT = 80;
    private static final int BAR_TOP = 16;
    private static final int BAR_WIDTH = 89;
    private static final int BAR_HOVER_HEIGHT = 17;
    private static final int BAR_HEIGHT = 19;
    private static final int BAR_SPACING = 19;

    private static final int COST_BOX_LEFT = 61;
    private static final int COST_BOX_WIDTH = 19;
    private static final int COST_BOX_HEIGHT = 17;
    private static final int BOOK_X_OFFSET = 16;
    private static final int BOOK_Y_OFFSET = 3;
    private static final int BOOK_WIDTH = 34;
    private static final int BOOK_HEIGHT = 30;

    private final RandomSource random = RandomSource.create();
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    private BookModel bookModel;
    private ItemStack last = ItemStack.EMPTY;

    public AttunementTableScreen(AttunementTableMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.bookModel = new BookModel(this.minecraft.getEntityModels().bakeLayer(ModelLayers.BOOK));
        this.titleLabelX = BAR_LEFT;
        this.titleLabelY = 5;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        this.minecraft.player.experienceDisplayStartTick = this.minecraft.player.tickCount;
        this.tickBook();
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        int xo = (this.width - this.imageWidth) / 2;
        int yo = (this.height - this.imageHeight) / 2;

        for (int i = 0; i < 3; ++i) {
            double xx = event.x() - (double) (xo + BAR_LEFT);
            double yy = event.y() - (double) (yo + BAR_TOP + BAR_SPACING * i);
            if (xx >= 0.0F && yy >= 0.0F && xx < (double) BAR_WIDTH && yy < (double) BAR_HEIGHT && this.menu.clickMenuButton(this.minecraft.player, i)) {
                this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, i);
                return true;
            }
        }

        return super.mouseClicked(event, doubleClick);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int xo = (this.width - this.imageWidth) / 2;
        int yo = (this.height - this.imageHeight) / 2;
        graphics.blit(RenderPipelines.GUI_TEXTURED, BG_LOCATION, xo, yo, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        this.extractBook(graphics, xo, yo);

        EnchantmentNames.getInstance().initSeed(this.menu.getEnchantmentSeed());
        int lapisCount = this.menu.getLapisCount();

        for (int i = 0; i < 3; ++i) {
            int leftPos = xo + BAR_LEFT;
            int barTop = yo + BAR_TOP + BAR_SPACING * i;
            int leftPosText = leftPos + 20;
            int textWidth = BAR_WIDTH - 22;
            int cost = this.menu.costs[i];
            int boxLeft = xo + COST_BOX_LEFT;
            int boxTop = barTop + (BAR_HEIGHT - COST_BOX_HEIGHT) / 2;

            if (cost == 0) {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ENCHANTMENT_SLOT_DISABLED_SPRITE, leftPos, barTop, BAR_WIDTH, BAR_HEIGHT);
                continue;
            }

            String costText = "" + cost;
            FormattedText message = EnchantmentNames.getInstance().getRandomName(this.font, textWidth);
            int col;
            boolean canBuy = (lapisCount >= i + 1 && this.minecraft.player.experienceLevel >= cost) || this.minecraft.player.getAbilities().instabuild;

            if (canBuy && this.menu.enchantClue[i] != -1) {
                int xx = mouseX - (xo + BAR_LEFT);
                int yy = mouseY - barTop;
                if (xx >= 0 && yy >= 0 && xx < BAR_WIDTH && yy < BAR_HEIGHT) {
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ENCHANTMENT_SLOT_HIGHLIGHTED_SPRITE, leftPos, barTop, BAR_WIDTH, BAR_HEIGHT);
                    graphics.requestCursor(CursorTypes.POINTING_HAND);
                    col = -128;
                } else {
                    graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ENCHANTMENT_SLOT_SPRITE, leftPos, barTop, BAR_WIDTH, BAR_HEIGHT);
                    col = -8323296;
                }

                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ENABLED_LEVEL_SPRITES[i], leftPos + 1, barTop + 1, 16, 16);
                graphics.textWithWordWrap(this.font, message, leftPosText, barTop + 2, textWidth, col, false);
            } else {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, ENCHANTMENT_SLOT_DISABLED_SPRITE, leftPos, barTop, BAR_WIDTH, BAR_HEIGHT);
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, DISABLED_LEVEL_SPRITES[i], leftPos + 1, barTop + 1, 16, 16);
                graphics.textWithWordWrap(this.font, message, leftPosText, barTop + 2, textWidth, ARGB.opaque((-8323296 & 16711422) >> 1), false);
                col = -12550384;
            }
            int costTextX = boxLeft + (COST_BOX_WIDTH - this.font.width(costText)) / 2;
            int costTextY = boxTop + (COST_BOX_HEIGHT - this.font.lineHeight) / 2 + 1;
            graphics.text(this.font, costText, costTextX, costTextY, col);
        }
    }

    private void extractBook(GuiGraphicsExtractor graphics, int left, int top) {
        float a = this.minecraft.getDeltaTracker().getGameTimeDeltaPartialTick(false);
        float open = Mth.lerp(a, this.oOpen, this.open);
        float flip = Mth.lerp(a, this.oFlip, this.flip);
        int x0 = left + BOOK_X_OFFSET;
        int y0 = top + BOOK_Y_OFFSET;
        int x1 = x0 + BOOK_WIDTH;
        int y1 = y0 + BOOK_HEIGHT;
        graphics.book(this.bookModel, BOOK_LOCATION, 40.0F, open, flip, x0, y0, x1, y1);
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float ignored) {
        float a = this.minecraft.getDeltaTracker().getGameTimeDeltaPartialTick(false);
        super.extractRenderState(graphics, mouseX, mouseY, a);
        boolean infiniteMaterials = this.minecraft.player.hasInfiniteMaterials();
        int lapisCount = this.menu.getLapisCount();

        for (int i = 0; i < 3; ++i) {
            int minLevel = this.menu.costs[i];
            Optional<Holder.Reference<Enchantment>> enchant = this.minecraft.level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).get(this.menu.enchantClue[i]);
            int enchantLevel = this.menu.levelClue[i];
            int cost = i + 1;

            if (this.isHovering(BAR_LEFT, BAR_TOP + BAR_SPACING * i, BAR_WIDTH, BAR_HOVER_HEIGHT, mouseX, mouseY) && minLevel > 0) {
                List<Component> texts = Lists.newArrayList();
                texts.add(Component.translatable("container.enchant.clue", enchant.isEmpty() ? "" : Enchantment.getFullname(enchant.get(), enchantLevel)).withStyle(ChatFormatting.WHITE));

                if (enchant.isEmpty()) {
                    texts.add(Component.literal(""));
                    texts.add(Component.translatable("neoforge.container.enchant.limitedEnchantability").withStyle(ChatFormatting.RED));
                } else if (!infiniteMaterials) {
                    texts.add(CommonComponents.EMPTY);
                    if (this.minecraft.player.experienceLevel < minLevel) {
                        texts.add(Component.translatable("container.enchant.level.requirement", this.menu.costs[i]).withStyle(ChatFormatting.RED));
                    } else {
                        MutableComponent lapisCost = cost == 1 ? Component.translatable("container.enchant.lapis.one") : Component.translatable("container.enchant.lapis.many", cost);
                        texts.add(lapisCost.withStyle(lapisCount >= cost ? ChatFormatting.GRAY : ChatFormatting.RED));

                        MutableComponent levelCost = cost == 1 ? Component.translatable("container.enchant.level.one") : Component.translatable("container.enchant.level.many", cost);
                        texts.add(levelCost.withStyle(ChatFormatting.GRAY));
                    }
                }

                graphics.setComponentTooltipForNextFrame(this.font, texts, mouseX, mouseY);
                break;
            }
        }
    }

    public void tickBook() {
        ItemStack current = this.menu.getSlot(AttunementTableMenu.ITEM_SLOT).getItem();
        if (!ItemStack.matches(current, this.last)) {
            this.last = current;
            do {
                this.flipT += (float) (this.random.nextInt(4) - this.random.nextInt(4));
            } while (this.flip <= this.flipT + 1.0F && this.flip >= this.flipT - 1.0F);
        }

        this.oFlip = this.flip;
        this.oOpen = this.open;

        boolean shouldBeOpen = false;
        for (int i = 0; i < 3; ++i) {
            if (this.menu.costs[i] != 0) {
                shouldBeOpen = true;
                break;
            }
        }

        this.open += shouldBeOpen ? 0.2F : -0.2F;
        this.open = Mth.clamp(this.open, 0.0F, 1.0F);

        float diff = Mth.clamp((this.flipT - this.flip) * 0.4F, -0.2F, 0.2F);
        this.flipA += (diff - this.flipA) * 0.9F;
        this.flip += this.flipA;
    }
}