package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public static void parsing(File initialFile, File resultFile) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину слова: ");

        int wordLength = scanner.nextInt();

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(resultFile);
            br = new BufferedReader(new FileReader(initialFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] symbolArr = {".", "?", ",", "!", ":", ";"};

                for (String symb : symbolArr) {
                    line = line.replace(symb, (" " + symb));
                }

                for (String word : line.split(" ")) {
                    word += " ";

                    if (word.replaceAll("[.,?!]", "").length() - 1 != wordLength) {
                        pw.print(word);
                    } else {

                        if (wordLength == word.length() - 1) {
                            Pattern p = Pattern.compile("\\b[AEIOYUaeioyu].");
                            word = word.replace(" ", "");
                            Matcher m = p.matcher(word);

                            if (m.find()) {
                                pw.print(word + " ");
                            }
                        } else {
                            pw.print(word + " ");
                        }
                    }
                }
                pw.println();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.flush();
            pw.close();
        }
        System.out.println("Success!");
    }
}
