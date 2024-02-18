package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class History {
    private static List<String> entries = new ArrayList<>();

    public static void addEntry(String entry) {
        entries.add(entry);
    }

    public static List<String> getHistory() {
        return entries;
    }
}
