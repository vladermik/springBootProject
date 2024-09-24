package com.example.springbootproject;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;


@Setter
@Entity
public class Book {
    private long id;
    @Getter
    private String title;
    @Getter
    private String publisher;
    @Getter
    private String issueDate;
    @Getter
    private String student;
    @Getter
    private String returnDate;

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
