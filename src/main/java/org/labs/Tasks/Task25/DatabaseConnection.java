package org.labs.Tasks.Task25;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;
    private static final String url;
    private static final String user;
    private static final String password;

    static {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application1.properties")) {
            prop.load(input);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Не удалось загрузить конфигурацию базы данных.");
        }
    }

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("PostgreSQL JDBC Driver не найден.", e);
            }
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}


