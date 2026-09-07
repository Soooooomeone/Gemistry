package com.danako.gemistry.common.menu;

import com.danako.gemistry.Gemistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GemistryMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, Gemistry.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<AttunementTableMenu>> ATTUNEMENT_TABLE = MENU_TYPES.register("attunement_table", () -> new MenuType<>(AttunementTableMenu::new, FeatureFlags.DEFAULT_FLAGS));

    private GemistryMenuTypes() {
    }
}