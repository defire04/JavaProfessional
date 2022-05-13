package com.company;

import java.util.*;

public class Dispatcher {
    public static void main(String[] args) {

        String[] arr1 = "I like Java".split(" ");
        String[] arr2 = "and Python".split(" ");
        System.out.println(Arrays.toString(ControllerForOptionalReduce.concatenationOfTwoArrays(arr1, arr2)));


        Integer [] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Average number in array is : " + ControllerForOptionalReduce.numberOfElementsGreaterThanAverageValueInArray(arr3));
        System.out.println(Arrays.toString(ControllerForOptionalReduce.deleteMaxAndMinElementIntoArray(arr3)));
    }
}






