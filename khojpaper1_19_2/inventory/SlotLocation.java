package com.kronae.khojpaper1_19_2.inventory;

public class SlotLocation {
    protected SlotLocation() {}

    private int loc = 0;
    public SlotLocation(int x, int y) {
        loc = (x - 1) + ((y - 1) * 9);
    }
    public SlotLocation(int raw) {
        loc = raw;
    }
    public int getX() {
        return (loc + 1) % 9;
    }
    public int getY() {
        return (loc + 1) / 9;
    }
    public int getRawLocation() {
        return loc;
    }
}
