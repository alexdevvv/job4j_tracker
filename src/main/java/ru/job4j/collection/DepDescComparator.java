package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = o1.compareTo(o2);
        if (rsl == 0) {
            rsl = o2.compareTo(o1);
        }
        return rsl;
    }
}
