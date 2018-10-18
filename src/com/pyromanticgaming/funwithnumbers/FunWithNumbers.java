package com.pyromanticgaming.funwithnumbers;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class FunWithNumbers extends JavaPlugin implements Listener {




	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents((Listener) this, this);

		this.saveDefaultConfig();
		new MainConfig(this);
		MainConfig.GetMainValues();

		getCommand("fwn").setExecutor(new FWNCommandExecutor());

		new NumberCruncher(this);
		NumberCruncherConfig.loadnumbers();

		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for (Player player1 : Bukkit.getServer().getOnlinePlayers()) {

					NumberCruncher.addTime(player1.getName());

				}
			}
		}, 0L, 20L);

		getLogger().info("Fun With Numbers has been enabled.");

		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				NumberCruncherConfig.savenumbers();

			}
		}, MainConfig.SaveTimer, MainConfig.SaveTimer);

	}

	@Override
	public void onDisable() {
		NumberCruncherConfig.savenumbers();
		getLogger().info("Fun With Numbers has been disabled.");

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		String p = event.getPlayer().getName();

		if (NumberCruncher.hasJoined(p)) {

			NumberCruncher.addJoins(p);
		} else {

			NumberCruncher.joins.put(p, 1);

		}
		if (!NumberCruncher.hasBrokenBlocks(p)) {

			NumberCruncher.blocksb.put(p, 0);

		}
		if (!NumberCruncher.hasPlaceBlocks(p)) {

			NumberCruncher.blocksp.put(p, 0);

		}
		if (!NumberCruncher.hasPVPDied(p)) {

			NumberCruncher.pvpdeaths.put(p, 0);

		}
		if (!NumberCruncher.hasDied(p)) {

			NumberCruncher.deaths.put(p, 0);

		}
		if (!NumberCruncher.hasKilled(p)) {

			NumberCruncher.kills.put(p, 0);

		}
		if (!NumberCruncher.hasPlaytime(p)) {

			NumberCruncher.playtime.put(p, 0);

		}



	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {

		Player victim = e.getEntity();

		if (e.getEntity().getKiller() instanceof Player) {

			Player killer = e.getEntity().getKiller();

			NumberCruncher.addPVPDeath(victim.getName());
			NumberCruncher.addKill(killer.getName());

		}

		NumberCruncher.addDeath(victim.getName());

		return;

	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = (Player) event.getPlayer();

		NumberCruncher.addBlocksBroken(p.getName());

	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player p = (Player) event.getPlayer();

		NumberCruncher.addBlocksPlaced(p.getName());

	}

}
