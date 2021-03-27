package mk.ukim.finki.lab.bookmanager.service;

import mk.ukim.finki.lab.bookmanager.model.Book;
import mk.ukim.finki.lab.bookmanager.model.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll();

    Optional<Book> getById(Long id);

    Optional<Book> saveBook(BookDto bookDto);

    Optional<Book> editBook(Long id, BookDto bookDto);

    Optional<Book> deleteBook(Long id);

    Optional<Book> decrementAvailableCopies(Long id);

}
