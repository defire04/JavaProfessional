package com.company;

import java.util.List;

class Rewriter implements Runnable {

    private final List<FileWrapper> files;

    Rewriter(List<FileWrapper> files) {
        this.files = files;
        new Thread(this).start();
    }

    @Override
    public void run() {
        files.forEach(FileWrapper::rewriteFile);
    }
}
