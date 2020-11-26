package ru.icmit.lab1;


import java.util.List;

public class Shop {

    private String name;

    private List<Employee> employee;

    private List<Client> clients;

    private List<Payment> transactions;

    private List<ShopAccount> shopAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Payment> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Payment> transactions) {
        this.transactions = transactions;
    }

    public List<ShopAccount> getShopAccounts() {
        return shopAccounts;
    }

    public void setShopAccounts(List<ShopAccount> shopAccounts) {
        this.shopAccounts = shopAccounts;
    }

    @Override
    public String toString() {
        return "Service: " +
                "name='" + name + '\n' +
                ", employees=" + employee +'\n' +
                ", clients=" + clients + '\n' +
                ", shopAccounts=" + shopAccounts;
    }
}
