package fr.uiytt.disasters.utils

import fr.uiytt.disasters.getConfigManager
import org.bukkit.Location
import org.bukkit.Material

/**
 * Find a solid block at y-1 that have free space above it, and return its location.
 */
fun getFreeLocationAtY(y: Int): Location  {
    val listBlocs = mutableListOf<Location>()
    for (x in -getConfigManager().worldSize..getConfigManager().worldSize) {
        for (z in -getConfigManager().worldSize..getConfigManager().worldSize) {
            val block = getConfigManager().world.getBlockAt(x, y-1, z);
            if (block.type != Material.AIR && block.getRelative(0,1,0 ).type in listOf(Material.AIR, Material.WATER)) listBlocs.add(block.location)
        }
    }
    return listBlocs.random()
}