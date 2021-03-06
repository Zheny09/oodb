package ru.icmit.lab5.model;

class ShopAccount {

    public static long currentAccountNumber = 1000000000000000L;

    private long accountNumber;

    private double balance;

    ShopAccount(long accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    long getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
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
}