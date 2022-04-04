package fr.uiytt.disasters.game

import org.bukkit.entity.Player
import java.util.UUID

class GamePlayer(val uuid: UUID){
    var alive = true;
}

fun Player.getGamePlayer(): GamePlayer {
    val gameManager = getGameManager()
    return gameManager.players[uniqueId] ?: GamePlayer(uniqueId)
}