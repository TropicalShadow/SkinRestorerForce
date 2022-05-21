package me.tropicalshadow.skinrestorerforce.listener

import com.destroystokyo.paper.profile.ProfileProperty
import me.tropicalshadow.skinrestorerforce.SkinRestorerForce
import net.kyori.adventure.text.Component
import net.skinsrestorer.api.PlayerWrapper
import net.skinsrestorer.api.SkinVariant
import net.skinsrestorer.api.SkinsRestorerAPI
import net.skinsrestorer.api.property.GenericProperty
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent


class JoinListener(plugin: SkinRestorerForce) : ShadowListener(plugin) {

    companion object{
        lateinit var skinsRestorerAPI: SkinsRestorerAPI
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent){
        Bukkit.getScheduler().runTaskLater(plugin, Runnable{
            val player = event.player
            if(player.name == "TwitchBbalconyy")return@Runnable
            if(skinsRestorerAPI == null) {
                player.sendMessage("Failed to get SkinRestorerApi")
                return@Runnable plugin.logger.info("Skin Restorer not found")
            }
            val skinProps = GenericProperty(skinsRestorerAPI.genSkinUrl("https://s3.us-east-1.amazonaws.com/texture.namemc.com/91/89/91890e835d64c988.png",SkinVariant.SLIM))
            skinsRestorerAPI.setSkinData(player.name,skinProps,null)
            skinsRestorerAPI.applySkin(PlayerWrapper(player), skinsRestorerAPI.genSkinUrl("https://s3.us-east-1.amazonaws.com/texture.namemc.com/91/89/91890e835d64c988.png",SkinVariant.SLIM));
            player.sendMessage(Component.text("Skin has been set to ClownPierce"))
        },20)
    }

}