package com.kronae.khojpaper1_19_2.yaml;

import com.kronae.khojpaper1_19_2.util.Item;
import com.kronae.khojpaper1_19_2.yaml.error.YamlNoFileFoundException;
import com.kronae.khojpaper1_19_2.yaml.error.YamlNoValueAtPathException;
import com.kronae.khojpaper1_19_2.yaml.error.YamlNotFileException;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class Yaml {
    private @NotNull FileConfiguration yaml;
    private @NotNull File file;
    public Yaml(File file) throws YamlNotFileException, YamlNoFileFoundException {
        setFile(file);
    }
    public @NotNull FileConfiguration getRaw() {
        return yaml;
    }
    public @NotNull File getFile() {
        return file;
    }
    public void set(String path, boolean value) {
        yaml.set(path, value);
    }

    public @Nullable Object get(String path) {
        return yaml.get(path);
    }
    public boolean getBoolean(String path) {
        return yaml.getBoolean(path);
    }
    public @Nullable Color getColor(String path) {
        return yaml.getColor(path);
    }
    public @Nullable String getString(String path) {
        return yaml.getString(path);
    }
    public double getDouble(String path) throws YamlNoValueAtPathException {
        if(!yaml.isSet(path)) throw new YamlNoValueAtPathException("KhoJ.yaml.Yaml: No double value at path: " + path);
        return yaml.getDouble(path);
    }
    public int getInteger(String path) throws YamlNoValueAtPathException {
        if(!yaml.isSet(path)) throw new YamlNoValueAtPathException("KhoJ.yaml.Yaml: No integer value at path: " + path);
        return yaml.getInt(path);
    }
    public @Nullable Item getItemStack(String path) {
        ItemStack itemStack = yaml.getItemStack(path);
        if(itemStack == null) return null;
        return new Item(itemStack);
    }
    public @Nullable OfflinePlayer getOfflinePlayer(String path) {
        return yaml.getOfflinePlayer(path);
    }
    public @Nullable Vector getVector(String path) {
        return yaml.getVector(path);
    }
    public @Nullable Location getLocation(String path) {
        return yaml.getLocation(path);
    }
    public long getLong(String path) throws YamlNoValueAtPathException {
        if(!yaml.isSet(path)) throw new YamlNoValueAtPathException("KhoJ.yaml.Yaml: No long value at path: " + path);
        return yaml.getLong(path);
    }

    public boolean isSet(String path) {
        return yaml.isSet(path);
    }
    public void save() {
        try {
            yaml.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String saveToString() {
        return yaml.saveToString();
    }
    public void load() {
        try {
            yaml.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
    public void load(FileConfiguration configuration) throws YamlNotFileException, YamlNoFileFoundException {
        File f = new File(configuration.getCurrentPath());
        setFile(f);
        try {
            yaml.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
    public void setFile(File file) throws YamlNoFileFoundException, YamlNotFileException {
        if(file.exists()) {
            if(file.isFile()) {
                this.file = file;
                yaml = new YamlConfiguration();
                try {
                    yaml.load(this.file);
                } catch (IOException | InvalidConfigurationException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new YamlNotFileException("KhoJ.yaml.Yaml: This is directory: " + file.getAbsolutePath());
            }
        } else {
            throw new YamlNoFileFoundException("KhoJ.yaml.Yaml: No file found at: " + file.getAbsolutePath());
        }
    }
}
