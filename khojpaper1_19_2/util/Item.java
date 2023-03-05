package com.kronae.khojpaper1_19_2.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Item {
    @NotNull private ItemStack item;

    public Item(@NotNull Material material) {
        item = new ItemStack(material, 1);
    }
    public Item(@NotNull Material material, int amount) {
        item = new ItemStack(material, amount);
    }
    public Item(@NotNull ItemStack item) {
        this.item = item;
    }
    public @Nullable Item setName(Text name) {
        ItemMeta metadata = item.getItemMeta();
        metadata.displayName(name.asComponent());
        final boolean b = item.setItemMeta(metadata);
        if(!b) return null;
        return this;
    }
    public @NotNull Item setLore(Text[] name) {
        List<Component> lore = new ArrayList<>();
        for(Text text : name) {
            lore.add(text.asComponent());
        }
        item.lore(lore);
        return this;
    }
    public @NotNull Item set(ItemStack item) {
        this.item = item;
        return this;
    }
    public @NotNull ItemStack getItemStack() {;
        return item;
    }
}
