package com.danako.gemistry.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class GemistryConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue GENERATE_RUBY_ORE;
    public static final ModConfigSpec.BooleanValue GENERATE_SAPPHIRE_ORE;
    public static final ModConfigSpec.BooleanValue GENERATE_AQUAMARINE_ORE;
    public static final ModConfigSpec.BooleanValue GENERATE_AMBER_ORE;
    public static final ModConfigSpec.BooleanValue GENERATE_ONYX_ORE;

    static {
        BUILDER.comment("Detailed settings").push("detailed");
        BUILDER.comment("World generation settings").push("world_generation");
        BUILDER.comment(
                "Toggle whether a given ore generates in the world at all.",
                "Setting this to false stops NEW chunks from generating the ore.",
                "Chunks that were already generated before you changed this will keep whatever ore they already have."
        ).push("ore_generation");

        GENERATE_RUBY_ORE = BUILDER
                .comment("Whether Ruby Ore should generate in the world")
                .define("generateRubyOre", true);
        GENERATE_SAPPHIRE_ORE = BUILDER
                .comment("Whether Sapphire Ore should generate in the world")
                .define("generateSapphireOre", true);
        GENERATE_AQUAMARINE_ORE = BUILDER
                .comment("Whether Aquamarine Ore should generate in the world")
                .define("generateAquamarineOre", true);
        GENERATE_AMBER_ORE = BUILDER
                .comment("Whether Amber Ore should generate in the world")
                .define("generateAmberOre", true);
        GENERATE_ONYX_ORE = BUILDER
                .comment("Whether Onyx Ore should generate in the world")
                .define("generateOnyxOre", true);

        BUILDER.pop();
        BUILDER.pop();
        BUILDER.pop();
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    private static final Map<String, ModConfigSpec.BooleanValue> ORE_GENERATION_TOGGLES = new HashMap<>();

    static {
        ORE_GENERATION_TOGGLES.put("ruby", GENERATE_RUBY_ORE);
        ORE_GENERATION_TOGGLES.put("sapphire", GENERATE_SAPPHIRE_ORE);
        ORE_GENERATION_TOGGLES.put("aquamarine", GENERATE_AQUAMARINE_ORE);
        ORE_GENERATION_TOGGLES.put("amber", GENERATE_AMBER_ORE);
        ORE_GENERATION_TOGGLES.put("onyx", GENERATE_ONYX_ORE);
    }

    public static boolean isOreGenerationEnabled(String oreKey) {
        ModConfigSpec.BooleanValue value = ORE_GENERATION_TOGGLES.get(oreKey);
        return value == null || value.get();
    }
}