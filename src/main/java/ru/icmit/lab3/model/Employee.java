package ru.icmit.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Employee extends Person {
    public Employee(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Employee() {
    }
    private List<ShopAccount> accounts;

    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
    public List<ShopAccount> getShopAccounts() {
        return accounts;
    }

    public void setShopAccounts(List<ShopAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Employee: " + getLastName() +
                ", accounts=" + accounts +
                '\n';
    }
}
