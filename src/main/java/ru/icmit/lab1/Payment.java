package ru.icmit.lab1;


import java.util.Date;

public class Payment {

    private ShopAccount shopAccount;

    private ClientAccount clientAccount;

    private Date transactionDate;


    private Client client;

    private double amount;

    public Payment(ShopAccount shopAccount, ClientAccount clientAccount, Employee employee, Client client, double amount) {
        this.shopAccount = shopAccount;
        this.clientAccount = clientAccount;
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
        clientAccount.increaseBalance(amount);
    }

    private void reduceBalance(double amount) {
        clientAccount.reduceBalance(amount);
        shopAccount.reduceBalance(amount);
    }

    public ShopAccount getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(ShopAccount shopAccount) {
        this.shopAccount = shopAccount;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
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
