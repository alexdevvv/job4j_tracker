package ru.job4j.collection;

import java.util.*;
import java.util.HashMap;

public class UserMap {
    public static void main(String[] args) {
        Map<String, String> userDate = new HashMap<>();
        userDate.put("aaa@gmail.com", "Donald Trump");
        userDate.put("cng@gmail.com", "Ivan Ivanov");
        userDate.put("cngg@gmail.com", "Ivan Sidorov");
        userDate.put("cnggsad@gmail.com", "Gnida");
        userDate.put("cnggfd@gmail.com", "Semen");

        for (Map.Entry entry : userDate.entrySet()) {

            System.out.println("Key - " + entry.getKey() + " " + entry.getValue());

        }

    }
}
