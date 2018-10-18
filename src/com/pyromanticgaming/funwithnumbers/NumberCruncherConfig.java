package com.pyromanticgaming.funwithnumbers;


public class NumberCruncherConfig {

	private static FunWithNumbers plugin = NumberCruncher.getPlugin();
	public static void savenumbers() {
		for(String p : NumberCruncher.getJoinsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Joins", NumberCruncher.getJoinsMap().get(p));
		}
		for(String p : NumberCruncher.getBlockspMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlocksPlaced", NumberCruncher.getBlockspMap().get(p));
		}
		for(String p : NumberCruncher.getBlocksbMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".BlocksBroken", NumberCruncher.getBlocksbMap().get(p));
		}
		for(String p : NumberCruncher.getKillsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Kills", NumberCruncher.getKillsMap().get(p));
		}
		for(String p : NumberCruncher.getPVPDeathsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".PVPDeaths", NumberCruncher.getPVPDeathsMap().get(p));
		}
		for(String p : NumberCruncher.getDeathsMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".Deaths", NumberCruncher.getDeathsMap().get(p));
		}
		for(String p : NumberCruncher.getPlayTimeMap().keySet()) {
			plugin.getConfig().set("Players." + p + ".PlayTime", NumberCruncher.getPlayTimeMap().get(p));
		}
		plugin.saveConfig();
	}

	public static void loadnumbers() {
		if(!plugin.getConfig().contains("Players")) {
			return;
		}

		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setJoins(s, plugin.getConfig().getInt("Players." + s + ".Joins"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setBlocksBroken(s, plugin.getConfig().getInt("Players." + s + ".BlocksBroken"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setBlocksPlaced(s, plugin.getConfig().getInt("Players." + s + ".BlocksPlaced"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setPVPDeaths(s, plugin.getConfig().getInt("Players." + s + ".PVPDeaths"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setDeaths(s, plugin.getConfig().getInt("Players." + s + ".Deaths"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setTime(s, plugin.getConfig().getInt("Players." + s + ".PlayTime"));
		}
		for(String s : plugin.getConfig().getConfigurationSection("Players").getKeys(false)) {
			NumberCruncher.setKill(s, plugin.getConfig().getInt("Players." + s + ".Kills"));
		}

	}
}
