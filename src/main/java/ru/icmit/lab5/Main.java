package ru.icmit.lab5;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/oodb";
            connection = DriverManager.getConnection(dbURL, "postgres", "post");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        assert connection != null;
        addMarket(connection);
        showData(connection);
        editData(connection);
        System.out.println("\n============ Data changed ============\n");
        showData(connection);
    }

//    public static void addData(Connection connection) {
//        addFlight(connection);
//    }

    private static void addMarket(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO market (number, shop.nameShop, shop.typeShop, shop.information) VALUES (?,?,?,?)" );

            statement.setString(1, "1");
            statement.setString(2, "Пятерочка");
            statement.setString(3, "Продовольственный");
            statement.setString(4, "Не круглосуточный");
            statement.executeUpdate();

            statement.setString(1, "2");
            statement.setString(2, "Магнит");
            statement.setString(3, "Продовольственный");
            statement.setString(4, "Не круглосуточный");
            statement.executeUpdate();

            statement.setString(1, "3");
            statement.setString(2, "Лента");
            statement.setString(3, "Гипермаркет");
            statement.setString(4, "Круглосуточный");
            statement.executeUpdate();

            statement.setString(1, "4");
            statement.setString(2, "Ашан");
            statement.setString(3, "Гипермаркет");
            statement.setString(4, "Не круглосуточный");
            statement.executeUpdate();

            statement.setString(1, "5");
            statement.setString(2, "Августина");
            statement.setString(3, "Продуктовый");
            statement.setString(4, "Круглосуточный");
            statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showData(Connection connection) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(
                    "SELECT (shop).nameShop, (shop).typeShop, (shop).information from market");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void editData(Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE market set shop.information = 'Круглосуточный' where (shop).nameShop like 'Ашан' ");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}