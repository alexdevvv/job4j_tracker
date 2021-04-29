package ru.job4j.lambda;

import java.util.*;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "1",
                "12345",
                "12",
                "123"
        );

        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        Collections.sort(list, comparator);
    }

}
