package com.steelbite.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("§6Welcome to the server!");
	}
}
