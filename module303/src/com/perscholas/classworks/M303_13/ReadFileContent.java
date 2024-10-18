package com.perscholas.classworks.M303_13;

import java.io.*;

public class ReadFileContent {
    public static void main(String[] args) {
        File file = new File("src/temp.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
