package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService представляет собой упрощенную модель
 * реализации банковской системы.
 * @author ALEKSANDR SERGEEV
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение данных пользователя осуществляется в Map users
     * и представляет собой пару ключ - значение (Пользователь - Список Аккаунтов)
     * У каждого пользователя может быть несколько счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет
     * его в наше хранилище users.
     * @param user пользователь, которого нужно добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспорт и аккаунт пользователя.
     * Если пользователь есть и него нет аккаунта с переданными
     * реквизитами, то добавляет этот аккаунт пользователю.
     * @param passport данные паспорта пользователя
     * @param account аккаунт для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод принимает паспортные данные и производит
     * поиск пользователя с этими данными в нашей системе.
     * @param passport паспортные дынные
     * @return возвращаем найденого пользователя или null если
     * такого пользователя нет в системе
     */
    public User findByPassport(String passport) {
       return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает паспорт и реквизиты и производит
     * поиск аккаунта с указанными данными.
     * @param passport паспортные данные
     * @param requisite реквзиты аккаунта
     * @return возвращает аккаунт, если аккаунт с реквизитами
     * есть в системе, иначе возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
            if (user != null) {
                return users.get(user)
                        .stream()
                        .filter(s -> s.getRequisite().equals(requisite))
                        .findFirst()
                        .orElse(null);
            }
        return null;
    }

    /**
     * Метод принимает реквизиты и осуществляет перевод
     * денежных средств между аккаунтами, если это возможно.
     * @param scrPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод прошел успешно, иначе false
     */
    public boolean transferMoney(String scrPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
            Account srcAccount = findByRequisite(scrPassport, srcRequisite);
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if ((srcAccount != null && destAccount != null)
                    && srcAccount.getBalance() >= amount) {
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    srcAccount.setBalance(srcAccount.getBalance() - amount);
                    rsl = true;
            }
        return rsl;
    }

}

