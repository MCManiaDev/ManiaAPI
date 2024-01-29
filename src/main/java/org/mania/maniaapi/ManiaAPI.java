package org.mania.maniaapi;

import org.bukkit.plugin.java.JavaPlugin;
import org.mania.maniaapi.glow.GlowingEntities;
import org.mania.maniaapi.glow.GlowingBlocks;

public final class ManiaAPI extends JavaPlugin {

    private static ManiaAPI instance;

    private GlowingEntities entityGlow;
    private GlowingBlocks blockGlow
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        blockGlow = new GlowingBlocks(instance);
        entityGlow = new GlowingEntities(instance);
        getLogger().info("Mania API has been enabled");

    }

    public static ManiaAPI getInstance() {
        return instance;
    }

    public GlowingEntities getGlowAPI() {
        return entityGlow;
    }

    public GlowingBlocks getBlockGlowAPI() { return blockGlow; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        blockGlow.disable();
        entityGlow.disable();
        getLogger().info("Mania API has been enabled");
    }
}
