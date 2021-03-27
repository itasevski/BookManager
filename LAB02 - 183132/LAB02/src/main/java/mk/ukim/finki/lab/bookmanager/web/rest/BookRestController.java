package mk.ukim.finki.lab.bookmanager.web.rest;

import mk.ukim.finki.lab.bookmanager.model.Book;
import mk.ukim.finki.lab.bookmanager.model.dtos.BookDto;
import mk.ukim.finki.lab.bookmanager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/restapi/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return this.bookService.getById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto) {
        return this.bookService.saveBook(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.editBook(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        return this.bookService.deleteBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/decrement/{id}")
    public ResponseEntity<Book> decrementAvailableCopies(@PathVariable Long id) {
        return this.bookService.decrementAvailableCopies(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
