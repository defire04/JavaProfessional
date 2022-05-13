package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAdder;

public class Dispatcher {

    static DoubleAdder result = new DoubleAdder();

    public static void main(String[] args)  {

        List<NumberCounter> listFileNames = new ArrayList<>();
        listFileNames.add(new NumberCounter("File1"));
        listFileNames.add(new NumberCounter("File2"));
        listFileNames.add(new NumberCounter("File3"));

        try {
            Controller.threadsStarter(listFileNames);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
