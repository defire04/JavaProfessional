package com.company;

import java.io.File;

public class Main {
    public static void main(String[] args)  {
        Controller.parsing(new File("text.txt"),new File("result.txt"));
    }
}
