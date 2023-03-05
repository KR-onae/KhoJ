package com.kronae.khojpaper1_19_2.inventory;

import com.kronae.khojpaper1_19_2.util.Text;
import net.kyori.adventure.text.Component;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Listener {
    @NotNull private InventoryEventHandler h;
    public Listener(@NotNull InventoryEventHandler handler) {
        h = handler;
    }
    public Listener(@NotNull InventoryEventEasyHandler handler, Inventory inv) {
        h = new InventoryEventHandler() {
            @Override
            public void click(InventoryClickEvent event) {
                handler.click(event);
            }
            @Override
            public void close(InventoryCloseEvent event) {
                handler.close(event);
            }

            @Override
            public Component getTitle() {
                Text title = inv.getTitle();
                if(title == null) return null;
                return title.asComponent();
            }
            @Override
            public InventoryType getType() {
                return inv.getType();
            }
            @Override
            public @Nullable List getViewers() {
                return inv.getViewers();
            }
        };
    }
    public void set(@NotNull InventoryEventHandler handler) {
        h = handler;
    }
    public InventoryEventHandler get() {
        return h;
    }
    public void run(InventoryClickEvent event) {
        h.click(event);
    }
    public void run(InventoryCloseEvent event) {
        h.close(event);
    }
}
