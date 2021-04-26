package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Account опичывает модель данных Account
 * (аккаунт пользователя) с методами
 * инициализаци и доступа к его полям.
 * @author ALEKSANDR SERGEEV
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     *
     * @param requisite реквизиты аккаунта
     * @param balance баланс аккаунта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0
                && Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite, balance);
    }
}
