package me.tropicalshadow.skinrestorerforce

import me.tropicalshadow.skinrestorerforce.listener.JoinListener
import me.tropicalshadow.skinrestorerforce.listener.ShadowListener
import net.skinsrestorer.api.SkinsRestorerAPI
import org.bukkit.Bukkit
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections

class SkinRestorerForce: JavaPlugin() {


    override fun onEnable() {
        registerListeners()
        PlaceholderManager().register()
        JoinListener.skinsRestorerAPI = SkinsRestorerAPI.getApi()
        logger.info("Plugin Enabled")
    }

    override fun onDisable() {
        HandlerList.unregisterAll(this)
        logger.info("Plugin Disabled")
    }
    private fun registerListeners(){
        val packageName = javaClass.`package`.name
        for (clazz in Reflections("$packageName.listener").getSubTypesOf(
            ShadowListener::class.java
        )){
            try{
                val listener: ShadowListener = clazz.getDeclaredConstructor(this::class.java).newInstance(this)
                logger.info("Registering ${listener.javaClass.name.split(".").last()}")
                Bukkit.getPluginManager().registerEvents(listener, this)
                logger.info("Registered ${listener.javaClass.name.split(".").last()}")
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}