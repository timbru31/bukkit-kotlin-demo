package de.dustplanet.kotlindemo

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.command.CommandSender
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor

class KotlinDemo: JavaPlugin, Listener, CommandExecutor {
    constructor(): super()

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        getCommand("kotlin")?.setExecutor(this)
    }
    

    @EventHandler fun onPlayerJoin(e: PlayerJoinEvent) {
        greetPlayer(e.player, ChatColor.RED)
    }

    fun greetPlayer(player: Player, color: ChatColor) {
        player.sendMessage("${color}You have been greeted by Kotlin in ${color.name}!")
    }

    override fun onCommand(sender: CommandSender, command: Command, commandLabel: String, args: Array<String>): Boolean {
        server.onlinePlayers.forEach { greetPlayer(it, ChatColor.GREEN) }
        return true
    }
}
