package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getSurname().compareTo(o1.getSurname());
            }
        };
        return students.stream()
                .filter(Objects::nonNull)
                .sorted(comparator)
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
