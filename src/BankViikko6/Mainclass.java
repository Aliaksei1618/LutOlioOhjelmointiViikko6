package BankViikko6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {

    public static void main(String[] args) throws IOException {
        String choice;
        Account account;
        String number;
        int money;
        int credit;

        while (true) {
            System.out.print("\n*** BANK SYSTEM ***\n" +
                    "1) Add a regular account\n" +
                    "2) Add a credit account\n" +
                    "3) Deposit money\n" +
                    "4) Withdraw money\n" +
                    "5) Remove an account\n" +
                    "6) Print account information\n" +
                    "7) Print all accounts\n" +
                    "0) Quit\n" +
                    "Your choice: ");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            choice = consoleReader.readLine();

            switch (choice) {
                case "1":
                    System.out.print("Give an account number: ");
                    number = consoleReader.readLine();
                    System.out.print("Amount of money to deposit: ");
                    money = Integer.parseInt(consoleReader.readLine());
                    Bank.createAccount(number, money);
                    break;
                case "2":
                    System.out.print("Give an account number: ");
                    number = consoleReader.readLine();
                    System.out.print("Amount of money to deposit: ");
                    money = Integer.parseInt(consoleReader.readLine());
                    System.out.print("Give a credit limit: ");
                    credit = Integer.parseInt(consoleReader.readLine());
                    Bank.createAccount(number, money, credit);
                    break;
                case "3":
                    System.out.print("Give an account number: ");
                    number = consoleReader.readLine();
                    System.out.print("Amount of money to deposit: ");
                    money = Integer.parseInt(consoleReader.readLine());
                    account = Bank.searchAccount(number);
                    if (account != null) {
                        account.depositmoney(money);
                    }
                    break;
                case "4":
                    System.out.print("Give an account number: ");
                    number = consoleReader.readLine();
                    System.out.print("Amount of money to withdraw: ");
                    money = Integer.parseInt(consoleReader.readLine());
                    account = Bank.searchAccount(number);
                    if (account != null) {
                        account.withdrawmoney(money);
                    }
                    break;
                case "5":
                    System.out.print("Give the account number of the account to delete: ");
                    number = consoleReader.readLine();
                    account = Bank.searchAccount(number);
                    if (account != null) {
                        Bank.removeAccount(account);
                    }
                    break;
                case "6":
                    System.out.print("Give the account number of the account to print information from: ");
                    number = consoleReader.readLine();
                    account = Bank.searchAccount(number);
                    if (account != null) {
                        System.out.println(account);
                    }
                    break;
                case "7":
                    Bank.printAllAccounts();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
