package com.epam.brest.cource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        String URL = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Connection connection = DriverManager.getConnection(URL, "sa", "");


        return connection;
    }
}
