package org.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String user = "root";
    private static final String password = "Rufan2006JavaMavenSQL";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);

    }
}
