package com.company;

import java.io.File;

class FileWrapper implements Comparable<FileWrapper> {
    private final File file;
    private int punctuationSymbolCount;

    public File getFile() {
        return file;
    }
    public int getPunctuationSymbolCount() {
        return punctuationSymbolCount;
    }

    protected void setPunctuationSymbolCount(int punctuationSymbolCount) {
        this.punctuationSymbolCount = punctuationSymbolCount;
    }

    FileWrapper(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return this.file + " has " + this.punctuationSymbolCount + " delimiters";
    }

    @Override
    public int compareTo(FileWrapper otherFile) {
        return otherFile.punctuationSymbolCount - this.punctuationSymbolCount;
    }
}