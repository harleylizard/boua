package com.harleylizard.boua.common.feature

import com.harleylizard.boua.common.Util
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext

class ShrubTreeFeature : Feature<ShrubTreeFeatureConfiguration>(ShrubTreeFeatureConfiguration.codec) {

	override fun place(context: FeaturePlaceContext<ShrubTreeFeatureConfiguration>): Boolean {
		val level = context.level()
		val blockPos = context.origin()
		val random = context.random()
		val config = context.config()
		val leaves = config.leaves

		val below = blockPos.below()
		if (!level.getBlockState(below).`is`(BlockTags.DIRT)) {
			return false
		}

		level.getChunk(below).setBlockState(below, Blocks.ROOTED_DIRT.defaultBlockState(), false)

		val height = 7 + random.nextInt(4)
		for (i in 0 until height) {
			blockPos.offset(0, i, 0).also { Util.setBlock(level, it, config.log.getState(random, it)) }

			if (i > 1) {

				blockPos.offset(1, i, 0).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
				blockPos.offset(-1, i, 0).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
				blockPos.offset(0, i, 1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
				blockPos.offset(0, i, -1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }

				if (i % 2 == 0) {
					blockPos.offset(1, i, 1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
					blockPos.offset(-1, i, 1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
					blockPos.offset(1, i, -1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
					blockPos.offset(-1, i, -1).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
				}
			}
		}
		for (i in 0 until 3) {
			blockPos.offset(0, height + i, 0).also { Util.setLeaves(level, it, leaves.getState(random, it)) }
		}
		return true
	}
}