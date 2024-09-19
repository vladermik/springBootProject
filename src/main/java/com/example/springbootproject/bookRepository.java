package com.example.springbootproject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT p FROM Book p WHERE CONCAT(p.title, ' ', p.publisher, ' ', p.issueDate, ' ', p.student, ' ', p.returnDate) LIKE %?1%")
    List<Book> search(String keyword);
}
