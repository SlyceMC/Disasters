package fr.uiytt.disasters

import fr.uiytt.disasters.disasters.Disaster
import fr.uiytt.disasters.disasters.DisasterFlood
import fr.uiytt.disasters.disasters.DisasterIronCity
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration

class ConfigManager {
    val worldSize = 150 //Used for some Disasters
    val world = Disasters.instance.config.getWorld("worldname")
    val lobbyLocation = Disasters.instance.config.getLocation("location.lobby", "world")
    val gameSpawnLocation = Disasters.instance.config.getLocation("location.spawngame",  "world")
    val defaultDisastersNumber: Int = Disasters.instance.config.getInt("default.disastersnumber")

    val registeredEvents: List<Disaster> = listOf(
        DisasterFlood(0),
        DisasterIronCity(1)
    )

}

fun getConfigManager(): ConfigManager = Disasters.instance.configManager;

fun FileConfiguration.getWorld(path: String): World {
    val strworld: String = (Disasters.instance.config.get(path) ?: "world") as String
    return Bukkit.getWorld(strworld) ?: Bukkit.getWorlds()[0];
}

fun FileConfiguration.getLocation(path: String, world: String? = null): Location {
    val str = Disasters.instance.config.getString(path)
    val str1 = str.split(",")
    return if(world == null){
        if(str1.size == 6){
            Location(Bukkit.getWorld(str1[0]),str1[1].toDouble(),str1[2].toDouble(), str1[3].toDouble(), str1[4].toDouble().toFloat(), str1[5].toDouble().toFloat())
        }else{
            Location(Bukkit.getWorld(str1[0]),str1[1].toDouble(),str1[2].toDouble(), str1[3].toDouble())

        }
    }else{
        if(str1.size == 5){
            Location(Bukkit.getWorld(world),str1[0].toDouble(),str1[1].toDouble(),str1[2].toDouble(), str1[3].toFloat(), str1[4].toFloat())
        }else{
            Location(Bukkit.getWorld(world),str1[0].toDouble(),str1[1].toDouble(),str1[2].toDouble())

        }
    }
}