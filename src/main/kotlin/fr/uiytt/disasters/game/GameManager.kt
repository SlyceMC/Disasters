package fr.uiytt.disasters.game

import fr.uiytt.disasters.Disasters
import fr.uiytt.disasters.getConfigManager
import fr.uiytt.disasters.lobby.LobbyManager
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.StringJoiner
import java.util.UUID

class GameManager {
    val gameThread = GameThread()
    val gameData = GameData()
    val lobbyManager = LobbyManager()
    var players = mutableMapOf<UUID, GamePlayer>()

    fun start(players: List<Player>) {
        players.forEach {
            this.players[it.uniqueId] = GamePlayer(it.uniqueId)
            cleanPlayer(it)
            it.teleport(getConfigManager().gameSpawnLocation)
        }
        Bukkit.broadcastMessage("La partie commence")
        gameData.events.forEach { it.sendMessage()}
        gameThread.runTaskTimerAsynchronously(Disasters.instance, 0L, 20L)
    }

    fun stop() {
        val playersAlive = players.filter { it.value.alive };
        val message: String;
        if(playersAlive.isEmpty()) {
            message = "Aucun joueur n'a survécu"
        } else {
            val stringJoiner = StringJoiner(",", "Les joueurs ", " ont gagnés")
            playersAlive.forEach {stringJoiner.add(Bukkit.getPlayer(it.key).displayName)}
            message = stringJoiner.toString()
        }

        Bukkit.getOnlinePlayers().forEach {
            it.sendMessage(message)
            it.gameMode = GameMode.SPECTATOR;
        }
    }

    private fun cleanPlayer(player: Player) {
        player.gameMode = GameMode.ADVENTURE;
        player.exp = 0f;
        player.foodLevel = 20;
        player.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, 99999, 0, false, false))
    }
}

fun getGameManager() = Disasters.instance.gameManager