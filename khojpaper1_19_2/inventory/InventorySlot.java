package com.kronae.khojpaper1_19_2.inventory;

import com.kronae.khojpaper1_19_2.util.Item;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class InventorySlot {
    @NotNull private Inventory inventory;
    @NotNull private Item item = new Item(Material.STONE);
    @NotNull private SlotLocation location = new SlotLocation(0);

    protected InventorySlot() {
        inventory = null;
    }
    public InventorySlot(Inventory inventory, SlotLocation location) {
        this.inventory = inventory;
        this.item = inventory.getItem(location);
        this.location = location;
    }
}
