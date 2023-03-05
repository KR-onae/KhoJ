package com.kronae.khojpaper1_19_2;

import com.kronae.khojpaper1_19_2.util.Text;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {
    public String locationParser(Location location) {
        return location.getWorld().getName() + " " + (int) location.getX() + " " + (int) location.getY() + " " + (int) location.getZ() + " ";
    }
    public Location locationParser(String location) {
        String[] spl = location.split("\\s");
        return new Location(Bukkit.getWorld(spl[0]), Integer.parseInt(spl[1]), Integer.parseInt(spl[2]), Integer.parseInt(spl[3]));
    }
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(new Text("KhoJ is NOT a plugin.").color(NamedTextColor.RED).asComponent());
        Bukkit.getConsoleSender().sendMessage(new Text("Now run with TEST MODE.").color(NamedTextColor.RED).asComponent());


        // BELOW = TEST CODE \\
    }

    @Override
    public void onDisable() {}
}
