package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс User описывает модель данных User (пользователь)
 * с методами инициализаци и доступа к его полям.
 * @author ALEKSANDR SERGEEV
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор для класса User
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, username);
    }
}
