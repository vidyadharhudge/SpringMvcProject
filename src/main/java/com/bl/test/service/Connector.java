
package com.bl.test.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
    }
}
