package com.harleylizard.boua.mixin;

import com.harleylizard.boua.common.BouaBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MushroomBlock.class)
public abstract class MushroomBlockMixin {

    @Shadow protected abstract boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos);

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    public void boua$canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        var below = blockPos.below();
        if (levelReader.getBiome(below).is(BouaBiomes.dryForest) && mayPlaceOn(levelReader.getBlockState(below), levelReader, below)) {
            cir.setReturnValue(true);
        }
    }
}
