package ru.icmit.lab4;


import ru.icmit.lab4.domain.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/oodb";
            Connection connection =
                    DriverManager.getConnection( dbURL, "postgres", "post");

//            LoadFromFile.loadPersonList();
//            LoadFromDB.load();
//            LoadFromDB.loadPersonList(connection);

            List<Person> persons = LoadFromDB.loadPersonList(connection);
            persons.forEach(System.out::println);

            List<Person> personsF = LoadFromFile.loadPersonList();
            personsF.forEach(System.out::println);
            SaveDB.savePersonList(personsF, connection);

//            Person prs = PersonService.findPersonByName(persons, "Иван");
//
//            if (prs != null) {
//                prs.setPhoneNumber("+71111111111");
//                prs.setEmail("ivan@mail.ru");
//            }
//
//
//            SaveDB.savePersonList(persons, connection);


            connection.close();

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}