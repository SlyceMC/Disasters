package fr.uiytt.disasters.listeners

import fr.uiytt.disasters.game.getGameManager
import fr.uiytt.disasters.game.isRunning
import fr.uiytt.disasters.getConfigManager
import fr.uiytt.disasters.lobby.getLobbyManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class Quit: Listener {
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        if(!getGameManager().isRunning())  getLobbyManager().unregisterPlayer(event.player)
        else {
            getGameManager().players[event.player.uniqueId]?.alive = false;
            if(getGameManager().players.filter { it.value.alive}.isEmpty()) getGameManager().stop()
        }

    }
}