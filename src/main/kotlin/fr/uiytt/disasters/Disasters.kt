package fr.uiytt.disasters

import fr.slyce.api.architecture.KotlinPlugin
import fr.uiytt.disasters.game.GameManager
import fr.uiytt.disasters.listeners.Join
import fr.uiytt.disasters.listeners.Pvp
import fr.uiytt.disasters.listeners.Quit
import org.bukkit.plugin.PluginManager

class Disasters : KotlinPlugin() {
    companion object{
        lateinit var instance: Disasters
    }
    val configManager = ConfigManager();
    lateinit var gameManager: GameManager

    override fun onPluginEnable() {
        super.onPluginEnable()
        instance = this

        loadEvents(server.pluginManager)

        gameManager = GameManager()
    }

    private fun loadEvents(pluginManager: PluginManager) {
        pluginManager.registerEvents(Join(), this)
        pluginManager.registerEvents(Quit(), this)
        pluginManager.registerEvents(Pvp(), this)
    }
}