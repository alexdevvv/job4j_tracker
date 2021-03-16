package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup(2);
        student.setDateReceipt(new Date());

        System.out.println(System.lineSeparator()
                           + "Student's full name: " + student.getName() + System.lineSeparator()
                           + "Group: " + student.getGroup() + System.lineSeparator()
                           + "Date of receipt: " + student.getDateReceipt() + ".");
    }
}
