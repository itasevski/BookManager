package mk.ukim.finki.lab.bookmanager.web.rest;

import mk.ukim.finki.lab.bookmanager.model.Author;
import mk.ukim.finki.lab.bookmanager.model.Country;
import mk.ukim.finki.lab.bookmanager.model.dtos.AuthorDto;
import mk.ukim.finki.lab.bookmanager.model.dtos.CountryDto;
import mk.ukim.finki.lab.bookmanager.service.AuthorService;
import mk.ukim.finki.lab.bookmanager.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Country> saveAuthor(@RequestBody CountryDto countryDto) {
        return this.countryService.saveCountry(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
