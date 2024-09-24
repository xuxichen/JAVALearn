package com.File.FileDemo01;

import sun.font.CreatedFontTracker;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {
    public static void main(String[] args) {

        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        System.out.println("=======================");

        show01();

        System.out.println("=======================");

        show02();

        System.out.println("=======================");
        //
        show03();

        System.out.println("=======================");

        // 判断功能
        isFileOrisDirectory();

        System.out.println("=======================");

        // 创建新文件功能
        FilecreateNewFile();

        // 删除文件功能
        FileDelete();

        // 创建由此File表示的目录
        CreatedMkdir();

        // 创建由此File表示的目录, 包括任何必须但不存在的父目录
        CreatedMkdirs();

        // 返回一个String 数组，表示改File目录所有的自文件或者目录
        getFileList();

        System.out.println("=======================");

        // 返回一个File 数组，表示改File目录所有的自文件或者目录
        getFiles();
    }

    private static void getFiles() {
        File file = new File("./src/com/File/FileDemo01");
        File[] list = file.listFiles();
        for (File s : list) {
            System.out.println("遍历文件或者文件夹的名字 == " + s);
        }
    }

    private static void getFileList() {
        File file = new File("./src/com/File/FileDemo01");
        String[] list = file.list();
        for (String s : list) {
            System.out.println("遍历文件夹的名字 == " + s);
        }
    }

    private static void CreatedMkdirs() {
        File file = new File("./src/com/File/FileDemo02/IMG_1185");
        file.mkdirs();
    }

    private static void CreatedMkdir() {
        File file = new File("./src/com/File/FileDemo01/IMG_1185");
        file.mkdir();
    }


    private static void FilecreateNewFile() {
        File file = new File("./src/com/File/FileDemo01/IMG_1186.text");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void FileDelete() {
        File file = new File("./src/com/File/FileDemo01/IMG_1184.text");
        file.delete();
    }

    private static void isFileOrisDirectory() {
        File file = new File("./src/com/File/FileDemo01/IMG_1184.JPG");
        System.out.println("文件是否存在  ===" + file.exists());
        System.out.println("是文件  ===" + file.isFile());
        File file2 = new File("./src/com/File/FileDemo01");
        System.out.println("文件夹是否存在  ===" + file2.exists());
        System.out.println("是文件夹  ===" + file2.isDirectory());
    }

    private static void show02() {
        File file = new File("./src/com/File/FileDemo01", "IMG_1184.JPG");
        System.out.println("文件1的绝对路径 ===" + file.getAbsoluteFile());
        System.out.println("文件1的相对路径 ===" + file.getPath());
        System.out.println("文件1的名称 ===" + file.getName());
        System.out.println("文件1的长度 ===" + file.length());
    }

    private static void show03() {
        File file = new File("./src/com/File/FileDemo01/IMG_1184.JPG");
        System.out.println("文件的绝对路径 ===" + file.getAbsoluteFile());
        System.out.println("文件的相对路径 ===" + file.getPath());
        System.out.println("文件的名称 ===" + file.getName());
        System.out.println("文件的长度 ===" + file.length());
    }

    private static void show01() {
        File file = new File("./src/com/File/FileDemo01/IMG_1184.JPG");
        System.out.println(file);
    }
}
