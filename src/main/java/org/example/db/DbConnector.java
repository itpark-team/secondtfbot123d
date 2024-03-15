package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
    private Connection connection = null;

    private DbConnector() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://83.147.246.87:5432/jokes_123ddb_smyslov",
                            "jokes_123duser_smyslov", "12345");
        } catch (Exception e) {
            System.out.println("Ошибка соединения с базой данных");
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static DbConnector instance = null;

    public static DbConnector getInstance() {
        if (instance == null) {
            instance = new DbConnector();
        }
        return instance;
    }


}
