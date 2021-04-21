package ru.job4j.professions;

public class Engineer extends Profession {
    private String descriptionProfession;

    public Engineer(String name, String surname, String education,
                    String descriptionProfession, int birthday) {
        super(name, surname, education, birthday);
        this.descriptionProfession = descriptionProfession;
    }

    public String getDescriptionProfession() {
        return descriptionProfession;
    }

    public void thinkYourBrain() {
    }
}
