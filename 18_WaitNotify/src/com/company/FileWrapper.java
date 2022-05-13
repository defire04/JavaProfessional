package com.company;

import java.io.*;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;


class FileWrapper {

    private final String fileName;
    private boolean isPair;
    private boolean isFileRead;
    private List<String> allText = new ArrayList<>();


    FileWrapper(String file) {
        this.fileName = file;
    }


    synchronized void countSpace() {
        if (isFileRead) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int forTesting = 0;
//            allText = Files.readAllLines(Path.of(fileName));

            while ((line = reader.readLine()) != null) {
                Collections.addAll(allText, line.split(" "));
                if (++forTesting % 10 == 0) {
                    System.out.println("COUNTING " + Thread.currentThread().getName() + " " + this.fileName);
                }
            }


            isPair = (allText.size() - 1) % 2 == 0;
            isFileRead = !isFileRead;
            notify();
            System.out.println("Reading finished!" + Thread.currentThread().getName() + " " + this.fileName + "\n" +
                    "----------------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized void rewriteFile() {
        if (!isFileRead) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//           ----------------------------====First solution====----------------------------
//        long time = System.nanoTime();
        if (isPair) {
            forPair();
        } else {
            forUnpair();
        }
//            System.out.println(System.nanoTime() - time);

// TODO: какой способ лучше?

//           ----------------------------====Second solution====----------------------------
//        long time2 = System.nanoTime();
//        int forTesting = 0;
//        int forLengthInLine = 0;
//        try (PrintWriter writer = new PrintWriter(fileName)) {
//            for (String word : allText) {
//                if (word.length() > 1) {
//                    if (isPair) {
//                        if (word.startsWith(".") || word.startsWith(",") || word.startsWith(";")
//                                || word.startsWith(":") || word.startsWith("!")) {
//                            writer.print(word.charAt(0) + word.substring(1, 2).toUpperCase() + word.substring(2) + " ");
//                        } else {
//                            writer.print(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
//                        }
//
//                    } else {
//                        if (word.endsWith(".") || word.endsWith(",") || word.endsWith(";")
//                                || word.endsWith(":") || word.endsWith("!")) {
//                            writer.print(word.substring(0, word.length() - 2) +
//                                    word.substring(word.length() - 2).toUpperCase() + " ");
//                        } else {
//                            writer.print(word.substring(0, word.length() - 1) +
//                                    word.substring(word.length() - 1).toUpperCase() + " ");
//                        }
//                    }
//                } else {
//                    writer.print(word.toUpperCase() + " ");
//                }
//                if (++forLengthInLine == 20) {
//                    writer.println();
//                    forLengthInLine = 0;
//                }
//
//                if (++forTesting % 5 == 0) {
//                    System.out.println("----REWRITING " + Thread.currentThread().getName() + " " + this.fileName);
//                }
//            }
//            writer.flush();
//        System.out.println(System.nanoTime() - time2);

        isFileRead = !isFileRead;
        notify();
        System.out.println("Rewriting finished! " + Thread.currentThread().getName() + " " + this.fileName + "\n" +
                "----------------------------------------------------------------");
    }


    private void forPair() {
        int forTest = 0;
        int forLengthInLine = 0;
        try (PrintWriter writer = new PrintWriter(fileName)) {
            try {
                for (String word : allText) {
                    if (word.length() > 1) {
                        if (word.startsWith(".") || word.startsWith(",") || word.startsWith(";")
                                || word.startsWith(":") || word.startsWith("!")) {
                            writer.print(word.charAt(0) + word.substring(1, 2).toUpperCase() + word.substring(2) + " ");
                        } else {
                            writer.print(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
                        }
                    } else {
                        writer.print(word.toUpperCase() + " ");
                    }
                    if (++forLengthInLine == 20) {
                        writer.println();
                        forLengthInLine = 0;
                    }
                    if (++forTest % 5 == 0) {
                        System.out.println("----REWRITING" + Thread.currentThread().getName() + " " + this.fileName);
                    }
                }
            } finally {
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void forUnpair() {
        int forTest = 0;
        int forLengthInLine = 0;
        try (PrintWriter writer = new PrintWriter(fileName)) {
            try {
                for (String word : allText) {
                    if (word.length() > 1) {
                        if (word.endsWith(".") || word.endsWith(",") || word.endsWith(";")
                                || word.endsWith(":") || word.endsWith("!")) {
                            writer.print(word.substring(0, word.length() - 2) +
                                    word.substring(word.length() - 2).toUpperCase() + " ");
                        } else {
                            writer.print(word.substring(0, word.length() - 1) +
                                    word.substring(word.length() - 1).toUpperCase() + " ");
                        }
                    } else {
                        writer.print(word.toUpperCase() + " ");
                    }
                    if (++forLengthInLine == 20) {
                        writer.println();
                        forLengthInLine = 0;
                    }
                    if (++forTest % 5 == 0) {
                        System.out.println("----REWRITING " + Thread.currentThread().getName() + " " + this.fileName);
                    }
                }
            } finally {
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}