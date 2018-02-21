package com.epam.brest.cource;

import java.sql.Connection;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        System.out.println( "Hello World!" );

        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "admin", "admin", "user admin");
        dbUtils.addUser(connection, "admin1", "admin1", "user admin1");
        dbUtils.addUser(connection, "admin2", "admin2", "user admin2");
        dbUtils.deleteUser(connection, "1");
        dbUtils.getUsers(connection);

    }
}
