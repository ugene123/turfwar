package me.armorofglory.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.armorofglory.Turfwar;
import me.armorofglory.utils.ChatUtils;

public class PluginCommandExecutor implements CommandExecutor {

	public PluginCommandExecutor(Turfwar warfare) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		
		// If base command is 'tw' for turf wars
		if(cmd.getName().equalsIgnoreCase("turfwar")) {
			
			if(args.length == 0) {
				Help.onCommand(sender, cmd, label, args);
				return true;
			}
			
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("help")) {
					Help.onCommand(sender, cmd, label, args);
					return true;
					
				} else if(args[0].equalsIgnoreCase("setlobby")) {
					setLobby.onCommand(sender, cmd, label, args);
					return true;	
					
				} else if(args[0].equalsIgnoreCase("savearena")) {
					saveArena.onCommand(sender, cmd, label, args);
					return true;	
				
				} else if(args[0].equalsIgnoreCase("forcestop")) {
					forceStop.onCommand(sender, cmd, label, args);
					return true;	
				
				} else if(args[0].equalsIgnoreCase("forcestart")) {
					forceStart.onCommand(sender, cmd, label, args);
					return true;	
				
				
				
				// not enough arguements
				
				} else if(args[0].equalsIgnoreCase("setteamspawn")) {
					ChatUtils.msgSender(sender, "You must specify the team!" + ChatColor.YELLOW +  " /tw setteamspawn <team>");
					return true;
					
				} else if(args[0].equalsIgnoreCase("addteam")) {
					ChatUtils.msgSender(sender, "You must specify the team!" + ChatColor.YELLOW +  " /tw addteam <team>");
					return true;
				
				} else if(args[0].equalsIgnoreCase("delteam")) {
					ChatUtils.msgSender(sender, "You must specify the team!" + ChatColor.YELLOW +  "  /tw delteam <team>");
					return true;
				
				} else if(args[0].equalsIgnoreCase("setteamblock")) {
					ChatUtils.msgSender(sender, "You must specify the team!" + ChatColor.YELLOW +  " /tw setteamblock <team>");
					return true;
				
				} else if(args[0].equalsIgnoreCase("setteamspawn")) {
					ChatUtils.msgSender(sender, "You must specify the team!" + ChatColor.YELLOW +  " /tw setteamspawn <team>");
					return true;
				
				} else if(args[0].equalsIgnoreCase("setcorner")) {
					ChatUtils.msgSender(sender, "You must specify which corner!" + ChatColor.YELLOW +  " /tw setcorner <#>");
					return true;
				}
				
				else if(args[0].equalsIgnoreCase("setkit")) {
					ChatUtils.msgSender(sender, "You must specify a kit name!" + ChatColor.YELLOW +  " /tw setkit <kitname>");
					return true;
				
				}
				else if(args[0].equalsIgnoreCase("getkit")) {
					ChatUtils.msgSender(sender, "You must specify a kit name!" + ChatColor.YELLOW +  " /tw getkit <kitname>");
					return true;
					
				}
				
				else {
					// First Arguement is not a valid command
					ChatUtils.msgSender(sender, "That is not a valid command! See " + ChatColor.YELLOW + "/turfwar help");
					return true;
				}
			}
			
			if(args.length == 2) {
				
				if(args[0].equalsIgnoreCase("setteamspawn")) {
					setTeamSpawn.onCommand(sender, cmd, label, args);
				}
				
				else if(args[0].equalsIgnoreCase("addteam")) {
					addTeam.onCommand(sender, cmd, label, args);
					return true;
				
				}
				
				else if(args[0].equalsIgnoreCase("delteam")) {
					removeTeam.onCommand(sender, cmd, label, args);
					return true;
				}
				
				else if(args[0].equalsIgnoreCase("setteamblock")) {
					setTeamBlock.onCommand(sender, cmd, label, args);
					return true;
				}
				
				else if(args[0].equalsIgnoreCase("setcorner")) {
					setCorner.onCommand(sender, cmd, label, args);
					return true;
				}
				
				else if(args[0].equalsIgnoreCase("setkit")) {
					setKit.onCommand(sender, cmd, label, args);
					return true;
				
				}
				else if(args[0].equalsIgnoreCase("getkit")) {
					getKit.onCommand(sender, cmd, label, args);
					return true;
				
				}
				
			}
		
		}
		return false;
	}
}


