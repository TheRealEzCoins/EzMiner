package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GemsGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("§bGems")) {
            e.setCancelled(true);
            GuiUtils.ResourceListener(e);
            if (e.getCurrentItem() == null) {
            } else {
                ResourceSetup.ResourceGUISetup(e, player);
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
            }
        }
    }
}
