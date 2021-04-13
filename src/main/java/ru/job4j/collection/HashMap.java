package ru.job4j.collection;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
