package com.steelbite.hub.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.nametagedit.plugin.NametagEdit;
import com.steelbite.hub.Scoreboards;
import com.steelbite.hub.ZoneSelector;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("§8[§a+§8] §e" + player.getName() + " has entered the hub!");
		player.getInventory().clear();
		NametagEdit.getApi().setPrefix(player, "§9");
		ZoneSelector selector = new ZoneSelector(9, Material.COMPASS);
		selector.giveSelector(player, 0);
		Scoreboards.giveScoreboard(player);
	}
	

}
