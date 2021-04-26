package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] rsl1 = o1.split("/");
        String[] rsl2 = o2.split("/");
        int rsl = rsl1[0].compareTo(rsl2[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
