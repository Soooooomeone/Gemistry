package com.danako.gemistry.datagen;

import com.danako.gemistry.core.GemistryItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class GemistryRecipeProvider extends RecipeProvider {
    private final HolderGetter<Item> items;

    public GemistryRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
        this.items = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    protected void buildRecipes() {
        buildStorage();
        buildTools();
        buildArmor();
    }

    private void buildStorage() {
        nineBlockStorageRecipes(RecipeCategory.MISC, GemistryItems.RUBY.get(), RecipeCategory.BUILDING_BLOCKS, GemistryItems.RUBY_BLOCK.get(), "gemistry:ruby_block", null, "gemistry:ruby_from_ruby_block", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, GemistryItems.SAPPHIRE.get(), RecipeCategory.BUILDING_BLOCKS, GemistryItems.SAPPHIRE_BLOCK.get(), "gemistry:sapphire_block", null, "gemistry:sapphire_from_sapphire_block", null);
        nineBlockStorageRecipes(RecipeCategory.MISC, GemistryItems.AQUAMARINE.get(), RecipeCategory.BUILDING_BLOCKS, GemistryItems.AQUAMARINE_BLOCK.get(), "gemistry:aquamarine_block", null, "gemistry:aquamarine_from_aquamarine_block", null);
    }

    private void buildTools() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.RUBY_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.RUBY_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.RUBY_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.RUBY_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', GemistryItems.RUBY.get()).define('S', Items.STICK).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.SAPPHIRE_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.SAPPHIRE_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.SAPPHIRE_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.SAPPHIRE_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', GemistryItems.SAPPHIRE.get()).define('S', Items.STICK).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_SWORD.get()).pattern("X").pattern("X").pattern("S").define('X', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.AQUAMARINE_PICKAXE.get()).pattern("XXX").pattern(" S ").pattern(" S ").define('X', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.AQUAMARINE_AXE.get()).pattern("XX").pattern("XS").pattern(" S").define('X', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.AQUAMARINE_SHOVEL.get()).pattern("X").pattern("S").pattern("S").define('X', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, GemistryItems.AQUAMARINE_HOE.get()).pattern("XX").pattern(" S").pattern(" S").define('X', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_SPEAR.get()).pattern("I").pattern("S").pattern("S").define('I', GemistryItems.AQUAMARINE.get()).define('S', Items.STICK).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);
    }

    private void buildArmor() {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_HELMET.get()).pattern("XXX").pattern("X X").define('X', GemistryItems.RUBY.get()).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', GemistryItems.RUBY.get()).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', GemistryItems.RUBY.get()).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.RUBY_BOOTS.get()).pattern("X X").pattern("X X").define('X', GemistryItems.RUBY.get()).unlockedBy("has_ruby", has(GemistryItems.RUBY.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_HELMET.get()).pattern("XXX").pattern("X X").define('X', GemistryItems.SAPPHIRE.get()).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', GemistryItems.SAPPHIRE.get()).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', GemistryItems.SAPPHIRE.get()).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.SAPPHIRE_BOOTS.get()).pattern("X X").pattern("X X").define('X', GemistryItems.SAPPHIRE.get()).unlockedBy("has_sapphire", has(GemistryItems.SAPPHIRE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_HELMET.get()).pattern("XXX").pattern("X X").define('X', GemistryItems.AQUAMARINE.get()).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_CHESTPLATE.get()).pattern("X X").pattern("XXX").pattern("XXX").define('X', GemistryItems.AQUAMARINE.get()).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_LEGGINGS.get()).pattern("XXX").pattern("X X").pattern("X X").define('X', GemistryItems.AQUAMARINE.get()).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GemistryItems.AQUAMARINE_BOOTS.get()).pattern("X X").pattern("X X").define('X', GemistryItems.AQUAMARINE.get()).unlockedBy("has_aquamarine", has(GemistryItems.AQUAMARINE.get())).save(output);
    }


    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesLookup) {
            super(output, registriesLookup);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new GemistryRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Gemistry Recipes";
        }
    }
}