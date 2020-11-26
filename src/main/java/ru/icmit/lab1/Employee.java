package ru.icmit.lab1;

import java.util.List;

public class Employee extends Person {
    public Employee(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Employee() {
    }
    private List<ShopAccount> accounts;

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
