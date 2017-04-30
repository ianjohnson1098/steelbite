package com.steelbite.plugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.steelbite.plugin.listeners.PlayerListeners;

import commands.Message;

public class Main extends JavaPlugin implements Listener {
	
	private Message messenger;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
		messenger = new Message(this);
		this.getCommand("message").setExecutor(messenger);
		this.getCommand("reply").setExecutor(messenger);
	}
	
}
