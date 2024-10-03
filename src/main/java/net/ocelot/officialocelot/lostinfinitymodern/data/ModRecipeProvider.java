package net.ocelot.officialocelot.lostinfinitymodern.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.ocelot.officialocelot.lostinfinitymodern.registration.RegisterItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RegisterItems.ITEM_LIST.getOrDefault("celestial_miners_pickaxe", RegisterItems.DEFAULT_ITEM).get())
                .pattern("NEN")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK).define('N', Items.NETHER_STAR).define('E', Items.ENDER_EYE)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);
    }
}
