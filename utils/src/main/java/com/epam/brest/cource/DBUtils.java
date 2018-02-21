package com.epam.brest.cource;

import java.sql.*;

public class DBUtils {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        System.out.println("Connect to DB.");
        Class.forName("org.h2.Driver");
        String URL = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Connection connection = DriverManager.getConnection(URL, "sa", "");


        return connection;
    }

    public int createUserTable(Connection connection) throws SQLException {

        System.out.println("Create app_user table.");
        String createTable =
                "CREATE TABLE app_user (" +
                        "user_id INT NOT NULL AUTO_INCREMENT," +
                        "login VARCHAR(255) NOT NULL," +
                        "password VARCHAR(255) NOT NULL," +
                        "description VARCHAR(255) NULL," +
                        "PRIMARY KEY (user_id));";

        Statement statement = connection.createStatement();
        return statement.executeUpdate(createTable);
    }

    public int addUser(Connection connection, String login, String password, String description) throws SQLException {

        System.out.println(String.format("Added user: %s", login));

        String newUser = "INSERT INTO app_user (login, password, description) VALUES (?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(newUser);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, description);
        return preparedStatement.executeUpdate();
    }

    public void getUsers(Connection connection) throws SQLException {

        System.out.println("Get users.");

        String getRecords = "SELECT user_id AS id, login, description FROM app_user ORDER BY id";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRecords);

        while (resultSet.next()){
            System.out.println(String.format("User: %s, %s, %s", resultSet.getString("id"), resultSet.getString("login"), resultSet.getString("description")));
        }

    }

    public int deleteUser(Connection connection, String id) throws SQLException {

        System.out.println(String.format("Delete user with id: %s", id));

        String newUser = "DELETE FROM app_user WHERE user_id=?;";

        PreparedStatement preparedStatement = connection.prepareStatement(newUser);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }
}
