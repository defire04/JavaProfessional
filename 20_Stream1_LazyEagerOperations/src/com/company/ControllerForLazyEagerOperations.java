package com.company;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;


class ControllerForLazyEagerOperations {
    public static void launchTaskFromFirstTopic() {
        System.out.println("-----------------====Task from first topic====-----------------");
        String fileName = "File1";

        ControllerForLazyEagerOperations.rewriteFileToUpperFirstSymbolInEachWord(fileName);
        System.out.println(ControllerForLazyEagerOperations.sortTextByNumberOfWordsInSentences(fileName));

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5));

        System.out.println(ControllerForLazyEagerOperations.separatingCollectionIntoPositive(list));
        System.out.println(ControllerForLazyEagerOperations.separatingCollectionIntoNegative(list));
        System.out.println(ControllerForLazyEagerOperations.separatingCollectionIntoPositiveAndNegative(list));
    }


    private static List<String> readFileBySentences(String fileName) {
        List<String> allText = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Collections.addAll(allText, line.split("[\\.\\?\\!]"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allText;
    }


    static void rewriteFileToUpperFirstSymbolInEachWord(String fileName) {
        List<String> allText = readFileBySentences(fileName);
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            try {
                allText.forEach(sentence -> {
                    Arrays.stream(sentence.split(" ")).forEach(word -> {
                        if (word.length() > 1) {
                            printWriter.print(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
                        } else {
                            printWriter.print(word + " ");
                        }
                    });
                    printWriter.println(".");
                });
                System.out.println("Rewrite successful!");
            } finally {
                printWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    static List<String> sortTextByNumberOfWordsInSentences(String fileName) {
        return readFileBySentences(fileName).parallelStream().sorted().collect(Collectors.toList());
    }

    // First solution for thirdTask
    static List<Integer> separatingCollectionIntoPositive(List<Integer> inputList) {
        return inputList.parallelStream().filter(integer -> integer > -1).collect(Collectors.toList());
    }
    static List<Integer> separatingCollectionIntoNegative(List<Integer> inputList) {
        return inputList.parallelStream().filter(integer -> integer < 0).collect(Collectors.toList());
    }


    // Second solution
    static List<List<Integer>> separatingCollectionIntoPositiveAndNegative(List<Integer> inputLIst) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        inputLIst.forEach(integer -> {
            if (integer > -1) {
                positive.add(integer);
            } else {
                negative.add(integer);
            }
        });
        return List.of(positive, negative);
    }
}
