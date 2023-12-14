package org.example.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class JPA {
    private SessionFactory connect() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void addBook(BookJPA book, String[] authors, String[] name) {
        final SessionFactory sessionFactory = connect();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            for (int i = 0; i < authors.length; i++) {
                book = new BookJPA(name[i], authors[i]);
                session.save(book);
            }
            session.getTransaction().commit();
            System.out.println("Close");
            sessionFactory.close();
        }
    }

    public void queryBook() {
        final SessionFactory sessionFactory = connect();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            List<BookJPA> books = session.createQuery("from BookJPA where author='Алан Александр Милн'", BookJPA.class)
                    .getResultList();
            System.out.println(books);
            sessionFactory.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
