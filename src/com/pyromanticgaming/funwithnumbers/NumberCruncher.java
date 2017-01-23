package com.pyromanticgaming.funwithnumbers;

/*
*Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import java.util.HashMap;

public class NumberCruncher {
	
	private static FunWithNumbers plugin;
	
	public NumberCruncher(FunWithNumbers instance) {
		plugin = instance;
	}
	
	public static HashMap<String, Integer> blocksp = new HashMap<>();
	public static HashMap<String, Integer> blocksb = new HashMap<>();
	public static HashMap<String, Integer> kills = new HashMap<>();
	public static HashMap<String, Integer> deaths = new HashMap<>();
	public static HashMap<String, Integer> joins = new HashMap<>();
	public static HashMap<String, Integer> playtime = new HashMap<>();
	
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

	public static boolean hasJoined(String player) {
		
		return joins.containsKey(player);
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
