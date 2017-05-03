package com.steelbite.hub;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboards {
	
	public static void giveScoreboard(Player player) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("test", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§8§l[§9§lSteelBite§8§l]");
		Score spacer1 = obj.getScore("§a");
		Score hub = obj.getScore("§aHub §7- §b" + Bukkit.getOnlinePlayers().size());
		Score helios = obj.getScore("§fHelios §7- §b0");
		Score spacer2 = obj.getScore("§b");
		Score site = obj.getScore("§cwww.steelbite.com");
		Score spacer3 = obj.getScore("§c");
		spacer3.setScore(0);
		site.setScore(1);
		spacer2.setScore(2);
		helios.setScore(4);
		hub.setScore(5);
		spacer1.setScore(6);
		player.setScoreboard(board);
	}
	
	public static void startUpdater() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers())
					giveScoreboard(player);
			}
		}, 0L, 20L);
	}

}
