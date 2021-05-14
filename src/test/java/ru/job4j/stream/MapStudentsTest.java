package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MapStudentsTest {

    @Test
    public void createMapStudents() {
        List<Student> listStudent = Arrays.asList(
                new Student("Vasin", 1),
                new Student("Vasin", 1),
                new Student("Feldman", 89),
                new Student("Zabolotny", 10),
                new Student("Zabolotny", 11),
                new Student("Buzova", 19),
                new Student("Makarov", 98)
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Feldman", new Student("Feldman", 95));
        expect.put("Makarov", new Student("Makarov", 98));
        MapStudents ms = new MapStudents();
        Map<String, Student> rsl = ms.createMapStudents(listStudent);
        assertThat(rsl.size(), is(5));

    }
}