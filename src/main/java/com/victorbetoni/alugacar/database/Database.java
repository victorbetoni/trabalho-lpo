package com.victorbetoni.alugacar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private static final String CONNECTION_STR = "jdbc:mysql://localhost:3311/alugacar";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STR, "root", "root");
    }
}
