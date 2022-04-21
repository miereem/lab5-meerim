package com.meerim.client.utility;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileManager {
    private final String filename;

    public FileManager(String var) {
        this.filename = System.getenv(var);
        if (!filename.endsWith(".csv")) {
            System.out.println("This program can only work with .csv file.");
            return;
        }
    }

    public String read() throws IOException {
        StringBuilder strData = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                strData.append(scanner.nextLine() + ",");
            }
        }
        return strData.toString();
    }

    public void save(String text) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

