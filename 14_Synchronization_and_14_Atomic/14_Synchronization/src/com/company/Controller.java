package com.company;
import java.util.List;
import java.util.ArrayList;

public class Controller {
    static void treadsStarter(List<FileWrapper> fileWrapperList) {

        List<NumberFinder> threads = new ArrayList<>();

        for(FileWrapper file : fileWrapperList){
            threads.add(new NumberFinder(file));
        }

        threads.forEach(numberFinder -> {
            try {
                numberFinder.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}



