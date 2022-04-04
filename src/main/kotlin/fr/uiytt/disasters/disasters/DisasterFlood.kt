package fr.uiytt.disasters.disasters

import org.bukkit.Material

class DisasterFlood(id: Int) : Disaster(
    "Flood",
    Material.WATER_BUCKET,
    id,
    listOf("L'eau commence à monter")
) {

    override fun onEnable() {
        TODO("Not yet implemented")
    }

    override fun onDisable() {
        TODO("Not yet implemented")
    }

    override fun sendMessage() {
        TODO("Not yet implemented")
    }
}