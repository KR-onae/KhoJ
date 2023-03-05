package com.kronae.khojpaper1_19_2.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static boolean createFile(File file) {
        if(!file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }
    public boolean writeFile(File file, String value) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(value);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static class nullChanger<INPUT> {
        INPUT in;
        INPUT to;
        public nullChanger(@Nullable INPUT input, @NotNull INPUT nullTo) {
            in = input;
            to = nullTo;
        }
        public @NotNull INPUT get() {
            return in == null ? to : in;
        }
    }
}
