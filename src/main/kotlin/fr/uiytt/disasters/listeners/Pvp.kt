package fr.uiytt.disasters.listeners

import fr.uiytt.disasters.game.getGameManager
import org.bukkit.entity.Arrow
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

class Pvp: Listener {
    @EventHandler
    fun onPvp(event: EntityDamageByEntityEvent) {
        if(getGameManager().gameData.pvp) return
        if (event.entity !is Player) return

        if (event.damager.type == EntityType.ARROW) {
            if ((event.damager as Arrow).shooter !is Player) return
        } else if (event.damager !is Player) return

        event.isCancelled = true;
    }
}