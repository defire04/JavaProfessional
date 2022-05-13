package com.company;

import java.io.File;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;


class Controller {
    static void startMultiThreads(List<String> files, Set<FileWrapper> resultTreeSetForMulti) {
        ExecutorService es = Executors.newCachedThreadPool();

        List<Callable<FileWrapper>> lci = new ArrayList<>();
        lci.add(new PunctuationChecker(new FileWrapper(new File(files.get(0)))));
        lci.add(new PunctuationChecker(new FileWrapper(new File(files.get(1)))));
        lci.add(new PunctuationChecker(new FileWrapper(new File(files.get(2)))));

        long timeStartMulti = System.currentTimeMillis();
        List<Future<FileWrapper>> resultMulti = null;
        try {
            resultMulti = es.invokeAll(lci);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
        long timeFinishedMulti = System.currentTimeMillis();

        if (resultMulti != null) {
            for (Future<FileWrapper> temp : resultMulti) {
                try {
                    resultTreeSetForMulti.add(temp.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Multi Tread = " + (timeFinishedMulti - timeStartMulti));
    }

    static void startSingleThread(List<String> files, Set<FileWrapper> resultTreeSetForSingle) {

        PunctuationChecker p1 = new PunctuationChecker(new FileWrapper(new File(files.get(0))));
        PunctuationChecker p2 = new PunctuationChecker(new FileWrapper(new File(files.get(1))));
        PunctuationChecker p3 = new PunctuationChecker(new FileWrapper(new File(files.get(2))));

        long timeStartSingle = System.currentTimeMillis();
        FileWrapper fw1 = p1.call();
        FileWrapper fw2 = p2.call();
        FileWrapper fw3 = p3.call();
        long timeFinished = System.currentTimeMillis();

        resultTreeSetForSingle.add(fw1);
        resultTreeSetForSingle.add(fw2);
        resultTreeSetForSingle.add(fw3);

        System.out.println("Single Tread = " + (timeFinished - timeStartSingle));
    }
}
