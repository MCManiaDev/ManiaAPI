package org.mania.maniaapi;

import me.superneon4ik.noxesiumutils.events.NoxesiumPlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mania.maniaapi.glow.GlowingEntities;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;

public final class ManiaAPI extends JavaPlugin implements Listener {

    private static ManiaAPI instance;

    private GlowingEntities entityGlow;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        entityGlow = new GlowingEntities(instance);
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Mania API has been enabled (version 1.2)");

    }

    public Player getPlayerFromUUID(String uuid) {
        for (Player player: Bukkit.getServer().getOnlinePlayers()) {
            if (player.getUniqueId().toString().equals(uuid)) {
                return player;
            }
        }
        return null;
    }

    @EventHandler
    public void on(NoxesiumPlayerJoinEvent event) {
        String bomb = "be06aa88-2640-4da0-b8c7-05f53a613a4a";
        Player thebomb = getPlayerFromUUID(bomb);
        Integer protocolVersion = event.getProtocolVersion();
        if (protocolVersion != 3) {
            event.getPlayer().sendMessage(Component.text("Your Noxesium is outdated! Please update the mod for an optimal experience"));
            getLogger().warning(event.getPlayer().getName() + "'s Noxesium is outdated!");
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.isOp()) {
                    player.sendMessage(event.getPlayer().displayName() + "is running an outdated version of Noxesium! (Protocol version: " + protocolVersion + " )");
                }
            }
        } else if (protocolVersion == null) {
            if (thebomb != null) {
                thebomb.sendMessage(event.getPlayer().displayName() + "does not have Noxesium installed!");
            }
        }
    }

    public static ManiaAPI getInstance() {
        return instance;
    }

    public GlowingEntities getGlowAPI() {
        return entityGlow;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        entityGlow.disable();
        getLogger().info("Mania API has been disabled");
    }
}
