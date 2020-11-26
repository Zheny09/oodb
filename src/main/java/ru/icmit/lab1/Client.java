package ru.icmit.lab1;

import java.util.List;

public class Client extends Person {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<ClientAccount> clientAccounts;

    public List<ClientAccount> getClientAccounts() {
        return clientAccounts;
    }

    public void setClientAccounts(List<ClientAccount> clientAccounts) {
        this.clientAccounts = clientAccounts;
    }

    @Override
    public String toString() {
        return "Client: " + getLastName() +
                ", clientAccounts=" + clientAccounts +
                '\n';
    }
}