package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int value = 0;
        if (s1.contains(s2) && s1.length() > s2.length()) {
            value = 1;
        } else if (s2.contains(s1) && s2.length() > s1.length()) {
            value = -1;
        } else {
            int rsl = s1.length() >= s2.length() ? s2.length() : s1.length();
            for (int i = 0; i < rsl; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    value = 1;
                } else {
                    value = -1;
                }
            }
        }
        return value;
    }
}
