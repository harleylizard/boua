package com.harleylizard.boua.mixin;

import com.harleylizard.boua.common.BouaBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TallGrassBlock.class)
public abstract class TallGrassBlockMixin extends BushBlock {

    protected TallGrassBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        var below = blockPos.below();
        if (levelReader.getBiome(below).is(BouaBiomes.palmBeach) && levelReader.getBlockState(below).is(BlockTags.SAND)) {
            return true;
        }
        return super.canSurvive(blockState, levelReader, blockPos);
    }
}
