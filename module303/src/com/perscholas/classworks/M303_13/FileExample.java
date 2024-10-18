package com.perscholas.classworks.M303_13;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("src/temp.txt");
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("===> " + f.getName());
            }
        }
        try {
            boolean created = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
