package com.company;

import java.util.*;

public class Dispatcher {
    public static void main(String[] args){
        List<String> listFileNames = List.of("File1", "File2", "File3");

        System.out.println("----------------=== Single ===----------------");
        Set<FileWrapper> resultTreeSetForSingle = new TreeSet<>();
        Controller.startSingleThread(listFileNames, resultTreeSetForSingle);
        View.printSet(resultTreeSetForSingle);

        System.out.println("----------------=== Multi ===----------------");
        Set<FileWrapper> resultTreeSetForMulti = new TreeSet<>();
        Controller.startMultiThreads(listFileNames, resultTreeSetForMulti);
        View.printSet(resultTreeSetForMulti);
    }
}
