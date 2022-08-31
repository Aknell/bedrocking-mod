package io.github.aknell.bedrocking.common;

import io.github.aknell.bedrocking.common.block.BedrockingBlocks;
import io.github.aknell.bedrocking.common.item.BedrockingItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockingMod implements ModInitializer {

	public static final String MOD_ID = "bedrocking";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt World from {}!", mod.metadata().name());

		BedrockingItems.init();
		BedrockingBlocks.init();
	}

}
