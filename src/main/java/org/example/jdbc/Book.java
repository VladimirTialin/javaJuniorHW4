package org.example.jdbc;

import java.sql.*;

public class Book {
    public void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table book (
                      id bigint,
                      name varchar(255),
                      author varchar(255)
                    )
                    """);
        }
    }
    public  void insertData (Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            int updatedRows = statement.executeUpdate("""
                        insert into book(id, name,author) 
                        values(1, 'Властелин колец' ,'Джон Р. Р. Толкин'),
                              (2, 'Гордость и предубеждение' ,'Джейн Остин'),
                              (3, 'Тёмные начала' ,'Филип Пулман'),
                              (4, 'Автостопом по галактике' ,'Дуглас Адамс'),
                              (5, 'Гарри Поттер и Кубок огня' ,'Джоан Роулинг'),
                              (6, 'Убить пересмешника' ,'Харпер Ли'),
                              (7, 'Перед потопом' ,'Алан Александр Милн'),
                              (8, 'Река' ,'Алан Александр Милн'),
                              (9, 'Лев, колдунья и платяной шкаф' ,'Клайв Стэйплз Льюис'),
                              (10, 'Джейн Эйр' ,'Шарлотта Бронте')""");
            System.out.printf("Создано %s записей",updatedRows);
        }
    }
    public   void executeUpdate(Connection connection) throws SQLException {
        String query = "select * from book where author ='Алан Александр Милн'";
        try (Statement statement = connection.createStatement()) {
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            System.out.printf("id: %d, name: %s, author: %s %n", id, name, author);
        }
        }
    }
    public void delTable(Connection connection) throws SQLException {
        String query = "DROP TABLE book";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Таблица удалена");
    }catch (SQLSyntaxErrorException e){
            System.out.println("Таблицы не существует");
        }
    }
}

