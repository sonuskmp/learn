package com.threads.issue.fix_ReentrantReadWriteLock;

public class ReaderThread extends Thread {
    private Resource resource;

    public ReaderThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            resource.read();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
