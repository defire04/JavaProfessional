package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    static <T> Map<T, Integer> searchForSimilarElements(T[] array, List<? extends T> list) {
        Map<T, Integer> result = new HashMap<>();
        for (T tempFromAr : array) {
            int count = 0;
            for (T tempFromList : list) {
                if (tempFromList.equals(tempFromAr)) {
                    count++;
                }
            }
            if (result.containsKey(tempFromAr)) {
                result.put(tempFromAr, result.get(tempFromAr) + 1);
            } else if (count > 0) {
                result.put(tempFromAr, count);
            }
        }
        return result;
    }


    static <T> void addElementsToArrayListIfItIsNotThere(T[] array, List<? super T> list) {
        for (T tempFromAr : array) {
            if (!list.contains(tempFromAr)) {
                list.add(tempFromAr);
            }
        }
    }



//    With function interface
    static <T> Map<String, Long> searchForSimilarElementsWithFunctionalInterface(T[] array, List<? extends T> list) {
        List<T> tempList = new ArrayList<>(list); // for not change the list
        tempList.addAll(Arrays.asList(array));
        return tempList.stream().collect(Collectors.groupingBy(T::toString, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }


    static <T> void addElementsToArrayListIfItIsNotThereWithFunctionalInterface(T[] array, List<? super T> list) {
        list.addAll(Arrays.stream(array).filter(temp -> !list.contains(temp)).toList());
    }
}

