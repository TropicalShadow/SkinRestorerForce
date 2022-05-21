package me.tropicalshadow.skinrestorerforce.listener

import me.tropicalshadow.skinrestorerforce.SkinRestorerForce
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerDeathEvent

class DeathDamagerListener(plugin: SkinRestorerForce) : ShadowListener(plugin) {

    @EventHandler
    fun onDeath(event: PlayerDeathEvent){
        if(event.player.lastDamageCause?.entity !is Player)return
        if(event.player.name != "TwitchBbalconyy")return
        kills += 1
    }

    companion object{
        var kills = 0
    }

}