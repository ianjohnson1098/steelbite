package com.steelbite.hub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.steelbite.hub.Main;

public class InventoryClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		if (event.getInventory().getName().equalsIgnoreCase("Zone Selector")) {
			event.setCancelled(true);
			if (!(event.getWhoClicked() instanceof Player))
				return;
			Player player = (Player) event.getWhoClicked();
			String server = event.getCurrentItem().getItemMeta().getDisplayName();
			player.closeInventory();
			player.sendMessage("§fTeleporting to " + server);
			if (server.contains("Helios"))
				Main.getPlugin().sendToServer(player, "helios");
		}
	}

}
