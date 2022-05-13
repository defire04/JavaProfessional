package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.concurrent.Callable;

class PunctuationChecker implements Callable<FileWrapper> {
    private final FileWrapper fileWrap;

    public FileWrapper getFileWrap() {
        return fileWrap;
    }

    PunctuationChecker(FileWrapper fileWrap) {
        this.fileWrap = fileWrap;
    }

    @Override
    public FileWrapper call() {
        int charSymbol, count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileWrap.getFile()))) {
            while ((charSymbol = reader.read()) != -1) {
                if (charSymbol == '.' | charSymbol == ',' | charSymbol == ';'
                        | charSymbol == ':' | charSymbol == '!') {
                    this.fileWrap.setPunctuationSymbolCount(++count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.fileWrap;
    }
}
