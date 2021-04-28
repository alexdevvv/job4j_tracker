package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> boCon = (s, n) -> map.put(s, n);
        boCon.accept(1, "one");
        boCon.accept(2, "two");
        boCon.accept(3, "three");
        boCon.accept(4, "four");
        boCon.accept(5, "five");
        boCon.accept(6, "six");
        boCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<String>(map.values());
        List<String> strings = new ArrayList<>(map.values());

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = (newString) -> newString.toUpperCase();
        for (String s : strings) {
            System.out.println(func.apply(s));
        }
    }
}
