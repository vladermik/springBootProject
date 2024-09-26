package com.example.springbootproject;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class bookService {
    @Autowired
    private bookRepository repo;

    // Метод с одним параметром (keyword)
    public List<Book> listAll(String keyword) {
        return listAll(keyword, null, null);
    }

    // Метод с двумя параметрами (keyword, sortField)
    public List<Book> listAll(String keyword, String sortField) {
        return listAll(keyword, sortField, null);
    }

    // Метод с тремя параметрами (keyword, sortField, sortOrder)
    public List<Book> listAll(String keyword, String sortField, String sortOrder) {
        keyword = (keyword == null) ? "" : keyword;
        sortField = (sortField == null || sortField.isEmpty()) ? "id" : sortField;
        sortOrder = (sortOrder == null || sortOrder.isEmpty()) ? "asc" : sortOrder;
        Sort.Direction direction = Sort.Direction.ASC;
        if ("desc".equalsIgnoreCase(sortOrder)) {
            direction = Sort.Direction.DESC;
        }
        Sort sort = Sort.by(direction, sortField);
        return repo.search(keyword, sort);
    }

    public void save(Book book) {
        repo.save(book);
    }

    public Book get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
