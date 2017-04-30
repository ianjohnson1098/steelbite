package com.steelbite.hub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ZoneSelector {
	
	private int slots;
	private Material material;
	
	public ZoneSelector(int slots, Material material) {
		this.slots = slots;
		this.material = material;
	}
	
	public void giveSelector(Player player, int slot) {
		ItemStack is = new ItemStack(material);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("§aZone Selector §7(Right Click)");
		List<String> lore = new ArrayList<String>();
		lore.add("§bChoose a zone to play...");
		im.setLore(lore);
		is.setItemMeta(im);
		
		player.getInventory().setItem(slot, is);
	}
	
	public void openSelector(Player player) {
		Inventory inv = Bukkit.createInventory(null, slots, "Zone Selector");
		
		List<String> lore = new ArrayList<String>();
		lore.add("§bClick to teleport...");
		
		ItemStack helios = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta heliosMeta = helios.getItemMeta();
		heliosMeta.setDisplayName("§6Helios Zone");
		heliosMeta.setLore(lore);
		helios.setItemMeta(heliosMeta);
		
		inv.setItem(0, helios);
		
		player.openInventory(inv);
		player.sendMessage("§bOpening selector...");
	}
	
}
