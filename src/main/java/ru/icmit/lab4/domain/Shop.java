package ru.icmit.lab4.domain;

import ru.icmit.lab2.domain.Client;
import ru.icmit.lab2.domain.Employee;
import ru.icmit.lab2.domain.Payment;

import java.util.List;

public class Shop {

    private String name;

    public static List<Employee> employees;

    public static List<Client> clients;

    public static List<Payment> payments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}