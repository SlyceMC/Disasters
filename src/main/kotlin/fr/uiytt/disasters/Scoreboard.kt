package fr.uiytt.disasters

import fr.slyce.api.scoreboard.Line
import fr.slyce.api.scoreboard.addLine
import fr.slyce.api.scoreboard.addTitle
import fr.slyce.api.scoreboard.scoreBoard
import fr.slyce.core.common.database.getUser
import fr.slyce.core.common.language.fixColors
import fr.slyce.core.common.language.translateString

import org.bukkit.Bukkit
import org.bukkit.Bukkit.getOnlinePlayers

object Scoreboard {

    val scoreboard = scoreBoard("PlayingScoreboard", subscribeAll = false){
        addTitle {
            "§c§lDisaster"
        }
        +""

    }


    }
}