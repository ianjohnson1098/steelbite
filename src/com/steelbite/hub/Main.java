package com.steelbite.hub;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.steelbite.hub.commands.Message;
import com.steelbite.hub.listeners.PlayerChat;
import com.steelbite.hub.listeners.PlayerJoin;
import com.steelbite.hub.listeners.PlayerQuit;

public class Main extends JavaPlugin implements Listener {
	
	private Message messenger;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		messenger = new Message(this);
		this.getCommand("message").setExecutor(messenger);
		this.getCommand("reply").setExecutor(messenger);
	}
	
}
