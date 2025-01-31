package com.threads.issue;

import java.util.HashMap;
import java.util.Map;

public class Resource {
    private Map<String, String> map = new HashMap<>();

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