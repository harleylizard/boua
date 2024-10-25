package com.harleylizard.boua.common

import net.minecraft.core.BlockPos
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.WorldGenLevel
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.state.BlockState

object Util {

	@JvmStatic
	fun setBlock(level: WorldGenLevel, blockPos: BlockPos, blockState: BlockState) {
		val replaceable = level.getBlockState(blockPos)
		if (level.isEmptyBlock(blockPos) || replaceable.`is`(BlockTags.REPLACEABLE) || replaceable.`is`(BlockTags.LEAVES)) level.getChunk(blockPos).setBlockState(blockPos, blockState, false)
	}

	@JvmStatic
	fun setLeaves(level: WorldGenLevel, blockPos: BlockPos, blockState: BlockState) {
		val replaceable = level.getBlockState(blockPos)
		if (level.isEmptyBlock(blockPos) || (replaceable.`is`(BlockTags.REPLACEABLE_BY_TREES) && !replaceable.`is`(
				BlockTags.LOGS))) {
			level.getChunk(blockPos).setBlockState(blockPos, blockState
				.setValue(LeavesBlock.PERSISTENT, false)
				.setValue(LeavesBlock.DISTANCE, 1), false)
		}
	}
}