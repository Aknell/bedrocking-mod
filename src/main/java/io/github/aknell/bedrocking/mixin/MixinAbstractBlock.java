package io.github.aknell.bedrocking.mixin;

import io.github.aknell.bedrocking.common.item.BedrockingItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class MixinAbstractBlock {
	@Inject(method = "calcBlockBreakingDelta", at = @At("HEAD"), cancellable = true)
	private void modifyBlockBreakingSpeed(BlockState state, PlayerEntity player, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir) {
		if (state.getHardness(world, pos) == -1.0 && player.getStackInHand(player.getActiveHand()).getItem() == BedrockingItems.HELLSTONE_PICKAXE) {
			BlockState newState = Blocks.OBSIDIAN.getDefaultState();
			cir.setReturnValue(player.getBlockBreakingSpeed(newState) / newState.getHardness(world, pos) / (float)(player.canHarvest(newState) ? 30 : 100));
		}
	}
}
