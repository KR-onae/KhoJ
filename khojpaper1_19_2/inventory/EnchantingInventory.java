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

public class EnchantingInventory implements Inventory<EnchantingInventory> {
    private final InventoryType type = InventoryType.ENCHANTING;
    private Text inventoryTitle;
    private final org.bukkit.inventory.Inventory inventory;

    public EnchantingInventory() {
        inventory = Bukkit.createInventory(null, type);
        inventory.setMaxStackSize(128);
    }
    public EnchantingInventory(Text inventoryTitle) {
        this.inventoryTitle = inventoryTitle;
        inventory = Bukkit.createInventory(null, type, inventoryTitle.asComponent());
    }
    public @NotNull EnchantingInventory set(Slot slot) {
        inventory.setItem(slot.getLocation().getRawLocation(), slot.getItem().getItemStack());
        return this;
    }
    public @NotNull EnchantingInventory set(SlotLocation slotLocation, Item item) {
        inventory.setItem(slotLocation.getRawLocation(), item.getItemStack());
        return this;
    }
    public @NotNull EnchantingInventory setTitle(Text text) {
        inventoryTitle = text;
        return this;
    }
    public @Nullable Item getItem(SlotLocation slotLocation) {
        ItemStack rawLoc = inventory.getItem(slotLocation.getRawLocation());
        if(rawLoc == null) return null;
        return new Item(rawLoc);
    }
    public @NotNull InventorySlot getSlot(SlotLocation slotLocation) {
        return new InventorySlot(this, slotLocation);
    }
    public @NotNull EnchantingInventory open(Player player) {
        player.openInventory(inventory);
        return this;
    }
    public @NotNull InventoryType getType() {
        return type;
    }
    public @Nullable Text getTitle() {
        return inventoryTitle;
    }
    public @Nullable EnchantingInventory addEventListener(InventoryEventEasyHandler l) {
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
