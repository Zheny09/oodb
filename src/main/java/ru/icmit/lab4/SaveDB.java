package ru.icmit.lab4;


import com.google.gson.Gson;
import ru.icmit.lab4.domain.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveDB {

    public static void savePersonList(List<Person> persons, Connection connection) throws SQLException {

        if (persons != null && persons.size() > 0) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(persons);

            long time1 = System.currentTimeMillis();
            PreparedStatement statement = connection.
                    prepareStatement("insert into person (content, c) values ( cast( ? as json), cast( ? as json) )");

            statement.setString(1, personsAsJson);
            statement.setString(2, personsAsJson);

            int count = statement.executeUpdate();

            long time2 = System.currentTimeMillis();
            System.out.println(count+ " records added!");

            System.out.println(time2-time1);
            statement.close();

        }
    }
}