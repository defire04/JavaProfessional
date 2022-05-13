package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Dispatcher {
    static Map<String, Long> result = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<FileWrapper> listFileNames = List.of(
                new FileWrapper("File1"),
                new FileWrapper("File2"),
                new FileWrapper("File3")
        );
        Controller.threadsStarter(listFileNames);
        System.out.println(result);
    }
}
