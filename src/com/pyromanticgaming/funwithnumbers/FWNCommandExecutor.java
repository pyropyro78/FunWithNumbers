package com.pyromanticgaming.funwithnumbers;

/*
*Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

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
			
			if (args.length > 0 && sender.hasPermission("FunWithNumbers.*")) {
				if (args[0].equalsIgnoreCase("stats")) {
					if ((args.length == 1) && canCheckSelf && sender instanceof Player) {
						sender.sendMessage(MainConfig.pvpdeathbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.deaths.get(senderstring) + MainConfig.pvpdeathafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.killbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.kills.get(senderstring) + MainConfig.killafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.blockbbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksb.get(senderstring) + MainConfig.blockbafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.blockpbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.blocksp.get(senderstring) + MainConfig.blockpafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						sender.sendMessage(MainConfig.joinbefore.replaceAll("(&([a-f0-9]))", "\u00A7$2") + NumberCruncher.joins.get(senderstring) + MainConfig.joinafter.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						
						Integer PlayTimeSec = NumberCruncher.playtime.get(senderstring);
						Integer PlayTimeHour = (int) (Math.floor(PlayTimeSec / 60) / 60); // gets hours rounds down
						PlayTimeSec = PlayTimeSec - ((PlayTimeHour * 60) * 60); // subtracts hours seconds
						Integer PlayTimeMin = (int) Math.floor(PlayTimeSec / 60); // gets min rounds down
						PlayTimeSec = PlayTimeSec - (PlayTimeMin * 60); // subtracts mins seconds
						
						String PlayTime = PlayTimeHour + MainConfig.timeseporator + PlayTimeMin + MainConfig.timeseporator + PlayTimeSec;
						
						sender.sendMessage(MainConfig.timebefore + PlayTime + MainConfig.timeafter);
						return true;
					}
					if (args.length == 2 && canCheckOther) {
						
						if (NumberCruncher.hasJoined(args[1])) {
							sender.sendMessage(MainConfig.pvpdeathbefore + NumberCruncher.deaths.get(args[1]) + MainConfig.pvpdeathafter);
							sender.sendMessage(MainConfig.killbefore + NumberCruncher.kills.get(args[1]) + MainConfig.killafter);
							sender.sendMessage(MainConfig.blockbbefore + NumberCruncher.blocksb.get(args[1]) + MainConfig.blockbafter);
							sender.sendMessage(MainConfig.blockpbefore + NumberCruncher.blocksp.get(args[1]) + MainConfig.blockpafter);
							sender.sendMessage(MainConfig.joinbefore + NumberCruncher.joins.get(args[1]) + MainConfig.joinafter);
							
							Integer PlayTimeSec = NumberCruncher.playtime.get(args[1]);
							Integer PlayTimeHour = (int) (Math.floor(PlayTimeSec / 60) / 60); // gets hours rounds down
							PlayTimeSec = PlayTimeSec - ((PlayTimeHour * 60) * 60); // subtracts hours seconds
							Integer PlayTimeMin = (int) Math.floor(PlayTimeSec / 60); // gets min rounds down
							PlayTimeSec = PlayTimeSec - (PlayTimeMin * 60); // subtracts mins seconds
							
							sender.sendMessage(MainConfig.timebefore + PlayTimeHour + MainConfig.timeseporator + PlayTimeMin + MainConfig.timeseporator + PlayTimeSec + MainConfig.timeafter);
							return true;
						}
						sender.sendMessage(MainConfig.playernotfound);
						return true;
					}
					
				}
			}
			if (sender instanceof Player) {
			sender.sendMessage("FunWithNumbers - Improper command use");
			sender.sendMessage("/fwn stats - Checks your stats");
			sender.sendMessage("/fwn stats [Player] - Checks a player's stats");
			return true;
			} else {
				sender.sendMessage("FunWithNumbers - Improper command use");
				sender.sendMessage("------------------------------");
				sender.sendMessage("Concolse Enabled Commands");
				sender.sendMessage("/fwn stats [Player] - Checks a players stats");
			}
			
		}
		return true;
	}
}
