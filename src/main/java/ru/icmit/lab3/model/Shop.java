package ru.icmit.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "shop")
public class Shop {

    private String name;

    private List<Employee> employees;

    private List<Client> clients;

    private List<Payment> transactions;

    private List<ShopAccount> shopAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    public List<Payment> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Payment> transactions) {
        this.transactions = transactions;
    }

    @XmlElementWrapper(name = "shopAccounts")
    @XmlElement(name = "shopAccount")
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
                ", employees=" + employees +'\n' +
                ", clients=" + clients + '\n' +
                ", shopAccounts=" + shopAccounts;
    }
}
