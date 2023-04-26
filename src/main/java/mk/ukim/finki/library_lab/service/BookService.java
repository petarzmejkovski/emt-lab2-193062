package mk.ukim.finki.library_lab.service;

import mk.ukim.finki.library_lab.model.Book;
import mk.ukim.finki.library_lab.model.dto.BookDto;
import mk.ukim.finki.library_lab.model.enumerations.Category;


import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long bookId);

    Optional<Book> save(String name, Category category, Long  authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies);

    public Optional<Book> edit(Long bookId, BookDto bookDto);

    void deleteById(Long bookId);

    Optional<Book> markAsTaken(Long id);
}
