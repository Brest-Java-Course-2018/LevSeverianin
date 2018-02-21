package com.epam.brest.cource;

import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsTest {

    @org.junit.Test
    public void getConnection() throws SQLException, ClassNotFoundException {
        DBUtils dbUtils = new DBUtils();
        Assert.assertNotNull(dbUtils.getConnection());
    }

    @Test
    public void addUser() throws SQLException, ClassNotFoundException {

        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);

        Assert.assertNotEquals(0, dbUtils.addUser(connection,
                "login", "password", "description"));

        connection.close();
    }

}