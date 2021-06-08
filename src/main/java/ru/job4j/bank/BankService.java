package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
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
//    public User findByPassport(String passport) {
//       return users.keySet()
//                .stream()
//                .filter(s -> s.getPassport().equals(passport))
//                .findFirst()
//                .orElse(null);
//    }
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = users.keySet()
                .stream().filter(s -> s.getPassport().equals(passport))
                .findFirst();
        return rsl;
    }

    /**
     * Метод принимает паспорт и реквизиты и производит
     * поиск аккаунта с указанными данными.
     * @param passport паспортные данные
     * @param requisite реквзиты аккаунта
     * @return возвращает аккаунт, если аккаунт с реквизитами
     * есть в системе, иначе возвращает null.
     */
//    public Account findByRequisite(String passport, String requisite) {
//        User user = findByPassport(passport);
//            if (user != null) {
//                return users.get(user)
//                        .stream()
//                        .filter(s -> s.getRequisite().equals(requisite))
//                        .findFirst()
//                        .orElse(null);
//            }
//        return null;
//    }
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> ac = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            ac = users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return ac;
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
            Optional<Account> srcAccount = findByRequisite(scrPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
            if ((srcAccount.isPresent() && destAccount.isPresent())
                    && srcAccount.get().getBalance() >= amount) {
                    destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                    srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                    rsl = true;
            }
        return rsl;
    }

}

