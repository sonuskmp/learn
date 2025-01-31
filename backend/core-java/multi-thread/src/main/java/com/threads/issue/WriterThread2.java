package com.threads.issue;

public class WriterThread2 extends Thread {
    private Resource resource;

    public WriterThread2(Resource resource){
        this.resource = resource;
    }
    
    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            this.resource.write("2_"+i, "B"+i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
