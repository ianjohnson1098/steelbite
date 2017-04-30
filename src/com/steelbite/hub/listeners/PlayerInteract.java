package com.steelbite.hub.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.steelbite.hub.ZoneSelector;

public class PlayerInteract implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aZone Selector §7(Right Click)")) {
			if (!(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
				return;
			ZoneSelector selector = new ZoneSelector(9, Material.COMPASS);
			selector.openSelector(player);
		}
	}

}
