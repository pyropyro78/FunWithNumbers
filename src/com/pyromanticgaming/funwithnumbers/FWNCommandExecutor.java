package com.pyromanticgaming.funwithnumbers;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FWNCommandExecutor implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("fwn")) { //Checks for command /tms

			boolean canCheckSelf = sender.hasPermission("FunWithNumbers.check.self")
					|| sender.isOp();
			boolean canCheckOther = sender.hasPermission("FunWithNumbers.check.other")
					|| sender.isOp();

			String senderstring = sender.getName();

			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("stats")) {
					if ((args.length == 1) && sender instanceof Player) {

						if (!canCheckSelf) {
							sender.sendMessage("Fun With Numbers - You lack permissions for that.");
							return true;
						}

						sender.sendMessage(MainConfig.pvpdeathbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.pvpdeaths.get(senderstring) + MainConfig.pvpdeathafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.deathbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.deaths.get(senderstring) + MainConfig.deathafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.killbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.kills.get(senderstring) + MainConfig.killafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.blockbbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksb.get(senderstring) + MainConfig.blockbafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.blockpbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksp.get(senderstring) + MainConfig.blockpafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.joinbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.joins.get(senderstring) + MainConfig.joinafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));

						Integer PlayTimeSec = NumberCruncher.playtime.get(senderstring);
						Integer PlayTimeHour = (int) (Math.floor(PlayTimeSec / 60) / 60); // gets hours rounds down
						PlayTimeSec = PlayTimeSec - ((PlayTimeHour * 60) * 60); // subtracts hours seconds
						Integer PlayTimeMin = (int) Math.floor(PlayTimeSec / 60); // gets min rounds down
						PlayTimeSec = PlayTimeSec - (PlayTimeMin * 60); // subtracts mins seconds

						sender.sendMessage(MainConfig.timebefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeHour + MainConfig.timeseporator.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeMin + MainConfig.timeseporator.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeSec + MainConfig.timeafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));

						return true;
					}
					if (args.length == 2) {

						if (!canCheckOther) {
							sender.sendMessage("Fun With Numbers - You lack permissions for that.");
							return true;
						}

						if (NumberCruncher.hasJoined(args[1])) {
							sender.sendMessage(MainConfig.pvpdeathbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.pvpdeaths.get(args[1]) + MainConfig.pvpdeathafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							sender.sendMessage(MainConfig.deathbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.deaths.get(args[1]) + MainConfig.deathafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							sender.sendMessage(MainConfig.killbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.kills.get(args[1]) + MainConfig.killafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							sender.sendMessage(MainConfig.blockbbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksb.get(args[1]) + MainConfig.blockbafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							sender.sendMessage(MainConfig.blockpbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksp.get(args[1]) + MainConfig.blockpafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							sender.sendMessage(MainConfig.joinbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.joins.get(args[1]) + MainConfig.joinafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));

							Integer PlayTimeSec = NumberCruncher.playtime.get(args[1]);
							Integer PlayTimeHour = (int) (Math.floor(PlayTimeSec / 60) / 60); // gets hours rounds down
							PlayTimeSec = PlayTimeSec - ((PlayTimeHour * 60) * 60); // subtracts hours seconds
							Integer PlayTimeMin = (int) Math.floor(PlayTimeSec / 60); // gets min rounds down
							PlayTimeSec = PlayTimeSec - (PlayTimeMin * 60); // subtracts mins seconds

							sender.sendMessage(MainConfig.timebefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeHour + MainConfig.timeseporator.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeMin + MainConfig.timeseporator.replaceAll("(&([a-f0-9]))", "\u00A7$2") + PlayTimeSec + MainConfig.timeafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							return true;
						}
						sender.sendMessage(MainConfig.playernotfound);
						return true;
					}

				}

				if (sender instanceof Player) {
					sender.sendMessage("Fun With Numbers - Improper command use");
					sender.sendMessage("/fwn stats - Checks your stats");
					sender.sendMessage("/fwn stats [Player] - Checks a player's stats");
					return true;
				} else {
					sender.sendMessage("Fun With Numbers - Improper command use");
					sender.sendMessage("------------------------------");
					sender.sendMessage("Concolse Enabled Commands");
					sender.sendMessage("/fwn stats [Player] - Checks a players stats");
					return true;
				}
			}

		}
		return true;
	}
}
