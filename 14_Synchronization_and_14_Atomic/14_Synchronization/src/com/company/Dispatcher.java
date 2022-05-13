package com.company;

import java.util.List;
import java.util.ArrayList;

public class Dispatcher {
    static Result result = new Result();
    public static void main(String[] args)  {
        System.out.println("Main thread started (" + Thread.currentThread().getId() + ")");

        List<FileWrapper> listFileNames = new ArrayList<>();
        listFileNames.add(new FileWrapper("File1"));
        listFileNames.add(new FileWrapper("File2"));
        listFileNames.add(new FileWrapper("File3"));

        Controller.treadsStarter(listFileNames);


        System.out.println(result);
        System.out.println("Main thread finished (" + Thread.currentThread().getId() + ")");
    }
}