package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new PickaxeGUIListener());
        addListener(new ForgeGUIListener());
        addListener(new BreakListener());
        addListener(new ResourceGUIListener());
        addListener(new GemsGUIListener());
        addListener(new OnJoin());
        addListener(new PlaceListener());
        addListener(new RefiningGUIListener());
        addListener(new FuelListener());
        addListener(new onOpen());
        addListener(new onQuit());
        addListener(new UpgradeGUIListener());
        addListener(new EnchantEvent());
        addListener(new ShopGUIListener());
        addListener(new DeathListener());
        addListener(new MaterialGUIListener());
        addListener(new ArmorListeners());
        addListener(new FortuneListener());
        addListener(new onEnableXray());
        addListener(new PlayerListener());
        addListener(new onClick());
        addListener(new CheatGUIListener());
    }

    private void addListener(Listener listener) {
        EzMiner.getPluginManager().registerEvents(listener, EzMiner.getPlugin());
    }

}
