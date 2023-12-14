package org.example.jpa;
import jakarta.persistence.*;
@Entity
@Table(name = "test")
public class BookJPA {
    public BookJPA(){
    }
    public BookJPA( String name, String author) {
        this.name=name;
        this.author=author;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ": name='" + name + '\'' +
                ": author='" + author + "\n";
    }
}
