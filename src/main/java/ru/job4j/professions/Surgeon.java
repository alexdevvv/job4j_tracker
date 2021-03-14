package ru.job4j.professions;

public class Surgeon extends Doctor {
    private int age;

    public Surgeon(String name, String surname, String education, String descriptionProfession, int birthday, int age) {
        super(name, surname, education, descriptionProfession, birthday);
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void makeOpretion() {

    }
}
