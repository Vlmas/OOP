package lab.second.accounts;

public class SavingsAccount extends Account {
    private float interest;

    public SavingsAccount() {}

    public SavingsAccount(int accNumber, float interest) {
        super(accNumber);
        this.interest = interest;
    }

    public void addInterest() {
        this.deposit(interest * this.getBalance());
    }

    public String toString() {
        return ("Savings" + super.toString() + ", and interest rate of " + this.interest);
    }
}