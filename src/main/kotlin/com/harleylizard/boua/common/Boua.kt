package com.harleylizard.boua.common

import net.fabricmc.api.ModInitializer
import net.minecraft.resources.ResourceLocation
import terrablender.api.Regions
import terrablender.api.TerraBlenderApi

class Boua : ModInitializer, TerraBlenderApi {

	override fun onInitialize() {
		BouaFeatures.register()
	}

	override fun onTerraBlenderInitialized() {
		MOD_ID.resourceLocation.also { Regions.register(it, BouaRegion(it)) }
	}

	companion object {
		const val MOD_ID = "boua"

		@JvmStatic
		val String.resourceLocation: ResourceLocation; get() = ResourceLocation.fromNamespaceAndPath(MOD_ID, this)
	}
}