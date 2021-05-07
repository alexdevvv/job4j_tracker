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
                new Student(1, "Vasin"),
                new Student(1, "Vasin"),
                new Student(89, "Feldman"),
                new Student(10, "Zabolotny"),
                new Student(11, "Zabolotny"),
                new Student(19, "Buzova"),
                new Student(98, "Makarov")
        );
        Map<String, Student> expect = new HashMap<>();
        expect.put("Feldman", new Student(95, "Feldman"));
        expect.put("Makarov", new Student(98, "Makarov"));
        MapStudents ms = new MapStudents();
        Map<String , Student> rsl = ms.createMapStudents(listStudent);
        assertThat(rsl.size(), is(5));

    }
}