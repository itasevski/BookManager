package mk.ukim.finki.lab.bookmanager.service.implementation;

import mk.ukim.finki.lab.bookmanager.model.Country;
import mk.ukim.finki.lab.bookmanager.model.dtos.CountryDto;
import mk.ukim.finki.lab.bookmanager.repository.CountryRepository;
import mk.ukim.finki.lab.bookmanager.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> saveCountry(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(), countryDto.getContinent());

        this.countryRepository.save(country);

        return Optional.of(country);
    }

}
