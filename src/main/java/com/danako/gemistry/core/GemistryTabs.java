package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class GemistryTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gemistry.MODID);

    public static final Supplier<CreativeModeTab> GEMISTRY_TAB = CREATIVE_MODE_TABS.register("gemistry", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + Gemistry.MODID + ".gemistry")).icon(() -> new ItemStack(GemistryItems.RUBY.get())).displayItems((parameters, output) -> {
        output.accept(GemistryItems.RUBY.get());
        output.accept(GemistryItems.RUBY_ORE.get());
        output.accept(GemistryItems.DEEPSLATE_RUBY_ORE.get());
        output.accept(GemistryItems.RUBY_BLOCK.get());
        output.accept(GemistryItems.RUBY_SWORD.get());
        output.accept(GemistryItems.RUBY_SPEAR.get());
        output.accept(GemistryItems.RUBY_PICKAXE.get());
        output.accept(GemistryItems.RUBY_AXE.get());
        output.accept(GemistryItems.RUBY_SHOVEL.get());
        output.accept(GemistryItems.RUBY_HOE.get());
        output.accept(GemistryItems.RUBY_HELMET.get());
        output.accept(GemistryItems.RUBY_CHESTPLATE.get());
        output.accept(GemistryItems.RUBY_LEGGINGS.get());
        output.accept(GemistryItems.RUBY_BOOTS.get());
        output.accept(GemistryItems.RUBY_HORSE_ARMOR.get());
        output.accept(GemistryItems.RUBY_NAUTILUS_ARMOR.get());
        output.accept(GemistryItems.SAPPHIRE.get());
        output.accept(GemistryItems.SAPPHIRE_ORE.get());
        output.accept(GemistryItems.DEEPSLATE_SAPPHIRE_ORE.get());
        output.accept(GemistryItems.SAPPHIRE_BLOCK.get());
        output.accept(GemistryItems.SAPPHIRE_SWORD.get());
        output.accept(GemistryItems.SAPPHIRE_SPEAR.get());
        output.accept(GemistryItems.SAPPHIRE_PICKAXE.get());
        output.accept(GemistryItems.SAPPHIRE_AXE.get());
        output.accept(GemistryItems.SAPPHIRE_SHOVEL.get());
        output.accept(GemistryItems.SAPPHIRE_HOE.get());
        output.accept(GemistryItems.SAPPHIRE_HELMET.get());
        output.accept(GemistryItems.SAPPHIRE_CHESTPLATE.get());
        output.accept(GemistryItems.SAPPHIRE_LEGGINGS.get());
        output.accept(GemistryItems.SAPPHIRE_BOOTS.get());
        output.accept(GemistryItems.SAPPHIRE_HORSE_ARMOR.get());
        output.accept(GemistryItems.SAPPHIRE_NAUTILUS_ARMOR.get());
        output.accept(GemistryItems.AQUAMARINE.get());
        output.accept(GemistryItems.AQUAMARINE_ORE.get());
        output.accept(GemistryItems.DEEPSLATE_AQUAMARINE_ORE.get());
        output.accept(GemistryItems.AQUAMARINE_BLOCK.get());
        output.accept(GemistryItems.AQUAMARINE_SWORD.get());
        output.accept(GemistryItems.AQUAMARINE_SPEAR.get());
        output.accept(GemistryItems.AQUAMARINE_PICKAXE.get());
        output.accept(GemistryItems.AQUAMARINE_AXE.get());
        output.accept(GemistryItems.AQUAMARINE_SHOVEL.get());
        output.accept(GemistryItems.AQUAMARINE_HOE.get());
        output.accept(GemistryItems.AQUAMARINE_HELMET.get());
        output.accept(GemistryItems.AQUAMARINE_CHESTPLATE.get());
        output.accept(GemistryItems.AQUAMARINE_LEGGINGS.get());
        output.accept(GemistryItems.AQUAMARINE_BOOTS.get());
        output.accept(GemistryItems.AQUAMARINE_HORSE_ARMOR.get());
        output.accept(GemistryItems.AQUAMARINE_NAUTILUS_ARMOR.get());
    }).build());

    private GemistryTabs() {
    }
}