package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -400, 24, 0, 324, -45, -67, 123, 9, 4, -1000)
                .stream()
                .filter(p -> p > 0)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
