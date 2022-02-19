package BankViikko6;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Account> accountList = new ArrayList<>();

    public static void createAccount(String number, int money) {
        Account account = new Account.RegularAccount(number, money);
        accountList.add(account);
        System.out.println("Account created.");
    }

    public static void createAccount(String number, int money, int credit) {
        Account account = new Account.CreditAccount(number, money, credit);
        accountList.add(account);
        System.out.println("Account created.");
    }

    public static Account searchAccount(String number) {
        for (Account a : accountList) {
            if (number.equals(a.getAccountNumber())) {
                return a;
            }
        }
        return null;
    }

    public static void removeAccount(Account account) {
        accountList.remove(account);
        System.out.println("Account removed.");
    }

    public static void printAllAccounts() {
        System.out.println("All accounts:");
        accountList.forEach(System.out::println);
    }
}
