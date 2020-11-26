package ru.icmit.lab4.domain;

import java.util.Date;

public class Payment {

    private ShopAccount shopAccount;

    private ClientAccount clientAccount;

    private Employee employee;

    private Date transactionDate;

    private Client client;

    private double amount;

    public Payment(ShopAccount shopAccount, ClientAccount clientAccount, Employee employee, Client client, double amount) {
        this.shopAccount = shopAccount;
        this.clientAccount = clientAccount;
        this.employee = employee;
        this.transactionDate = new Date();
        this.client = client;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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