package lab.second.accounts;

import java.util.Objects;

public class Account {
    private double balance;
    private int accNumber;

    public Account() {}

    public Account(int accNumber) {
        this.balance = 0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        this.balance += sum;
    }

    public void withdraw(double sum) {
        this.balance -= sum;
    }

    public void transfer(double amount, Account other) {
        this.withdraw(amount);
        other.deposit(amount);
    }

    public final void print() {
        System.out.println(this.toString());
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccNumber() {
        return this.accNumber;
    }

    public String toString() {
        return ("Account number is " + this.accNumber + ", with balance of " + this.balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return (accNumber == account.accNumber && balance == account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber);
    }
}
