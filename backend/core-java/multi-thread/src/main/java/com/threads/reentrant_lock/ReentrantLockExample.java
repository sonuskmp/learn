package com.threads.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void method1() {
        lock.lock();
        try {
            System.out.println("Method 1 executing...");
            method2();  // Reacquires the lock
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();  // Allowed since it's the same thread
        try {
            System.out.println("Method 2 executing...");
        } finally {
            lock.unlock();
        }
    }
}
