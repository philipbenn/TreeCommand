package com.example.treecommand;

import java.io.File;

public class TreeCommandApplication {

    public static void main(String[] args) {
        // finder directory
        String currentDirectory = System.getProperty("user.dir");

        // printer directory
        System.out.println(currentDirectory);

        // kalder print directory funktionen får at printe directory strukturen
        printDirectory(new File(currentDirectory), "", true);
    }

    // printer directory strukturen med linjer
    private static void printDirectory(File directory, String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length - 1; i++) {
                printDirectory(files[i], prefix + (isLast ? "    " : "│   "), false);
            }
            if (files.length > 0) {
                printDirectory(files[files.length - 1], prefix + (isLast ? "    " : "│   "), true);
            }
        }
    }
}