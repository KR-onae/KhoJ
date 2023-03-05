package com.kronae.khojpaper1_19_2;

import com.kronae.khojpaper1_19_2.inventory.Listener;
import com.kronae.khojpaper1_19_2.yaml.Yaml;
import com.kronae.khojpaper1_19_2.yaml.error.YamlNoFileFoundException;
import com.kronae.khojpaper1_19_2.yaml.error.YamlNotFileException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;

public class KhoJ {
    private static @NotNull ArrayList<Listener> GUIEventListeners = new ArrayList<>();

    public static void addGUIEventListeners(Listener l) {
        GUIEventListeners.add(l);
    }
    public static ArrayList<Listener> getGUIEventListeners() {
        return GUIEventListeners;
    }

    public static Yaml getYaml(File dataDirectory, String path) throws YamlNotFileException, YamlNoFileFoundException {
        return new Yaml(new File(dataDirectory, path));
    }
    public static Yaml getYaml(File yaml) throws YamlNotFileException, YamlNoFileFoundException {
        return new Yaml(yaml);
    }
    public static Yaml getYaml(String yaml) throws YamlNotFileException, YamlNoFileFoundException {
        return new Yaml(new File(yaml));
    }
    public static void setup(PluginManager pluginManager, Plugin plugin) {
        pluginManager.registerEvents(new org.bukkit.event.Listener() {
            @EventHandler
            public void onInventoryClick(InventoryClickEvent event) {
                ArrayList<com.kronae.khojpaper1_19_2.inventory.Listener> arr = KhoJ.getGUIEventListeners();
                for (com.kronae.khojpaper1_19_2.inventory.Listener l : arr) {
                    if (event.getView().title().toString().equals(l.get().getTitle().toString())) {
                        l.run(event);
                    }
                }
            }
            @EventHandler
            public void onInventoryClose(InventoryCloseEvent event) {
                ArrayList<com.kronae.khojpaper1_19_2.inventory.Listener> arr = KhoJ.getGUIEventListeners();
                for (com.kronae.khojpaper1_19_2.inventory.Listener l : arr) {
                    if (event.getView().title().toString().equals(l.get().getTitle().toString())) {
                        l.run(event);
                    }
                }
            }
        }, plugin);
    }
}
