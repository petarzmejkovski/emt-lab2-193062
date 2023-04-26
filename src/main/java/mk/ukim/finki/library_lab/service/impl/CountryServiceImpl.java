package mk.ukim.finki.library_lab.service.impl;

import mk.ukim.finki.library_lab.model.Country;
import mk.ukim.finki.library_lab.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.library_lab.repository.CountryRepository;
import mk.ukim.finki.library_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long countryId) {
        return Optional.of(this.countryRepository.findById(countryId))
                .orElseThrow(() -> new CountryNotFoundException(countryId));
    }

    @Override
    public Optional<Country> save(Country country) {

        return Optional.of(this.countryRepository.save(country));
    }
}
