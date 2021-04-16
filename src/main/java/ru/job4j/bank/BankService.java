package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
            if (user != null) {
                for (Account account : users.get(user)) {
                    if (account.getRequisite().equals(requisite)) {
                        rsl = account;
                        break;
                    }
                }
            }
            return rsl;
        }

    public boolean transferMoney(String scrPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
            Account srcAccount = findByRequisite(scrPassport, srcRequisite);
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if ((srcAccount != null && destAccount != null) &&
                    srcAccount.getBalance() >= amount) {
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    srcAccount.setBalance(srcAccount.getBalance() - amount);
                    rsl = true;
            }
        return rsl;
    }

}

