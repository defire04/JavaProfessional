package com.company;

import java.util.Arrays;
import java.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.stream.Collectors;

public class ControllerForOptionalReduce {
    public static void launchTaskFromSecondTopic() {
        System.out.println("-----------------====Task from Second topic====-----------------");
        String[] arr1 = "I like Java".split(" ");
        String[] arr2 = "and Python".split(" ");
        Integer[] arr3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(ControllerForOptionalReduce.concatenationOfTwoArrays(arr1, arr2)));
        System.out.println("Average number in array is : " + ControllerForOptionalReduce.numberOfElementsGreaterThanAverageValueInArray(arr3));
        System.out.println(Arrays.toString(ControllerForOptionalReduce.deleteMaxAndMinElementIntoArray(arr3)));
    }


    @SuppressWarnings("unchecked")
    static <T> T[] concatenationOfTwoArrays(T[] firstArray, T[] secondArray) {
        return Stream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray(size -> (T[])
                Array.newInstance(firstArray.getClass().getComponentType(), size));
    }


    static double numberOfElementsGreaterThanAverageValueInArray(Integer[] array) {
        return Arrays.stream(array).collect(Collectors.averagingInt(Integer::intValue));
    }


    static int[] deleteMaxAndMinElementIntoArray(Integer[] array) {
        return  Arrays.stream(array).filter(element ->
                element != Arrays.stream(array).mapToInt(i -> i).max().getAsInt()
                        && element != Arrays.stream(array).mapToInt(i -> i).min().getAsInt()).mapToInt(Integer::intValue).toArray();
    }
}
