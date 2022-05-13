package com.company;

import java.util.List;
import java.text.DecimalFormat;

public class Dispatcher {
    public static void main(String[] args) {
        List<WordLengthCounter> lci = List.of(
                new WordLengthCounter("File1"),
                new WordLengthCounter("File2"),
                new WordLengthCounter("File3")
        );
        long timeStartMulti = System.currentTimeMillis();
        Controller.searchAverageLengthOfWordsInFiles(lci);
        System.out.println(new DecimalFormat("0.00").format(WordLengthCounter.averageLengthOfWords)
                + "\nMulti Tread time = " + (System.currentTimeMillis() - timeStartMulti));

        System.out.println(WordLengthCounter.averageLengthOfWords);
    }
}
