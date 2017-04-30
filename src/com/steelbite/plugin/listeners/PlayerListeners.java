package com.steelbite.plugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		event.setFormat("§9" + event.getPlayer().getName() + "§8: §f" + event.getMessage());
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage("§8[§a+§8] §e" + event.getPlayer().getName() + " has entered the hub!");
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		event.setQuitMessage("§8[§c-§8] §e" + event.getPlayer().getName() + " has exited the hub!");
	}
	
}
