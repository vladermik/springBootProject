package com.example.springbootproject;


import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.sql.Date;


@Setter
@Entity
public class Book {
    private long id;
    @Getter
    private String title;
    @Getter
    private String publisher;
    @Getter
    @Column(name = "issueDate") // Явное указание имени колонки
    private Date issueDate;
    @Getter
    private String student;
    @Getter
    @Column(name = "returnDate") // Явное указание имени колонки
    private Date returnDate;

    protected Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", issueDate=" + issueDate + ", student=" + student + ", returnDate=" + returnDate + "]";
    }
}
