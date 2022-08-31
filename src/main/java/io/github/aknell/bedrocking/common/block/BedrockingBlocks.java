package io.github.aknell.bedrocking.common.block;

import io.github.aknell.bedrocking.common.BedrockingMod;
import io.github.aknell.bedrocking.common.item.BedrockingItems;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BedrockingBlocks {

	public static Block HELLSTONE;

	public static Block registerBlock(String name, Block block, ItemGroup tab) {
		if(tab != null) {
			registerBlockItem(name, block, tab);
		}

		return Registry.register(Registry.BLOCK, new Identifier(BedrockingMod.MOD_ID, name), block);
	}

	public static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(BedrockingMod.MOD_ID, name), new BlockItem(block, new QuiltItemSettings().group(tab).fireproof()));
	}

	public static void init() {
		HELLSTONE = registerBlock("hellstone", new Block(QuiltBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)), ItemGroup.BUILDING_BLOCKS);
	}
}
