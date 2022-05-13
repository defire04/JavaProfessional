package com.company;

import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;


class WordLengthCounter implements Runnable {
//    public static final List<String> ALL_TEXT = Collections.synchronizedList(new ArrayList<>());
    private final String file;
    private final Thread thread;

    public static double averageLengthOfWords;

    public static AtomicInteger countOfWords = new AtomicInteger(0);
    public static LongAdder summingLengthOfWorld = new LongAdder();

    public WordLengthCounter(String file) {
        this.file = file;
        thread = new Thread(this);
        thread.start();
    }

    public String getFile() {
        return file;
    }

    public Thread getThread() {
        return thread;
    }


    @Override
    public void run() {
        System.out.println("Start " + Thread.currentThread().getId() + " tread");
        readingFile();
    }

    private void readingFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
//                Collections.addAll(ALL_TEXT, line.split(" "));
//                Arrays.stream(line.split(" ")).parallel().forEach(word -> {
                    Arrays.stream(line.split(" ")).forEach(word -> {
                    countOfWords.incrementAndGet();
                    summingLengthOfWorld.add(word.length());
                });


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
