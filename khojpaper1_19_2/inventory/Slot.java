package com.kronae.khojpaper1_19_2.inventory;

import com.kronae.khojpaper1_19_2.util.Item;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class Slot {
    public static Slot at(int x, int y) {
        return new Slot(x, y, new Item(Material.STONE));
    }
    public static Slot at(int raw) {
        return new Slot(raw, new Item(Material.STONE));
    }
    public static SlotLocation location(int x, int y) {
        return new SlotLocation(x, y);
    }
    public static SlotLocation location(int raw) {
        return new SlotLocation(raw);
    }

    @NotNull private SlotLocation location = new SlotLocation(1, 1);
    @NotNull private Item item = new Item(Material.STONE);

    protected Slot() {}
    public Slot(int x, int y, @NotNull Item item) {
        this.item = item;
        location = new SlotLocation(x, y);
    }
    public Slot(int raw, @NotNull Item item) {
        this.item = item;
        location = new SlotLocation(raw);
    }
    public @NotNull SlotLocation getLocation() {
        return location;
    }
    public @NotNull Item getItem() {
        return item;
    }
    public Slot setItem(Item item) {
        this.item = item;
        return this;
    }
    public InventorySlot of(Inventory inventory) {
        return new InventorySlot(inventory, location);
    }
}
