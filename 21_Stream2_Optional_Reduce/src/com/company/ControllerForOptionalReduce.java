package com.company;

import java.util.Arrays;
import java.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.stream.Collectors;


public class ControllerForOptionalReduce {

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
