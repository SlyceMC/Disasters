package fr.uiytt.disasters.game

import fr.uiytt.disasters.disasters.Disaster
import fr.uiytt.disasters.getConfigManager

class GameData {
    var running: Boolean = false
    var pvp: Boolean = false
    val events: List<Disaster>

    init {
        var numberEvent: Int = getConfigManager().defaultDisastersNumber +  listOf(-1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2).random()
        if(numberEvent <= 0) numberEvent = 1;

        val temp = getConfigManager().registeredEvents.toMutableList().shuffled()
        val lastIndex = if(temp.size - numberEvent >= 0) temp.size - numberEvent else 0;
        events = temp.filterIndexed{ index, _ -> (index <= lastIndex) }
    }
}

fun GameManager.isRunning(): Boolean {
    return this.gameData.running
}