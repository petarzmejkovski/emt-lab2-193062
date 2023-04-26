package mk.ukim.finki.library_lab.service.impl;

import mk.ukim.finki.library_lab.model.Author;
import mk.ukim.finki.library_lab.model.Book;
import mk.ukim.finki.library_lab.model.dto.BookDto;
import mk.ukim.finki.library_lab.model.enumerations.Category;
import mk.ukim.finki.library_lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.library_lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.library_lab.repository.AuthorRepository;
import mk.ukim.finki.library_lab.repository.BookRepository;
import mk.ukim.finki.library_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {

        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long bookId) {

        return Optional.of(this.bookRepository.findById(bookId))
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {

        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name, category, author, availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies) {

        Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long bookId, BookDto bookDto) {

        Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));

        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));

    }

    @Override
    public void deleteById(Long bookId) {

        this.bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);

        return Optional.of(bookRepository.save(book));
    }
}
