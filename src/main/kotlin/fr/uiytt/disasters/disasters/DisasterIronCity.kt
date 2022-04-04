package fr.uiytt.disasters.disasters

import fr.slyce.api.utils.randomIndex
import fr.uiytt.disasters.utils.getFreeLocationAtY
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.scheduler.BukkitRunnable

class DisasterIronCity(id: Int): Disaster(
    "IronCity",
    Material.IRON_BLOCK,
    id,
    listOf("La ville se transforme lentement en fer")
) {


    override fun onEnable() {
        ThreadIronCity(getFreeLocationAtY(10))
    }

    override fun onDisable() {
        TODO("Not yet implemented")
    }

    override fun sendMessage() {
        TODO("Not yet implemented")
    }

    private class ThreadIronCity(location: Location): BukkitRunnable() {
        val blockToSpread = mutableListOf<Location>()

        init {
            blockToSpread.add(location)
        }

        override fun run() {
            val index = blockToSpread.randomIndex()
            blockToSpread.removeAt(index)
        }

    }
}