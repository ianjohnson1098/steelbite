package com.steelbite.hub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat  implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		event.setFormat("§9" + event.getPlayer().getName() + "§8: §f" + event.getMessage());
	}
	
}
