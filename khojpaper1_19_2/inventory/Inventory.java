package com.kronae.khojpaper1_19_2.inventory;

import com.kronae.khojpaper1_19_2.util.Item;
import com.kronae.khojpaper1_19_2.util.Text;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Inventory<INV> {
    Text inventoryTitle = null;
    org.bukkit.inventory.Inventory inventory = null;

    @NotNull INV set(Slot slot);
    @NotNull INV set(SlotLocation slotLocation, Item item);
    @Nullable Item getItem(SlotLocation slotLocation);
    @NotNull InventorySlot getSlot(SlotLocation slotLocation);
    @NotNull INV open(Player player);
    @NotNull InventoryType getType();
    @Nullable Text getTitle();
    @Nullable INV addEventListener(InventoryEventEasyHandler l);
    @Nullable List<HumanEntity> getViewers();
    @NotNull org.bukkit.inventory.Inventory getRaw();
}
