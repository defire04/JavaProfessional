package com.company;

class WorldFinder implements Runnable {

    private final FileWrapper file;

    public FileWrapper getFile() {
        return file;
    }

    WorldFinder(FileWrapper file) {
        this.file = file;
    }

    @Override
    public void run() {
        file.adder();
    }
}