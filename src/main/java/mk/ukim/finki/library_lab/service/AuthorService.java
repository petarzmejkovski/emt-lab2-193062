package mk.ukim.finki.library_lab.service;

import mk.ukim.finki.library_lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long authorId);

    Optional<Author> save(Author author);

    Optional<Author> edit(Long authorId, String name, String surname, Long countryId);

    void deleteById(Long authorId);
}