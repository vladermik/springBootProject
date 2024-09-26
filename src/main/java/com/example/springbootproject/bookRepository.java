package com.example.springbootproject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

public interface bookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT p FROM Book p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(p.publisher) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "(CAST(p.issueDate AS string) = ?1) OR " +
            "LOWER(p.student) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "(CAST(p.returnDate AS string) = ?1)")
    List<Book> search(String keyword, Sort sort);
}