package lab.second.accounts;

import java.io.*;
import java.util.Random;
import java.util.Vector;

public class Bank {
    Vector<Account> accounts;
    Random random;

    public Bank() {
        this.accounts = new Vector<>();
        this.random = new Random();
    }

    public void update() {
        for(Account account : accounts) {
            System.out.println(account);
            account.deposit(random.nextDouble() * 500);
            account.withdraw(random.nextDouble() * 100);
            System.out.println(account);

            if(account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            }

            System.out.println(account);
        }
    }

    public void openAccount(Account account) {
        this.accounts.add(account);
    }

    public void closeAccount(Account account) {
        this.accounts.remove(account);
    }

    public Vector<Account> getAccounts() {
        return this.accounts;
    }

    public String toString() {
        return ("Current accounts in the back: " + this.getAccounts());
    }
}