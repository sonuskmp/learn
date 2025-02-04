package com.threads.issue.fix_sychronized;

import java.util.HashMap;
import java.util.Map;

public class Resource {
    private Map<String, String> map = new HashMap<>();

    public void write(String key, String val) {
        synchronized(this) {
            map.put(key, val);
        }
    }

    public void read() {
        synchronized(this) {
            System.out.println("Reading Map...");
            for (String key : map.keySet()) {
                System.out.println(key + "|" + map.get(key));
            }
        }
    }
}