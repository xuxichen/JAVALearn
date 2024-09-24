package com.File.FileDemo03;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImp implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
    }
}
