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
                .distinct()
                .collect(
                        Collectors.toMap(
                             Student::getSurname,
                             s -> new Student(s.getScore(), s.getSurname()),
                                (s1, s2) -> {
                                 return s1.equals(s2) ? s1 : s2;
                                }
                )
        );
    }
}
