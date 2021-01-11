package com.blalp.pexwrapper;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class PexWrapper extends JavaPlugin {
	public static boolean verbose;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// No need to check for permissions here, as we will be executing the command as
		// the player anyways
		if (command.getName().equals("permissionsex")) {
			String lpCommand = "luckperms ";
			// Now translate the pex command into the luckperms style
			lpCommand = translateCommand(args);
			if (lpCommand == null) {
				sender.sendMessage(ChatColor.RED + "Unsupported pex to lp mapping");
				showHelp(sender);
				System.out.println(sender.getName() + " attempted to call the pex command " + join(args)
						+ " but not valid mapping exists.");
				return false;
			}
			for (String executeCommand : lpCommand.split("\n")) {
				Bukkit.getServer().dispatchCommand(sender, executeCommand);
			}
			sender.sendMessage("Ran " + lpCommand + " on your behalf.");
			return true;
		}
		return false;
	}

	public static String translateCommand(String[] args) {
		String output = "luckperms ";
		// Now translate the pex command into the luckperms style
		// Start by parsing the general non user/group related commands by length
		if (args.length == 0) {
			output = "luckperms";
		} else if (args.length == 1) {
			if (args[0].equals("reload")) {
				output += "sync";
			} else if (args[0].equals("backend")) {
				output += "info";
			}
		} else if (args.length == 2) {
			if (args[0].equals("toggle") && args[1].equals("debug")) {
				output += "verbose ";
				if (verbose) {
					output += "off";
				} else {
					output += "on";
				}
				verbose = !verbose;
			} else if (args[0].equals("groups") && args[1].equals("list")) {
				output += "listgroups";
			}
		}
		if (args.length >= 2 && (args[0].equals("user") || args[0].equals("group"))) {
			// Now Start doing through the user/group related commands by length.
			// Add user/group and name to the command
			output += args[0] + " " + args[1] + " ";
			if (args.length == 2) {
				output += "info";
			} else if (args.length >= 3) {
				if (args[2].equals("check")) {
					if (args.length == 4) {
						output += "haspermission " + args[3];
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("list")) {
					output += "permission info";
				} else if (args[2].equals("prefix") || args[2].equals("suffix")) {
					if (args.length == 3) {
						// Just get the prefix
						output += "meta info";
					} else {
						// Set the prefix
						output += "meta set" + args[2] + " 999999 " + translatePrefix(args, 3);
						if (args[3].equals("\"\"")) {
							output += "\nluckperms " + args[0] + " " + args[1] + " meta remove" + args[2] + " 999999 "
									+ translatePrefix(args, 3);
						}
					}
				} else if (args[2].equals("delete")) {
					if (args[0].equals("user")) {
						output += "clear";
					} else if (args[0].equals("group")) {
						output = "luckperms deletegroup " + args[1];
					}
				} else if (args[2].equals("add") || args[2].equals("remove")) {
					if (args.length >= 4) {
						output += "permission ";
						if (args[2].equals("add")) {
							output += "set";
						} else if (args[2].equals("remove")) {
							output += "unset";
						} else {
							// If nothing is matched we need to quit
							return null;
						}
						output += " " + translatePermission(args[3], args[2].equals("add"));
						if (args.length == 5) {
							// Has optional world argument
							output += " world=" + args[4];
						}
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("timed")) {
					if (args[3].equals("add") || args[3].equals("remove")) {
						if (args.length >= 6) {
							output += "permission ";
							if (args[3].equals("add")) {
								output += "settemp ";
							} else if (args[3].equals("remove")) {
								output += "unsettemp ";
							} else {
								// If nothing is matched we need to quit
								return null;
							}
							output += translatePermission(args[4], args[3].equals("add"));
							if (args[3].equals("add")) {
								try {
									// If its given as a number, the user means to have that be in seconds
									output += " " + Integer.parseInt(args[5]) + "s";
								} catch (NumberFormatException e) {
									// If not it must be some sort of valid time unit. In w d h m s syntax (like
									// 1w2d3h4m5s 1 week 2 days 3 hours 4 minutes 5 seconds (notice there is no
									// months))
									output += " " + args[5];
								}
							}
							if (args.length == 7) {
								// Has optional world argument
								output += " world=" + args[6];
							}
						} else {
							// If nothing is matched we need to quit
							return null;
						}
					}
				} else if (args[2].equals("set")) {
					if (args.length >= 5) {
						output += "meta set " + args[3] + " " + args[4];
						if (args.length == 6) {
							// Optional world
							output += " world=" + args[5];
						}
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("group")) {
					if (args.length >= 4) {
						output += "parent ";
						if (args[3].equals("list")) {
							output += "info";
						} else if (args[3].equals("add")) {
							if (args.length >= 5) {
								if (args.length == 7) {
									output += "addtemp ";
								} else {
									output += "add ";
								}
								output += args[4];
								if (args.length == 7) {
									try {
										// If its given as a number, the user means to have that be in seconds
										output += " " + Integer.parseInt(args[6]) + "s";
									} catch (NumberFormatException e) {
										// If not it must be some sort of valid time unit. In w d h m s syntax (like
										// 1w2d3h4m5s 1 week 2 days 3 hours 4 minutes 5 seconds (notice there is no
										// months))
										output += " " + args[6];
									}
								}
								if (args.length >= 6) {
									// Optional World
									output += " world=" + args[5];
								}
							} else {
								// If nothing is matched we need to quit
								return null;
							}
						} else if (args[3].equals("set")) {
							if (args.length == 5) {
								output += args[3] + " " + args[4];
							} else {
								// If nothing is matched we need to quit
								return null;
							}
						} else if (args[3].equals("remove")) {
							if (args.length >= 5) {
								output += args[3] + " " + args[4];
								if (args.length == 6) {
									// Optional world
									output += " world=" + args[5];
								}
							} else {
								// If nothing is matched we need to quit
								return null;
							}
						} else {
							// If nothing is matched we need to quit
							return null;
						}
					}
				} else if ((args[2].equals("create") || args[2].equals("delete")) && args[0].equals("group")) {
					if (args.length == 3) {
						output = "luckperms " + args[2] + "group " + args[1];
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("parents") && args[0].equals("group")) {
					if (args.length == 4 && args[3].equals("list")) {
						output += "parent info";
					} else if (args.length == 5 && args[3].equals("set")) {
						String origOutput = output;
						boolean first = true;
						for (String parent : args[4].split(",")) {
							if (first) {
								first = false;
							} else {
								output += "\n" + origOutput;
							}
							output += "parent add " + parent;
						}
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("users") && args[0].equals("group")) {
					if (args.length == 3) {
						output += "listmembers";
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else if (args[2].equals("user") && args[0].equals("group")) {
					if (args.length == 5) {
						output = "luckperms user " + args[4] + " parent " + args[3] + " " + args[1];
					} else {
						// If nothing is matched we need to quit
						return null;
					}
				} else {
					// If nothing is matched we need to quit
					return null;
				}
			} else {
				// If nothing is matched we need to quit
				return null;
			}
		} else if (args.length == 3 && (args[0].equals("promote") || args[0].equals("demote"))) {
			output += "user " + args[1] + " " + args[0] + " " + args[2];
		}
		if (output.equals("luckperms ")) {
			return null;
		}
		return output;
	}

	public static void showHelp(CommandSender sender) {
		sender.sendMessage(ChatColor.YELLOW + "Supported mappings are: ");
		sender.sendMessage(ChatColor.YELLOW + "/pex [user/group] <USERNAME/GROUP>");
		sender.sendMessage(ChatColor.YELLOW + "/pex [user/group] <USERNAME/GROUP> [add/remove] <PERMISSION>");
		sender.sendMessage(ChatColor.YELLOW + "/pex [user/group] <USERNAME/GROUP> [prefix/suffix] <PREFIX>");
		sender.sendMessage(ChatColor.YELLOW + "/pex [user/group] <USERNAME/GROUP> [prefix/suffix] \"\"");
		sender.sendMessage(ChatColor.YELLOW + "/pex user <USERNAME/GROUP> group [add/set/remove] <GROUP>");
		sender.sendMessage(ChatColor.YELLOW + "https://luckperms.net/wiki/GM-&-PEX-Command-Equivalents#permissionsex");
	}

	public static String translatePermission(String permission, boolean includeBool) {
		if (permission.startsWith("-")) {
			if (includeBool) {
				return permission.substring(1) + " false";
			} else {
				return permission.substring(1);
			}
		} else {
			return permission;
		}
	}

	public static String translatePrefix(String[] args, int start) {
		if (args[start].startsWith("\"")) {
			return join(args, start).replaceAll("$.*?(\".*?\").*^", "\1");
		} else {
			return args[start];
		}
	}

	public static String join(String[] arr) {
		return join(arr, 0);
	}

	public static String join(String[] arr, int start) {
		boolean first = true;
		String output = "";
		for (int i = start; i < arr.length; i++) {
			if (first) {
				first = false;
			} else {
				output += " ";
			}
			output += arr[i];
		}
		return output;
	}
}