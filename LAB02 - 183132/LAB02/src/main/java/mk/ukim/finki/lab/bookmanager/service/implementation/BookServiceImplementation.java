package mk.ukim.finki.lab.bookmanager.service.implementation;

import mk.ukim.finki.lab.bookmanager.model.Author;
import mk.ukim.finki.lab.bookmanager.model.Book;
import mk.ukim.finki.lab.bookmanager.model.dtos.BookDto;
import mk.ukim.finki.lab.bookmanager.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab.bookmanager.model.exceptions.BookNotFoundException;
import mk.ukim.finki.lab.bookmanager.repository.AuthorRepository;
import mk.ukim.finki.lab.bookmanager.repository.BookRepository;
import mk.ukim.finki.lab.bookmanager.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll().stream()
                .sorted(Book.byNameComparator)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> getById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> saveBook(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(AuthorNotFoundException::new);

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        if(book.getAvailableCopies() < 0) book.setAvailableCopies(0);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(AuthorNotFoundException::new);

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);

        if(bookDto.getAvailableCopies() < 0) book.setAvailableCopies(0);
        else book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        this.bookRepository.deleteById(id);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> decrementAvailableCopies(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        if(book.getAvailableCopies() == 0) return Optional.of(book);
        else book.setAvailableCopies(book.getAvailableCopies() - 1);

        return Optional.of(this.bookRepository.save(book));
    }
}
