package com.pyromanticgaming.funwithnumbers;

/*
*Copyright (c) <2017>, <pyropyro78>, <pyropyro78@gmail.com>
*All rights reserved.
*
*THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

public class MainConfig {
	
	private static FunWithNumbers plugin;
	
	public MainConfig(FunWithNumbers instance) {
		plugin = instance;
	}
	
	public static long SaveTimer = 200;
	public static String playernotfound = " ", killbefore = " ", killafter = " ", timebefore = " ", timeafter = " ", blockpbefore = " ", blockpafter = " ", blockbbefore = " ", blockbafter = " ", joinbefore = " ", joinafter = " ", pvpdeathbefore = " ", pvpdeathafter = " ";
	
	public static void GetMainValues() {
		
		SaveTimer = plugin.getConfig().getLong("SaveTimer");
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
		playernotfound = plugin.getConfig().getString("PlayerNotFound");
	}


}