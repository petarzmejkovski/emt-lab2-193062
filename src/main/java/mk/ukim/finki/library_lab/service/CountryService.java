package mk.ukim.finki.library_lab.service;

import mk.ukim.finki.library_lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long countryId);

    Optional<Country> save(Country country);
}
