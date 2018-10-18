package com.pyromanticgaming.funwithnumbers;


public class MainConfig {
	
	private static FunWithNumbers plugin;
	
	public MainConfig(FunWithNumbers instance) {
		plugin = instance;
	}
	
	public static long SaveTimer = 200;
	public static String playernotfound = " ", timeseporator = " ", killbefore = " ", killafter = " ", timebefore = " ", timeafter = " ", blockpbefore = " ", blockpafter = " ", blockbbefore = " ", blockbafter = " ", joinbefore = " ", joinafter = " ", pvpdeathbefore = " ", pvpdeathafter = " ", deathbefore = " ", deathafter = " ";
	
	public static void GetMainValues() {
		
		SaveTimer = plugin.getConfig().getLong("SaveTimer");
		timeseporator = plugin.getConfig().getString("TimeSeporator");
		killbefore = plugin.getConfig().getString("KillBeforeText");
		killafter = plugin.getConfig().getString("KillAfterText");
		timebefore = plugin.getConfig().getString("TimeBeforeText");
		timeafter = plugin.getConfig().getString("TimeAfterText");
		blockpbefore = plugin.getConfig().getString("BlockPlaceBeforeText");
		blockpafter = plugin.getConfig().getString("BlockPlaceAfterText");
		blockbbefore = plugin.getConfig().getString("BlockBreakBeforeText");
		blockbafter = plugin.getConfig().getString("BlockBreakAfterText");
		joinbefore = plugin.getConfig().getString("JoinBeforeText");
		joinafter = plugin.getConfig().getString("JoinAfterText");
		pvpdeathbefore = plugin.getConfig().getString("PVPDeathBeforeText");
		pvpdeathafter = plugin.getConfig().getString("PVPDeathAfterText");
		deathbefore = plugin.getConfig().getString("DeathBeforeText");
		deathafter = plugin.getConfig().getString("DeathAfterText");
		playernotfound = plugin.getConfig().getString("PlayerNotFound");
	}


}