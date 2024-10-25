package com.harleylizard.boua.common

import com.harleylizard.boua.common.Boua.Companion.resourceLocation
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.biome.Biome

object BouaBiomes {
	@JvmField val dryForest = "dry_forest".resourceKey
	@JvmField val palmBeach = "palm_beach".resourceKey

	private val String.resourceKey: ResourceKey<Biome>; get() = ResourceKey.create(Registries.BIOME, this.resourceLocation)
}