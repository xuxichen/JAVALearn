package com.File;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImp implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }else {
            if (pathname.getName().endsWith(".java")) {
                return true;
            }
            return false;
        }
    }
}
