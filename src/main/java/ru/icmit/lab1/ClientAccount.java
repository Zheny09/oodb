package ru.icmit.lab1;

public class ClientAccount {
    private long accountNumber;

    private double balance;

    public ClientAccount(long accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public ClientAccount() {
    }

    long getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected void increaseBalance(double cash) {
        this.balance += cash;
    }

    protected boolean reduceBalance(double cash) {
        if (balance < cash) {
            return false;
        } else {
            this.balance -= cash;
            return true;
        }
    }

    @Override
    public String toString() {
        return "ClientAccount:" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '\n';
    }
}
