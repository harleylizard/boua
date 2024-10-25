package com.harleylizard.boua.common.feature

import com.harleylizard.boua.common.Util
import net.minecraft.core.Direction
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext

class ShrubFeature : Feature<ShrubFeatureConfiguration>(ShrubFeatureConfiguration.codec) {

	override fun place(context: FeaturePlaceContext<ShrubFeatureConfiguration>): Boolean {
		val level = context.level()
		val blockPos = context.origin()
		val random = context.random()
		val config = context.config()

		val below = blockPos.below()
		if (!level.getBlockState(below).`is`(BlockTags.DIRT)) {
			return false
		}
		Util.setBlock(level, below, Blocks.ROOTED_DIRT.defaultBlockState())

		Util.setBlock(level, blockPos, config.log.getState(random, blockPos))
		for (direction in Direction.entries) {
			blockPos.relative(direction).also { Util.setLeaves(level, it, config.leaves.getState(random, it)) }
		}
		return true
	}
}