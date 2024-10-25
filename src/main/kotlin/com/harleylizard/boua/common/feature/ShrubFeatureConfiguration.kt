package com.harleylizard.boua.common.feature

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider

class ShrubFeatureConfiguration(
	val log: BlockStateProvider,
	val leaves: BlockStateProvider
) : FeatureConfiguration {

	companion object {

		@JvmField
		val codec: Codec<ShrubFeatureConfiguration> = RecordCodecBuilder.create {
			it.group(
				BlockStateProvider.CODEC.fieldOf("log_provider").forGetter(ShrubFeatureConfiguration::log),
				BlockStateProvider.CODEC.fieldOf("leaves_provider").forGetter(ShrubFeatureConfiguration::leaves)).apply(it, ::ShrubFeatureConfiguration)
		}
	}
}