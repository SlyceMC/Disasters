package fr.uiytt.disasters.game

import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

class GameThread: BukkitRunnable() {

    var timer = 226;
    override fun run() {
        timer--;
        if(timer == 0) {
            this.cancel();
            getGameManager().stop()
            return
        }

        if(timer in 210..215) {
            if(timer != 210) Bukkit.broadcastMessage("Début des désastres dans ${timer - 210} secondes.")
            else {
                getGameManager().gameData.events.forEach{it.enable()}
            }
        }
    }
}