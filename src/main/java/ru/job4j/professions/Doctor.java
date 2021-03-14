package ru.job4j.professions;

public class Doctor extends Profession {
    private String descriptionProfession;

    public Doctor(String name, String surname, String education, String descriptionProfession, int birthday) {
        super(name, surname, education, birthday);
        this.descriptionProfession = descriptionProfession;
    }

    public String getDescriptionProfession() {
        return descriptionProfession;
    }

    public void diagnosis() {

    }
}
