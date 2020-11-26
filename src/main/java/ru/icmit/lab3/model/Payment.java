package ru.icmit.lab3.model;


import java.util.Date;

public class Payment {

    private ShopAccount shopAccount;

    private Date transactionDate;

    private Client client;

    private double amount;

    public Payment(ShopAccount shopAccount, Client client, double amount) {
        this.shopAccount = shopAccount;
        this.transactionDate = new Date();
        this.client = client;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
    }

    public Payment() {
    }

    private void increaseBalance(double amount) {
        shopAccount.increaseBalance(amount);
    }

    private boolean reduceBalance(double amount) {
        return shopAccount.reduceBalance(amount);
    }

    public ShopAccount getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(ShopAccount shopAccount) {
        this.shopAccount = shopAccount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
