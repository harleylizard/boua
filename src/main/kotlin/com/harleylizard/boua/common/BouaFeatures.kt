package com.harleylizard.boua.common

import com.harleylizard.boua.common.Boua.Companion.resourceLocation
import com.harleylizard.boua.common.feature.*
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration

object BouaFeatures {
	@JvmField val shrub: Feature<ShrubFeatureConfiguration> = ShrubFeature()
	@JvmField val shrubTree: Feature<ShrubTreeFeatureConfiguration> = ShrubTreeFeature()

	@JvmStatic
	fun register() {
		register("shrub", shrub)
		register("shrub_tree", shrubTree)
	}

	@JvmStatic
	private fun register(name: String, feature: Feature<out FeatureConfiguration>) {
		Registry.register(BuiltInRegistries.FEATURE, name.resourceLocation, feature)
	}
}