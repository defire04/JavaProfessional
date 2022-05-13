package com.company;

import java.util.List;
import java.util.ArrayList;

class Controller {
    static void threadsStarter(List<NumberCounter> list) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        list.forEach(temp -> {
            Thread tempTread = new Thread(temp);
            threads.add(tempTread);
            tempTread.start();
        });
        for (Thread temp : threads) {
            temp.join();
        }
    }
}
