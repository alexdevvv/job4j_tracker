package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = x -> x.getName().contains(key);
        Predicate<Person> predSurname = x -> x.getSurname().contains(key);
        Predicate<Person> predAdress = x -> x.getAddress().contains(key);
        Predicate<Person> predPhone = x -> x.getPhone().contains(key);
        Predicate<Person> combine = predPhone.or(predName).or(predAdress).or(predSurname);
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
