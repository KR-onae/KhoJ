package com.kronae.khojpaper1_19_2.util;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.NotNull;

public class Text {
    private @NotNull Component component;
    public Text() {
        this("");
    }
    public Text(String text) {
        component = Component.text(text).color(NamedTextColor.WHITE).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.UNDERLINED, false).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.OBFUSCATED, false).decoration(TextDecoration.STRIKETHROUGH, false);
    }
    public Text append(Component component) {
        this.component = this.component.append(component);
        return this;
    }
    public Text append(Text text) {
        component = component.append(text.asComponent());
        return this;
    }
    public Text add(Component component) {
        this.component = this.component.append(component);
        return this;
    }
    public Text add(Text text) {
        component = component.append(text.asComponent());
        return this;
    }
    public Text set(Component component) {
        this.component = component;
        return this;
    }
    public Text color(TextColor color) {
        component = component.color(color);
        return this;
    }
    public Text color(int R, int G, int B) {
        component = component.color(TextColor.color(R, G, B));
        return this;
    }
    public Text color(NamedTextColor color) {
        component = component.color(color);
        return this;
    }
    public Text color(String hexString) {
        component = component.color(TextColor.fromHexString(hexString.startsWith("#") ? hexString : "#" + hexString));
        return this;
    }
    public Component asComponent() {
        return component;
    }

}
