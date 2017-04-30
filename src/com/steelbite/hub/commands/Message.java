package com.steelbite.hub.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.steelbite.hub.Main;

public class Message implements CommandExecutor {
	
	private HashMap<String, String> conversations = new HashMap<String, String>();
	
	@SuppressWarnings("unused")
	private final Main plugin;
	
	public Message(Main plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String args[]) {
		if (cmdLabel.equalsIgnoreCase("message") || cmdLabel.equalsIgnoreCase("msg") || cmdLabel.equalsIgnoreCase("m") || cmdLabel.equalsIgnoreCase("whisper") || cmdLabel.equalsIgnoreCase("w") || cmdLabel.equalsIgnoreCase("tell") || cmdLabel.equalsIgnoreCase("t")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cOnly players can send messages!");
				return true;
			}
			Player player = (Player) sender;
			if (args.length < 2) {
				player.sendMessage("§cInvalid arguments! Usage: /message {player} {message}");
				return true;
			}
			if (args[0].equalsIgnoreCase(player.getName())) {
				player.sendMessage("§cYou cannot send messages to yourself!");
				return true;
			}
			if (Bukkit.getPlayer(args[0]) == null) {
				player.sendMessage("§c" + args[0] + " is not online!");
				return true;
			}
			Player receiver = Bukkit.getPlayer(args[0]);
			conversations.remove(receiver.getName());
			conversations.put(receiver.getName(), player.getName());
			String message = "";
			for (int i = 1; i < args.length; i++) {
				message += " " + args[i];
			}
			player.sendMessage("§6To " + receiver.getName() + message);
			receiver.sendMessage("§6From " + player.getName() + message);
		} else if (cmdLabel.equalsIgnoreCase("reply") || cmdLabel.equalsIgnoreCase("r")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cOnly players can send messages!");
				return true;
			}
			Player player = (Player) sender;
			if (!(conversations.containsKey((player.getName())))) {
				player.sendMessage("§cYou do not have anyone to reply to!");
				return true;
			}
			if (args.length < 1) {
				player.sendMessage("§cInvalid arguments! Usage: /reply {message}");
				return true;
			}
			if (Bukkit.getPlayer(conversations.get(player.getName())) == null) {
				player.sendMessage("§c" + conversations.get(player.getName()) + " is not online!");
				return true;
			}
			Player receiver = Bukkit.getPlayer(conversations.get(player.getName()));
			conversations.remove(receiver.getName());
			conversations.put(receiver.getName(), player.getName());
			String message = "";
			for (int i = 0; i < args.length; i++) {
				message += " " + args[i];
			}
			player.sendMessage("§6To " + receiver.getName() + message);
			receiver.sendMessage("§6From " + player.getName() + message);
		}
		return false;
	}

}
