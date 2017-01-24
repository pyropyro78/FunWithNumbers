package com.pyromanticgaming.funwithnumbers;

/*
 *Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
 *All rights reserved.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
			NumberCruncher.blocksb.put(p, 0);
			NumberCruncher.blocksp.put(p, 0);
			NumberCruncher.deaths.put(p, 0);
			NumberCruncher.kills.put(p, 0);
			NumberCruncher.playtime.put(p, 0);

		}

	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player victim = e.getEntity();
			Player killer = e.getEntity().getKiller();

			NumberCruncher.addDeath(victim.getName());
			NumberCruncher.addKill(killer.getName());

			return;
		}
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
