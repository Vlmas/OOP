package lab.second.accounts;

public class CheckingAccount extends Account {
    private int transactionCounter;
    private final int FREE_TRANSACTIONS;

    {
        FREE_TRANSACTIONS = 2;
    }

    public CheckingAccount() {}

    public CheckingAccount(int accNumber) {
        super(accNumber);
    }

    public void deposit(double sum) {
        super.deposit(sum);
        deductFee();
    }

    public void withdraw(double sum) {
        super.withdraw(sum);
        deductFee();
    }

    public void deductFee() {
        this.transactionCounter++;
        if(this.transactionCounter > FREE_TRANSACTIONS) {
            super.withdraw(0.02);
        }
    }

    public String toString() {
        return ("Checking " + super.toString() + ", and done transactions of " + this.transactionCounter);
    }
}