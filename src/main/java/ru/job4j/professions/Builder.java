package ru.job4j.professions;

public class Builder extends Engineer {
    private int age;

    public Builder(String name, String surname, String education, String descriptionProfession, int birthday, int age) {
        super(name, surname, education, descriptionProfession, birthday);
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void stirTheCement() {

    }
}