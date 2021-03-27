package mk.ukim.finki.lab.bookmanager.service;

import mk.ukim.finki.lab.bookmanager.model.Country;
import mk.ukim.finki.lab.bookmanager.model.dtos.CountryDto;

import java.util.Optional;

public interface CountryService {

    Optional<Country> saveCountry(CountryDto countryDto);

}
