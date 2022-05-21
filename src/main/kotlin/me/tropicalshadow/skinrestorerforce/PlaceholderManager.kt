package me.tropicalshadow.skinrestorerforce

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import me.tropicalshadow.skinrestorerforce.listener.DeathDamagerListener
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player




class PlaceholderManager: PlaceholderExpansion() {
    override fun getIdentifier(): String {
        return "skinrestorerforce"
    }

    override fun getAuthor(): String {
        return "TropicalShadow"
    }

    override fun getVersion(): String {
        return "0.0.1"
    }

    override fun onRequest(player: OfflinePlayer, params: String): String {
        return onPlaceholderRequest(player.player, params)
    }

    override fun onPlaceholderRequest(player: Player?, params: String): String{

        when(params){
            "kills"->return DeathDamagerListener.kills.toString()
        }
        return ""

    }
}