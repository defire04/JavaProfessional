package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class FileWrapper {
    private final String fileName;

    public String getFileName() {
        return fileName;
    }

    FileWrapper(String fileName) {
        this.fileName = fileName;
    }

    void adder() {
        long threadId = Thread.currentThread().getId();
        System.out.println("Start tread " + threadId);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    if (word.length() > 1) {
                        if (word.charAt(0) == word.charAt(word.length() - 1)) {
                            Dispatcher.result.compute(word, (str, count) -> count == null ? 1 : ++count);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finished tread " + threadId);
    }
}

