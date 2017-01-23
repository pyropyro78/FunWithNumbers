package com.pyromanticgaming.funwithnumbers;

/*
*Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

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
