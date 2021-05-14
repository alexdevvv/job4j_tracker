package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Student, Set<Subject>> student = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Algebra", 95),
                        new Subject("Development Java", 91),
                        new Subject("English", 58))
        );

        College college = new College(student);
        Optional<Student> rsl = college.findByAccount("000001");
        System.out.println(rsl);
        Optional<Subject> sbj = college.findBySubjectName("000001", "Development Java");
        System.out.println(sbj);
    }
}
