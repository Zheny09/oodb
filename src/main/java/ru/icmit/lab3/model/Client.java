package ru.icmit.lab3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Client extends Person {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<ClientAccount> accounts;


    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
    public List<ClientAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ClientAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client: " + getLastName() +
                ", accounts=" + accounts +
                '\n';
    }
}
