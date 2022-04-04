package fr.uiytt.disasters.listeners

import fr.uiytt.disasters.game.getGameManager
import fr.uiytt.disasters.game.isRunning
import fr.uiytt.disasters.getConfigManager
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class Death: Listener {

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        if(!getGameManager().isRunning()) event.entity.teleport(getConfigManager().lobbyLocation)
        else {
            getGameManager().players[event.entity.uniqueId]?.alive = false;
            if(getGameManager().players.filter { it.value.alive}.isEmpty()) getGameManager().stop()
            event.entity.gameMode = GameMode.SPECTATOR;
            event.entity.sendMessage("tu es mort")
        }
    }
}