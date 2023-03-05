package com.kronae.khojpaper1_19_2.inventory;

import com.kronae.khojpaper1_19_2.util.Item;
import com.kronae.khojpaper1_19_2.KhoJ;
import com.kronae.khojpaper1_19_2.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChestInventory implements Inventory<ChestInventory> {
    private final InventoryType type = InventoryType.CHEST;
    private final int rows;
    private Text inventoryTitle;
    private final org.bukkit.inventory.Inventory inventory;

    public ChestInventory(int rows) {
        this.rows = rows;
        inventory = Bukkit.createInventory(null, rows * 9);
        inventoryTitle = null;
    }
    public ChestInventory(int rows, Text inventoryTitle) {
        this.rows = rows;
        this.inventoryTitle = inventoryTitle;
        inventory = Bukkit.createInventory(null, rows * 9, inventoryTitle.asComponent());
    }
    public @NotNull ChestInventory set(Slot slot) {
        if(slot == null) Bukkit.getConsoleSender().sendMessage(new Text("WARNNING: KhoJ-ChestInventory: set(Slot): Slot is NULL!").asComponent());
        assert slot != null;
        if(slot.getItem() == null) Bukkit.getConsoleSender().sendMessage(new Text("WARNNING: KhoJ-ChestInventory: set(Slot): Slot.getItem() is NULL!").asComponent());
        assert slot.getItem() != null;
        if(slot.getItem().getItemStack() == null) Bukkit.getConsoleSender().sendMessage(new Text("WARNNING: KhoJ-ChestInventory: set(Slot): Slot.getItem().getItemStack() is NULL!").asComponent());
        assert slot.getItem().getItemStack() != null;
        inventory.setItem(slot.getLocation().getRawLocation(), slot.getItem().getItemStack());
        return this;
    }
    public @NotNull ChestInventory set(SlotLocation slotLocation, Item item) {
        if(item == null) Bukkit.getConsoleSender().sendMessage(new Text("WARNNING: KhoJ-ChestInventory: set(SlotLocation,Item): Item is NULL!").asComponent());
        assert item != null;
        inventory.setItem(slotLocation.getRawLocation(), item.getItemStack());
        return this;
    }
    public @NotNull ChestInventory set(SlotLocation slotLocation, ItemStack item) {
        if(item == null) Bukkit.getConsoleSender().sendMessage(new Text("WARNNING: KhoJ-ChestInventory: set(SlotLocation,Item): Item is NULL!").asComponent());
        assert item != null;
        inventory.setItem(slotLocation.getRawLocation(), item);
        return this;
    }
    public @NotNull ChestInventory setTitle(Text text) {
        inventoryTitle = text;
        return this;
    }
    public @Nullable Item getItem(SlotLocation slotLocation) {
        ItemStack rawItem = inventory.getItem(slotLocation.getRawLocation());
        if(rawItem == null) return null;
        return new Item(rawItem);
    }
    public @NotNull InventorySlot getSlot(SlotLocation slotLocation) {
        return new InventorySlot(this, slotLocation);
    }
    public @NotNull ChestInventory open(Player player) {
        player.openInventory(inventory);
        return this;
    }

    public @NotNull InventoryType getType() {
        return type;
    }
    public @Nullable Text getTitle() {
        return inventoryTitle;
    }

    public @Nullable ChestInventory addEventListener(InventoryEventEasyHandler l) {
        if(inventoryTitle == null) return null;
        KhoJ.addGUIEventListeners(new Listener(l, this));
        return this;
    }
    public @Nullable List<HumanEntity> getViewers() {
        return inventory.getViewers();
    }
    public @NotNull org.bukkit.inventory.Inventory getRaw() {
        return inventory;
    }
}
