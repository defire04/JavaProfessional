package com.company;

import java.util.List;

class Controller {
    public static void searchAverageLengthOfWordsInFiles(List<WordLengthCounter> fileWrapperList) {
        System.out.println("----------------===Multi===----------------");
        fileWrapperList.forEach(thread -> {
            try {
                thread.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        WordLengthCounter.averageLengthOfWords = WordLengthCounter.ALL_TEXT
//                .parallelStream()
//                .mapToInt(String::length)
//                .average()
//                .getAsDouble();
        WordLengthCounter.averageLengthOfWords = WordLengthCounter.summingLengthOfWorld.doubleValue()/ WordLengthCounter.countOfWords.get();
    }
}
