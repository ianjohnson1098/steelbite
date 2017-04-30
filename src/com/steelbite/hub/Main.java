package com.steelbite.hub;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.steelbite.hub.commands.Message;
import com.steelbite.hub.listeners.InventoryClick;
import com.steelbite.hub.listeners.PlayerChat;
import com.steelbite.hub.listeners.PlayerInteract;
import com.steelbite.hub.listeners.PlayerJoin;
import com.steelbite.hub.listeners.PlayerQuit;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	private Message messenger;
	
	@Override
	public void onEnable() {
		Main.setPlugin(this);
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerChat(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		this.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		
		messenger = new Message(this);
		
		this.getCommand("message").setExecutor(messenger);
		this.getCommand("reply").setExecutor(messenger);
	}
	
	public void sendToServer(Player player, String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
	}

	public static Main getPlugin() {
		return plugin;
	}

	public static void setPlugin(Main plugin) {
		Main.plugin = plugin;
	}
	
}
