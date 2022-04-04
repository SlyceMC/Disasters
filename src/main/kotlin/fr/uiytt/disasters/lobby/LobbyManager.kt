package fr.uiytt.disasters.lobby

import fr.uiytt.disasters.Disasters
import fr.uiytt.disasters.game.getGameManager
import fr.uiytt.disasters.getConfigManager
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class LobbyManager {
    private val players = mutableListOf<Player>();

    fun registerPlayer(player: Player) {
        players.add(player)
        player.gameMode = GameMode.SPECTATOR;
        player.teleport(getConfigManager().lobbyLocation)
        checkStart()
    }

    fun unregisterPlayer(player: Player) {
        players.remove(player)
    }

    private fun checkStart() {
        if(enoughPlayers()) AutoStartMananger().runTaskTimerAsynchronously(Disasters.instance, 0L, 20L)
    }

    fun enoughPlayers(): Boolean = players.any{ it.gameMode != GameMode.SPECTATOR } //TODO REAL CONDITION
    fun copyWaitingPlayers(): List<Player> = players.toMutableList()
}

class AutoStartMananger: BukkitRunnable() {
    var time = 20

    override fun run() {
        if(!getLobbyManager().enoughPlayers()) {
            this.cancel()
            Bukkit.broadcastMessage("Lancement annulé par manque de joueurs")
            return
        }
        if(time == 0) {
            getGameManager().start(getLobbyManager().copyWaitingPlayers());
            this.cancel()
            return
        }


        if (time == 30 || time == 10 || time < 6)
            Bukkit.broadcastMessage("La partie commence dans $time secondes.")

        time--
    }

}
fun getLobbyManager(): LobbyManager = getGameManager().lobbyManager;