package com.kronae.khojpaper1_19_2.inventory;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface InventoryEventHandler {
    default void click(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage(String.valueOf(event.getRawSlot()));
    }
    default void close(InventoryCloseEvent event) {
        event.getPlayer().sendMessage("Close!");
    }

    default Component getTitle() {
        return Component.text("");
    }
    default InventoryType getType() {
        return InventoryType.CHEST;
    }
    default @NotNull List<HumanEntity> getViewers() {
        return Bukkit.createInventory(null, 9).getViewers();
    }
}
