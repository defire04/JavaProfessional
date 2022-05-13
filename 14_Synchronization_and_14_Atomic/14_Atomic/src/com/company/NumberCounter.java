package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumberCounter implements Runnable {
    private final String fileName;

    public String getFileName() {
        return fileName;
    }

    NumberCounter(String fileName) {
        this.fileName = fileName;
//        new Thread(this).start();
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Start tread " + threadId);
        Pattern pattern = Pattern.compile("\\d+");

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
            System.out.println("Thread number: " + threadId + " finished.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

