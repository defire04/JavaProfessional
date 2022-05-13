package com.company;

import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Dispatcher {
    public static void main(String[] args) {
        List<Integer> list = List.of(-9, 6, 3, 4, 2, 5, 3, 4, 6, 9);
        String st = """
                Text for test.
                Thinking In Java should be read cover to cover by every Java programmer, then kept close at hand for frequent reference. 
                The exercises are challenging, and the chapter on Collections is superb! Not only did this book help me to pass the Sun Certified Java Programmer exam; 
                it’s also the first book I turn to whenever I have a Java question. Jim Pleger, Loudoun County (Virginia) Government
                Much better than any other Java book I’ve seen. Make that “by an order of magnitude”. Very complete, with excellent right-to-the-point examples and intelligent, not dumbed-down, explanations.
                In contrast to many other Java books I found it to be unusually mature, consistent, intellectually honest, well-written and precise. IMHO, an ideal book for studying Java. 
                Anatoly Vorobey, Technion University, Haifa, Israel
                Thank you again for your awesome book. I was really floundering (being a non-C programmer), but your book has brought me up to speed as fast as I could read it. It’s really cool to be able to understand
                the underlying principles and concepts from the start, rather than having to try to build that conceptual model through trial and error. Hopefully I will be able to attend your seminar in the 
                not-too-distant future. Randall R Hawley, Automation Technician, Eli Lilly & Co.
                The best computer book writing I have seen.
                This is one of the best books I’ve read about a programming language. The best book ever written on Java. Ravindra Pai, Oracle Corporation, SUNOS product line
                This is the best book on Java that I have ever found! You have done a great job. Your depth is amazing. I will be purchasing the book when it is published. 
                I have been learning Java since October 96. I have read a few books, and consider yours a “MUST READ”.
                These past few months we have been focused on a product written entirely in Java. Your book has helped solidify topics I was shaky on and has expanded my knowledge base.
                I have even used some of your explanations as information in interviewing contractors to help our team. I have found how much Java knowledge they have by asking them about things
                I have learned from reading your book (e g , the difference between arrays and Vectors).Your book is great! Steve Wilkinson, Senior Staff Specialist, MCI Telecommunications.""";
//        System.out.println("------------------------====First task====------------------------" +
//                "\nChange max and minimum in collection:\n" + Controller.changeMaximumAndMinimum(list) +
//                "\n------------------------====Second task====------------------------" +
//                "\nCollection of elements is greater than the arithmetic mean:\n"
//                + Controller.collectionOfElementsGreaterThanArithmeticMean(list) +
//                "\n------------------------====Third task====------------------------");
        Controller.createMapWhereKeyIndexSupplyValueDifferenceBetweenConsonantsAndVowels(st)
                .forEach((key, value) -> System.out.println("Sentence number:" + key + " Has a distinction between vowels and consonants:" + value));

        System.out.println("-------------------------------------------------------------");
        Controller.createMapWhereKeyIndexSupplyValueDifferenceBetweenConsonantsAndVowels2(st)
                .forEach((key, value) -> System.out.println("Sentence number2:" + key + " Has a distinction between vowels and consonants2:" + value));
    }

}

