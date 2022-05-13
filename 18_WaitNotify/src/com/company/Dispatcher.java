package com.company;

import java.io.File;
import java.util.List;

public class Dispatcher {
    public static final String PATH = "";
    public static void main(String[] args) {
        List<FileWrapper> files = List.of(
                new FileWrapper(PATH + "File1"),
                new FileWrapper(PATH + "File2"),
                new FileWrapper(PATH + "File3")
        );
        long start = System.nanoTime();
        new Rewriter(files);
        new CounterSpace(files);
        long end = System.nanoTime();

        System.out.println("Working time: " + (end - start));
    }
}