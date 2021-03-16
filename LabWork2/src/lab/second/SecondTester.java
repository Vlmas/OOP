package lab.second;

import lab.second.accounts.*;
import lab.second.circuit.*;

public class SecondTester {
    public static void main(String[] args) {
        // Problem 4
        /*
        CheckingAccount acc1 = new CheckingAccount(1);
        SavingsAccount acc2 = new SavingsAccount(2, 0.05f);
        SavingsAccount acc3 = new SavingsAccount(3, 0.05f);
        Account acc4 = new Account(4);
        Bank bank = new Bank();
        bank.openAccount(acc1);
        bank.openAccount(acc2);
        bank.openAccount(acc3);
        bank.openAccount(acc4);

        bank.update();
        System.out.println(bank);
        */
        // Problem 5

        Circuit a = new Resistor(3);
        Circuit b = new Resistor(3);
        Circuit c = new Resistor(6);
        Circuit d = new Resistor(3);
        Circuit e = new Resistor(2);
        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c ,d);
        Circuit h = new Series(g, e);
        Circuit circuit = new Parallel(h, f);
        System.out.println(circuit.getResistance());

    }
}