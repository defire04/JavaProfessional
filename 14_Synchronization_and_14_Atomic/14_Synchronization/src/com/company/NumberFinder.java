package com.company;

class NumberFinder implements Runnable {
    private final FileWrapper file;
    private final Thread thread;

    public FileWrapper getFile() {
        return this.file;
    }

    NumberFinder(FileWrapper file) {
        this.file = file;
        thread= new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        file.sumOfNumbers();
    }
}