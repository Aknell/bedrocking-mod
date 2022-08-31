package io.github.aknell.bedrocking.common.item;

import io.github.aknell.bedrocking.common.BedrockingMod;
import io.github.aknell.bedrocking.common.item.custom.BedrockingPickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BedrockingItems {

	public static Item HELLSTONE_PICKAXE;

	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(BedrockingMod.MOD_ID, name), item);
	}

	public static void init() {
		HELLSTONE_PICKAXE = registerItem("hellstone_pickaxe", new BedrockingPickaxeItem(BedrockingToolMaterials.HELLSTONE, 1, -2.8F, new QuiltItemSettings().group(ItemGroup.TOOLS)));
	}

}
