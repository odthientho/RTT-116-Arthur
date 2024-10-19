package com.perscholas.classworks.M303_13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        File file = new File("src/temp2.txt");
        BufferedWriter bw = null;
        try {
            // singular parameter : override the file
            // 2 parameters with the second: true---> append the file.
            bw = new BufferedWriter(new FileWriter(file));
            bw.write("Line 1\n");
            bw.flush();
            bw.write("Line 2\n");
            bw.write("Line 3\n");
            // write the buffer to the file
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    // this close the writer and release resources at the operating system level
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
