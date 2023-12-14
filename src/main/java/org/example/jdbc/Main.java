package org.example.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        connectMySQL dataBase = new connectMySQL();
        Connection connection= dataBase.JDBCConnect();
        Book bookDB= new Book();
      //  bookDB.delTable(connection);
       // bookDB.prepareTables(connection);
      //  bookDB.insertData(connection);
       bookDB.executeUpdate(connection);
       connection.close();
    }
}