package mk.ukim.finki.lab.bookmanager.service.implementation;

import mk.ukim.finki.lab.bookmanager.model.Author;
import mk.ukim.finki.lab.bookmanager.model.Country;
import mk.ukim.finki.lab.bookmanager.model.dtos.AuthorDto;
import mk.ukim.finki.lab.bookmanager.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab.bookmanager.repository.AuthorRepository;
import mk.ukim.finki.lab.bookmanager.repository.CountryRepository;
import mk.ukim.finki.lab.bookmanager.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> getAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> saveAuthor(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(CountryNotFoundException::new);

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);

        this.authorRepository.save(author);

        return Optional.of(author);
    }

}
