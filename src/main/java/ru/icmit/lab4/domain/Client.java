package ru.icmit.lab4.domain;

import java.util.List;

public class Client extends Person {

    private List<ClientAccount> clientAccounts;

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public long createBankAccount() {
        long newAccountNumber = ClientAccount.currentAccountNumber++;

        clientAccounts.add(new ClientAccount(newAccountNumber));

        return newAccountNumber;
    }

    private ClientAccount findBankAccount(long accountNumber) {
        for (ClientAccount bankAccount : clientAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                return bankAccount;
            }
        }

        return null;
    }
}