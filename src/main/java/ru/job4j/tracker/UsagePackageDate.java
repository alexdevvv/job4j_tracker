package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
//        LocalDate currentDate = LocalDate.now();
//        System.out.println("Текущая дата: " + currentDate);
//        LocalTime time = LocalTime.now();
//        System.out.println("Текущее время: " + time);

        LocalDateTime currentDataTime = LocalDateTime.now();
        System.out.println("Текущая дата и время: " + currentDataTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDataTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

    }
}
