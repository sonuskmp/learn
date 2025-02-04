package com.threads.issue.fix_ReentrantReadWriteLock;

public class WriterThread1 extends Thread {
    private Resource resource;

    public WriterThread1(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            this.resource.write("1_"+i, "A"+i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
