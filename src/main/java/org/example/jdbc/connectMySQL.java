package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectMySQL {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testjava";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    public Connection JDBCConnect(){
        System.out.println("Тестирование подключения к MySQL JDBC");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер MySQL JDBC не найден. Укажите путь к вашей библиотеке");
            e.printStackTrace();
            return null;
        }
        System.out.println("Драйвер MySQL JDBC успешно подключен");
        try {
           return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Сбой подключения");
            e.printStackTrace();
            return null;
        }
    }
}
