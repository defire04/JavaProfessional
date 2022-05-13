package com.company;

import java.util.List;

class CounterSpace implements Runnable {

    private final List<FileWrapper> files;

    CounterSpace(List<FileWrapper> files) {
        this.files = files;
        new Thread(this).start();
    }

    @Override
    public void run() {
        files.forEach(FileWrapper::countSpace);
    }
}
