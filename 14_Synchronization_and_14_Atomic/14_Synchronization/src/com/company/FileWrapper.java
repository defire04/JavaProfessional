package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileWrapper {
    private final String fileName;

    public String getFileName() {
        return this.fileName;
    }

    FileWrapper(String fileName) {
        this.fileName = fileName;
    }

    void sumOfNumbers() {
        long id = Thread.currentThread().getId();
        System.out.println("Start tread (Id " + id + ")");
        Pattern pattern = Pattern.compile("\\d");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        Dispatcher.result.add(Double.parseDouble(word));
                    }
                }
            }
            System.out.println("Thread number: " + id + " finished.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

