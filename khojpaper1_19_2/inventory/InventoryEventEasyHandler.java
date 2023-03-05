package com.kronae.khojpaper1_19_2.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public interface InventoryEventEasyHandler {
    default void click(InventoryClickEvent event) {
        event.getWhoClicked().sendMessage(String.valueOf(event.getRawSlot()));
    }
    default void close(InventoryCloseEvent event) {
        event.getPlayer().sendMessage("Close!");
    }
}
