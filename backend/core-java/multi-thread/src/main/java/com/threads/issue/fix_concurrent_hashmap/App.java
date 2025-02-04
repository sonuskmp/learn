package com.threads.issue.fix_concurrent_hashmap;

public class App {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Thread writer1 = new WriterThread1(resource);
        Thread writer2 = new WriterThread2(resource);
        Thread reader = new ReaderThread(resource);

        writer1.start();
        writer2.start();
        reader.start();
    }
}