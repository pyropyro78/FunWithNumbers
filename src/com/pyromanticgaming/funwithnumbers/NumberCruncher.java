package com.pyromanticgaming.funwithnumbers;


import java.util.HashMap;

public class NumberCruncher {

	private static FunWithNumbers plugin;

	public NumberCruncher(FunWithNumbers instance) {
		plugin = instance;
	}

	public static HashMap<String, Integer> blocksp = new HashMap<>();
	public static HashMap<String, Integer> blocksb = new HashMap<>();
	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> pvpdeaths = new HashMap<>();
	public static HashMap<String, Integer> deaths = new HashMap<>();
	public static HashMap<String, Integer> joins = new HashMap<>();
	public static HashMap<String, Integer> playtime = new HashMap<>();

	public static void addPVPDeath(String player) {
		pvpdeaths.put(player, pvpdeaths.get(player) + 1);
	}

	public static void addDeath(String player) {
		deaths.put(player, deaths.get(player) + 1);
	}

	public static void addKill(String player) {
		kills.put(player, kills.get(player) + 1);
	}

	public static void addJoins(String player) {
		joins.put(player, joins.get(player) + 1);
	}

	public static void addTime(String player) {
		playtime.put(player, playtime.get(player) + 1);
	}

	public static void addBlocksPlaced(String player) {
		blocksp.put(player, blocksp.get(player) + 1);
	}

	public static void addBlocksBroken(String player) {
		blocksb.put(player, blocksb.get(player) + 1);
	}



	public static void setPVPDeaths(String player, int amount) {
		pvpdeaths.put(player,  amount);
	}

	public static void setDeaths(String player, int amount) {
		deaths.put(player,  amount);
	}

	public static void setKill(String player, int amount) {
		kills.put(player,  amount);
	}

	public static void setJoins(String player, int amount) {
		joins.put(player,  amount);
	}

	public static void setTime(String player, int amount) {
		playtime.put(player,  amount);
	}

	public static void setBlocksPlaced(String player, int amount) {
		blocksp.put(player,  amount);
	}

	public static void setBlocksBroken(String player, int amount) {
		blocksb.put(player,  amount);
	}



	public static boolean hasPVPDied(String player) {

		return pvpdeaths.containsKey(player);
	}

	public static boolean hasDied(String player) {

		return deaths.containsKey(player);
	}

	public static boolean hasKilled(String player) {

		return kills.containsKey(player);
	}

	public static boolean hasJoined(String player) {

		return joins.containsKey(player);
	}

	public static boolean hasPlaytime(String player) {

		return playtime.containsKey(player);
	}

	public static boolean hasPlaceBlocks(String player) {

		return blocksp.containsKey(player);
	}

	public static boolean hasBrokenBlocks(String player) {

		return blocksb.containsKey(player);
	}



	public static HashMap<String, Integer> getJoinsMap() {

		return joins;
	}

	public static HashMap<String, Integer> getBlockspMap() {

		return blocksp;
	}

	public static HashMap<String, Integer> getBlocksbMap() {

		return blocksb;
	}

	public static HashMap<String, Integer> getKillsMap() {

		return kills;
	}

	public static HashMap<String, Integer> getPVPDeathsMap() {

		return pvpdeaths;
	}

	public static HashMap<String, Integer> getDeathsMap() {

		return deaths;
	}

	public static HashMap<String, Integer> getPlayTimeMap() {

		return playtime;
	}




	public static FunWithNumbers getPlugin() {

		return plugin;
	}

}
