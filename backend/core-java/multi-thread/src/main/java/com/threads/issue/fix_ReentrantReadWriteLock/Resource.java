package com.threads.issue.fix_ReentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Resource {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Map<String, String> map = new HashMap<>();

    public void write(String key, String val) {
        lock.writeLock().lock();
        try {
            map.put(key, val);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println("Reading Map...");
            for (String key : map.keySet()) {
                System.out.println(key + "|" + map.get(key));
            }
        } finally {
            lock.readLock().unlock();
        }
    }
}