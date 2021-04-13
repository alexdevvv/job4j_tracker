package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
    public static void main(String[] args) {
        Map<String, String> userDate = new HashMap<>();
        userDate.put("aaa@gmail.com", "Donald Trump");
        userDate.put("cng@gmail.com", "Ivan Ivanov");

        for (String mail : userDate.keySet()) {
            String value = userDate.get(mail);
            System.out.println(mail + " " + value);
        }

    }
}
