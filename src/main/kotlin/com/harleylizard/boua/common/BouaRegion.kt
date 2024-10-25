package com.harleylizard.boua.common

import com.mojang.datafixers.util.Pair
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Climate
import terrablender.api.*
import terrablender.api.ParameterUtils.*
import java.util.function.*

class BouaRegion(name: ResourceLocation) : Region(name, RegionType.OVERWORLD, 10) {

	override fun addBiomes(registry: Registry<Biome>?, mapper: Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>>?) {
		val builder = VanillaParameterOverlayBuilder()

		ParameterPointListBuilder()
			.temperature(Temperature.span(
				Temperature.NEUTRAL,
				Temperature.COOL
			))
			.erosion(Humidity.span(
				Humidity.DRY,
				Humidity.DRY
			))
			.continentalness(Continentalness.NEAR_INLAND)
			.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
			.build()
			.forEach { builder.add(it, BouaBiomes.dryForest) }

		ParameterPointListBuilder()
			.temperature(Temperature.span(
				Temperature.NEUTRAL,
				Temperature.NEUTRAL
			))
			.erosion(Humidity.span(
				Humidity.WET,
				Humidity.NEUTRAL
			))
			.continentalness(Continentalness.COAST)
			.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
			.build()
			.forEach { builder.add(it, BouaBiomes.palmBeach) }

		builder.build().forEach(mapper)

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Boua.MOD_ID, BouaSurfaceRules.palmBeach)
	}
}