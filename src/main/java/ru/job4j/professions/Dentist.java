package ru.job4j.professions;

public class Dentist extends Doctor {
    private int age;

    public Dentist(String name, String surname, String education, String descriptionProfession, int birthday, int age) {
        super(name, surname, education, descriptionProfession, birthday);
        this.age = getAge();
    }


    public int getAge() {
        return age;
    }

    public void removeTooth() {

    }
}
