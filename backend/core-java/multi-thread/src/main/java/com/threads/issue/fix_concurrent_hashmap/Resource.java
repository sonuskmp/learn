package com.threads.issue.fix_concurrent_hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class Resource {
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public void write(String key, String val) {
        map.put(key, val);
    }

    public void read() {
        System.out.println("Reading Map...");
        for (String key : map.keySet()) {
            System.out.println(key + "|" + map.get(key));
        }
    }
}