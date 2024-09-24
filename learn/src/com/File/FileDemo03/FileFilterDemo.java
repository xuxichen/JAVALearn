package com.File.FileDemo03;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        File file = new File("./src/com/File/");
        printFile(file);
    }

    private static void printFile(File dirs) {
//        File[] files = dir.listFiles( pathname-> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java"));
        File[] files = dirs.listFiles( (dir, name)-> {
            return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
        });
        for (File file : files) {
            if (file.isDirectory()) {
                printFile(file);
            } else {
                String filename = file.getName();
                System.out.println(filename);
            }
        }
    }
//    private static void printFile(File dir) {
//        File[] files = dir.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
//            }
//        });
//        for (File file : files) {
//            if (file.isDirectory()) {
//                printFile(file);
//            } else {
//                String filename = file.getName();
//                System.out.println(filename);
//            }
//        }
//    }

//    private static void printFile(File dir) {
//        FileFilterImp fileFilterImp = new FileFilterImp();
//        File[] files = dir.listFiles(fileFilterImp);
//        for (File file : files) {
//            if (file.isDirectory()) {
//                printFile(file);
//            } else {
//                String filename = file.getName();
//                System.out.println(filename);
//            }
//        }
//    }

//    private static void printFile(File file) {
//        if (file.exists()) {
//            if (file.isFile()){
//                String filename = file.getName();
//                System.out.println(filename);
//            } else {
//                File[] arr = file.listFiles(new FileFilter() {
//                    @Override
//                    public boolean accept(File pathname) {
//                        return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
//                    }
//                });
//                for (File file1 : arr) {
//                    printFile(file1);
//                }
//            }
//        }
//    }

//    private static void printFile(File file) {
//        if (file.exists()) {
//            if (file.isFile()){
//                String filename = file.getName();
//                System.out.println(filename);
//            } else {
//                File[] arr = file.listFiles(new FileFilterImp() );
//                for (File file1 : arr) {
//                    printFile(file1);
//                }
//            }
//        }
//    }
}
