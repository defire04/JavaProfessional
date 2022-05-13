package com.company;

import java.util.Set;

class View {
    static void printSet(Set<?> set){
        set.forEach(System.out::println);
    }
}
