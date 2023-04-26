package mk.ukim.finki.library_lab.model.config;

import mk.ukim.finki.library_lab.model.Author;
import mk.ukim.finki.library_lab.model.Country;
import mk.ukim.finki.library_lab.service.AuthorService;
import mk.ukim.finki.library_lab.service.BookService;
import mk.ukim.finki.library_lab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import static mk.ukim.finki.library_lab.model.enumerations.Category.*;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {

        Country country1 = new Country("Russia", "Europe");
        Country country2= new Country("Spain", "Europe");
        Country country3 = new Country("America", "North America");
        Country country4= new Country("United Kingdom", "Europe");
        Country country5 = new Country("Macedonia", "Europe");

        countryService.save(country1);
        countryService.save(country2);
        countryService.save(country3);
        countryService.save(country4);
        countryService.save(country5);

        Author author1 = new Author("Leo", "Tolstoy", country1);
        Author author2 = new Author("Gabriel", "García Márquez", country2);
        Author author3 = new Author("Toni", "Morrison", country3);
        Author author4 = new Author("Miguel", "Cervantes", country2);
        Author author5 = new Author("Fyodor", "Dostoevsky", country1);
        Author author6 = new Author("William", "Shakespeare", country3);
        Author author7 = new Author("Goran", "Stefanovski", country4);
        Author author8 = new Author("Vojdan", "Cernodrinski", country4);


        authorService.save(author1);
        authorService.save(author2);
        authorService.save(author3);
        authorService.save(author4);
        authorService.save(author5);
        authorService.save(author6);
        authorService.save(author7);
        authorService.save(author8);

        this.bookService.save("Makedonska krvava svadba", DRAMA, author8.getId(), 3);
        this.bookService.save("Romeo and Juliet", NOVEL, author6.getId(), 10);
        this.bookService.save("The Bluest Eye", THRILLER, author3.getId(), 1);
        this.bookService.save("Divo meso", DRAMA, author7.getId(), 5);
        this.bookService.save("Beloved", CLASSICS, author3.getId(), 2);
        this.bookService.save("One Hundred Years of Solitude", NOVEL, author2.getId(), 6);
        this.bookService.save("Don Quixote", CLASSICS, author4.getId(), 7);
        this.bookService.save("Crime and Punishment", DRAMA, author5.getId(), 9);
        this.bookService.save("Anna Karenina", NOVEL, author1.getId(), 4);


    }
}
