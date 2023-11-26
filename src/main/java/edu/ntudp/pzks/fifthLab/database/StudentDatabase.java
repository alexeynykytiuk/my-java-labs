package edu.ntudp.pzks.fifthLab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDatabase {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/students";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
