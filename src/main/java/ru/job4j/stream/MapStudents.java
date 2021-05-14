package ru.job4j.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapStudents {
    public Map<String, Student> createMapStudents(List<Student> listStudents) {
        return listStudents.stream()
                .collect(
                        Collectors.toMap(
                             Student::getSurname,
                                s -> s,
                                (s1, s2) -> s1
                )
        );
    }
}
