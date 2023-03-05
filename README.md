# KhoJ
Korean KRonae made KhoJ!

# What? What's this?
KhoJ is the Minecraft plugin development helper!

# Then... How to use?
First, use the following code to start using KhoJ:
```java
KhoJ.setup(Bukkit.getPluginManager(), this);
```
This use at creating an inventory, and you must write when you set up a click or close event using AddEventListener.
In general, it should be written at the top of the 'onEnable' method of your plugin.

Now, let's learn how to use KhoJ in earnest.
First, you can create a ChestInventory with code like this:
```java
// public ChestInventory(int rows, Text title);
new ChestInventory(3, new Text("WTF! This is an INVENTORY!"));
```

Next you can set the item in your inventory slot like this:
```java
// ChestInventory inv = ...;
// inv.set(Slot);
// inv.set(SlotLocation, Item);
// inv.set(SlotLocation, ItemStack);

new ChestInventory(3, new Text("WTF! This is an INVENTORY!"))
    .set(Slot.location(0), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Hello world!").color("FFFFFF")))
    .set(Slot.location(2, 1), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 2, Y: 1!").color("FFFFFF")))
    .set(Slot.location(3, 2), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 3, Y: 2!").color("FFFFFF")))
```

And you can open the created inventory to the player.
```java
// inv.open(Player);
inv.open(event.getPlayer());
```

So let's look at the full example code.
```java
Bukkit.getPluginManager().registerEvents(new Listener() {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new ChestInventory(3, new Text("WTF! This is an INVENTORY!"))
            .set(Slot.location(0), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Hello world!").color("FFFFFF")))
            .set(Slot.location(2, 1), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 2, Y: 1!").color("FFFFFF")))
            .set(Slot.location(3, 2), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 3, Y: 2!").color("FFFFFF")))
            .open(event.getPlayer())
        ;
    }
}, this);
```

The code above opens the ChestInventory when a player connects to the server.
So now, let's set up the click event.
Let's look at the following code.
```java
Bukkit.getPluginManager().registerEvents(new Listener() {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    new ChestInventory(3, new Text("WTF! This is an INVENTORY!"))
        .set(Slot.location(0), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Hello world!").color("FFFFFF")))
        .set(Slot.location(2, 1), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 2, Y: 1!").color("FFFFFF")))
        .set(Slot.location(3, 2), new Item(Material.GRASS_BLOCK, 1).setName(new Text("Fuckin' X: 3, Y: 2!").color("FFFFFF")))
        .addEventListener(new InventoryEventEasyHandler() {
            @Override
            public void click(InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                player.sendMessage(new Text(event.getClick().name()).asComponent());
            }
        })
        .open(event.getPlayer());
    }
}, this);
```
This is the code that when a column inventory is clicked,
The event is canceled and a message is sent to the player how they clicked.

