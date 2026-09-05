package com.danako.gemistry.core;

import com.danako.gemistry.Gemistry;
import com.danako.gemistry.item.GemistryArmorMaterial;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.Map;

public final class GemistryTrimMaterials {

    public static final ResourceKey<TrimMaterial> RUBY = registryKey("ruby");
    public static final ResourceKey<TrimMaterial> SAPPHIRE = registryKey("sapphire");
    public static final ResourceKey<TrimMaterial> AQUAMARINE = registryKey("aquamarine");
    public static final ResourceKey<TrimMaterial> AMBER = registryKey("amber");

    private GemistryTrimMaterials() {
    }

    public static final MaterialAssetGroup RUBY_ASSETS =
            MaterialAssetGroup.create("ruby", Map.of(GemistryArmorMaterial.RUBY_ARMOR_ASSET, "ruby_darker"));
    public static final MaterialAssetGroup SAPPHIRE_ASSETS =
            MaterialAssetGroup.create("sapphire", Map.of(GemistryArmorMaterial.SAPPHIRE_ARMOR_ASSET, "sapphire_darker"));
    public static final MaterialAssetGroup AQUAMARINE_ASSETS =
            MaterialAssetGroup.create("aquamarine", Map.of(GemistryArmorMaterial.AQUAMARINE_ARMOR_ASSET, "aquamarine_darker"));
    public static final MaterialAssetGroup AMBER_ASSETS =
            MaterialAssetGroup.create("amber", Map.of(GemistryArmorMaterial.AMBER_ARMOR_ASSET, "amber_darker"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, RUBY, Style.EMPTY.withColor(0xE0115F), RUBY_ASSETS);
        register(context, SAPPHIRE, Style.EMPTY.withColor(0x0F52BA), SAPPHIRE_ASSETS);
        register(context, AQUAMARINE, Style.EMPTY.withColor(0x7FFFD4), AQUAMARINE_ASSETS);
        register(context, AMBER, Style.EMPTY.withColor(0xFFBF00), AMBER_ASSETS);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> registryKey, Style hoverTextStyle, MaterialAssetGroup assets) {
        Component description = Component.translatable(Util.makeDescriptionId("trim_material", registryKey.identifier())).withStyle(hoverTextStyle);
        context.register(registryKey, new TrimMaterial(assets, description));
    }

    private static ResourceKey<TrimMaterial> registryKey(String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Gemistry.MODID, id));
    }
}