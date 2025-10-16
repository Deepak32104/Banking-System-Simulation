package service;

import java.util.*;
import model.Account;

public class BankService {
    private static final Map<Integer, Account> accounts = new HashMap<>();
    private static int nextAccountNumber = 1001;

    public static Account createAccount(String name, double initialDeposit) {
        Account acc = new Account(name, nextAccountNumber++, initialDeposit);
        accounts.put(acc.getAccountNumber(), acc);
        return acc;
    }

    public static Account getAccount(int accNo) {
        return accounts.get(accNo);
    }

    public static boolean deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    public static boolean withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        return (acc != null) && acc.withdraw(amount);
    }

    public static boolean transfer(int from, int to, double amount) {
        Account sender = accounts.get(from);
        Account receiver = accounts.get(to);
        if (sender != null && receiver != null)
            return sender.transfer(receiver, amount);
        return false;
    }

    public static Collection<Account> getAllAccounts() {
        return accounts.values();
    }
}
