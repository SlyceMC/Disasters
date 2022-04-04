package fr.uiytt.disasters.disasters

import org.bukkit.Material

abstract class Disaster(val name: String,
                        val itemMaterial: Material,
                        val id: Int,
                        val eventGUIDescription: List<String>) {
    abstract fun onEnable()
    abstract fun onDisable()
    abstract fun sendMessage()

    fun enable() {
        this.onEnable()
    }

    fun disable() {
        this.onDisable()
    }
}
