package me.ezplugin.Commands;

import me.ezplugin.Enums.Resources;
import me.ezplugin.GUI.GUIS.CheatGUI;
import me.ezplugin.Items.Items.ArmorItems;
import me.ezplugin.Items.Items.MaterialItems;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Items.Items.PickaxeItems;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Commands implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
                if (!(sender instanceof Player)) {
            sender.sendMessage("No");
            return true;
        } if(cmd.getName().equalsIgnoreCase("EzMiner")) {
                    if(args.length == 0) {
                            player.openInventory(ForgeGUI.FORGEGUI(player));

                    } else {
                        if(args[0].equalsIgnoreCase("Forge")) {
                            player.openInventory(ForgeGUI.FORGEGUI(player));
                        } else if(args[0].equalsIgnoreCase("cheat")) {
                            if (player.hasPermission("EzMiner.*")) {
                                player.openInventory(CheatGUI.CheatGUI());
                            }
                        } else if(args[0].equalsIgnoreCase("Stats")) {
                            if (args.length < 2) {
                                player.sendMessage("§b" + player.getName() + "'s stats:" + "\n§cLevel: " + StatUtils.getHashLevel(player) + "\n§cXP: " + StatUtils.getHashXP(player));
                            } else {
                                Player Target = Bukkit.getPlayer(args[1]);
                                if (Target != null) {
                                    int XP = StatUtils.getHashXP(player);
                                    int LEVEL = StatUtils.getHashLevel(player);
                                    player.sendMessage("§b" + Target.getName() + "'s stats:" + "\n§cLevel: " + LEVEL + "\n§cXP: " + XP);
                                } else {
                                    player.sendMessage("§cThat is not a valid player.");
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("Reset")) {
                            if (player.hasPermission("EzMiner.Reset")) {
                                StatUtils.setHashXP(player, 0);
                                StatUtils.setHashLevel(player, 1);
                                player.sendMessage("§aReset xp!");
                            }
                        } else if(args[0].equalsIgnoreCase("Set")) {
                            if(player.hasPermission("EzMiner.Set")) {
                                if (args.length != 4) {
                                    player.sendMessage("§cCorrect usage /set <Player> <LEVEL> <XP>");
                                } else {
                                    Player Target = Bukkit.getPlayer(args[1]);
                                    if (Target != null) {
                                        int LEVEL = Integer.parseInt(args[2]);
                                        int XP = Integer.parseInt(args[3]);
                                        if (args[1] != null && args[2] != null) {
                                            StatUtils.setHashXP(Target, XP);
                                            StatUtils.setHashLevel(Target, LEVEL);
                                            player.sendMessage("§bPlayer: " + Target.getName() + "\n§cIs now level: " + LEVEL + "\nAnd has: " + XP + " XP");
                                        } else {
                                            player.sendMessage("§cPlease use a number to set the XP and LEVEL");
                                        }
                                    } else {
                                        player.sendMessage("§cThat is not a valid player!");
                                    }
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("ResetAll")) {
                            if(player.hasPermission("EzMiner.ResetAll")) {
                                StatUtils.setHashXP(player, 0);
                                StatUtils.setHashLevel(player, 1);
                                for(Resources ores : Resources.values()) {
                                    StatUtils.setResources(player, ores, 0);
                                }
                            }

                        } else if(args[0].equalsIgnoreCase("Help")) {
                            player.sendMessage("§6§l----------------------------------------------");
                            player.sendMessage("          §b§lEzMiner ~ By EzCoins         ");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Forge : §fOpens the forge menu.");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Stats : §fCheck your current stats.");
                            player.sendMessage(" ");
                            player.sendMessage("§6§l----------------------------------------------");
                            if(player.hasPermission("EzMiner.*")) {
                                player.sendMessage("              §c§lAdmin Commands           ");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner Reset : §fResets your stats.");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner Set : §fSet your stats to your own liking.");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner ResetAll : §fResets everything.");
                                player.sendMessage(" ");
                                player.sendMessage("§6§l----------------------------------------------");
                            }
                        } else if(args[0].equalsIgnoreCase("test")) {
                            if(player.hasPermission("EzMiner.*")) {
                            }
                        } else if(args[0].equalsIgnoreCase("Starter")) {
                            player.getInventory().addItem(PickaxeItems.Starter_Pickaxe.getItemStack());
                            player.sendMessage("§cYou received a Starter Pickaxe!");
                        }
                        return true;
                    }



        }

            return true;
        }
    }
