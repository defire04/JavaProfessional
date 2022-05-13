package com.company;

import java.util.List;
import java.util.ArrayList;

class Controller {
    static void threadsStarter(List<FileWrapper> list) {
        List<Thread> threads = new ArrayList<>();

        list.forEach(fileWrapper -> {
            Thread tempThread = new Thread(new WorldFinder(fileWrapper));
            threads.add(tempThread);
            tempThread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
