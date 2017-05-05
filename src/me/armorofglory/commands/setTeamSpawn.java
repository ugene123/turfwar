package me.armorofglory.commands;

import me.armorofglory.config.ConfigAccessor;
import me.armorofglory.handlers.Team;
import me.armorofglory.utils.ChatUtils;
import me.armorofglory.utils.LocationUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setTeamSpawn {
  
	public static boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    
		if ((sender instanceof Player)) {
	      
			String team = args[1].toUpperCase();
	    
			if (Team.containsInAllTeams(team))  {
		        Player player = (Player)sender;
		        Location loc = player.getLocation();
		        String world = loc.getWorld().getName();
		        double x = loc.getX();
		        double y = loc.getY();
		        double z = loc.getZ();
		        double yaw = loc.getYaw();
		        double pitch = loc.getPitch();
		        
		        String spawn = world + ", " + x + ", " + y + ", " + z + ", " + yaw + ", " + pitch;
		        ConfigAccessor.storeString("Teams." + team + ".Location", spawn);
		        ChatUtils.msgPlayer(player, "Team " + team + " spawn has been set!");
		        Location teamspawn = LocationUtils.getTeamSpawn(team);
		        Team.addTeamLocation(team, teamspawn);
			}
			else {
				
				ChatUtils.msgSender(sender, "Team " + team + " does not exist!");
				
			}
		}
	    else
	    {
	      ChatUtils.msgSender(sender, "You can only use this command in-game!");
	    }
	    return false;
	  }
}
