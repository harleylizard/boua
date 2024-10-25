package com.harleylizard.boua.common

import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.SurfaceRules

object BouaSurfaceRules {
	@JvmField val sand: SurfaceRules.RuleSource = SurfaceRules.sequence(
		SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState())),
		SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState())),
		SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
		SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
	)

	@JvmField val palmBeach = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(BouaBiomes.palmBeach), sand))

}