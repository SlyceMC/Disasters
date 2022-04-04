package fr.uiytt.disasters.listeners

import fr.slyce.api.extensions.player.clearAll
import fr.uiytt.disasters.game.getGameManager
import fr.uiytt.disasters.game.isRunning
import fr.uiytt.disasters.lobby.getLobbyManager
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Join: Listener {

    @EventHandler
    fun playerJoinEvent(event: PlayerJoinEvent) {
        if(getGameManager().isRunning()) {
            event.player.inventory.clearAll();
            event.player.gameMode = GameMode.SPECTATOR;
            getGameManager().players[event.player.uniqueId]?.alive = false;

            event.player.sendMessage("La partie est déjà lancée, vous êtes spéctateur.")
        } else {
            getLobbyManager().registerPlayer(event.player)
        }
    }
}