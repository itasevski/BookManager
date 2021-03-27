package mk.ukim.finki.lab.bookmanager.service;

import mk.ukim.finki.lab.bookmanager.model.Author;
import mk.ukim.finki.lab.bookmanager.model.dtos.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAll();

    Optional<Author> saveAuthor(AuthorDto authorDto);

}
