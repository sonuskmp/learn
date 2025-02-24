package com.threads.volatile_keyword;

public class VolatileEx {
    private static volatile boolean flag = true;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(flag){
                //System.out.println("Thread Running.....");
            }
            System.out.println("thread stopped.");
        });

        t1.start();

       flag = false; //try changing flag to stop while.. This change will refelct

        System.out.println("Main thread updated flag to false.");
    }
}
