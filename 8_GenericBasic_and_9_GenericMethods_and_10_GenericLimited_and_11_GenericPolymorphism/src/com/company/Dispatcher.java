package com.company;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Dispatcher {
    public static void main(String[] args) {

        Animal[] animals = {new Cat(5), new Dog(7), new Poodle(4), new Cat(5)};
        List<Animal> animalsList1 = new ArrayList<>(Arrays.asList(new Cat(5),new Cat(5), new Dog(7)));

        Cat[] cat = {new Cat(4), new Cat(2)};
        List<Dog> dogsList = List.of(new Dog(4));
//
//        View.display(Controller.searchForSimilarElements(cat, dogsList));
//        View.display(Controller.addElementsToArrayListIfItIsNotThere(cat, dogsList));






//        View.display(Controller.searchForSimilarElements(animals, animalsList1));
//        Controller.addElementsToArrayListIfItIsNotThere(animals, animalsList1);
//        View.display(animalsList1);


//        String[] str = {"Serge", "Dima", "Dima","Bob", "Dima"};
//        List<String> strLs = new ArrayList<>(Arrays.asList("Dima", "Dima", "Bob", "Dima"));
//
//        View.display(Controller.searchForSimilarElements(str, strLs));
//        Controller.addElementsToArrayListIfItIsNotThere(str, strLs);
//        View.display(strLs);

    }
}
