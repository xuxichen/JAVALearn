package com.File.FileDemo02.Recursion;

import java.io.File;

public class FileRecursion {
    public static void main(String[] args) {
        File file = new File("./src/com/File/");
        printFile(file);
    }

    private static void printFile(File file) {
        if (file.exists()) {
            if (file.isFile()){
                String filename = file.getName();
                if (filename.endsWith(".java")) {
                    System.out.println(file.getName());
                }
            } else {
                File[] arr = file.listFiles();
                for (File file1 : arr) {
                    printFile(file1);
                }
            }
        }
    }
}
