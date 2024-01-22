package org.mania.maniaapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class ManiaAPI extends JavaPlugin {

    private static ManiaAPI instance;

    private GlowingEntities glowing;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        glowing = new GlowingEntities(instance);
        getLogger().info("Mania API has been enabled");

    }

    public static ManiaAPI getInstance() {
        return instance;
    }

    public GlowingEntities getGlowAPI() {
        return glowing;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        glowing.disable();
        getLogger().info("Mania API has been enabled");
    }
}
