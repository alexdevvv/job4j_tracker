package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = x -> x.getAddress().contains(key)
                || x.getName().contains(key)
                || x.getPhone().contains(key)
                || x.getSurname().contains(key);
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
