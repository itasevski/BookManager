package mk.ukim.finki.lab.bookmanager.web.rest;

import mk.ukim.finki.lab.bookmanager.model.Author;
import mk.ukim.finki.lab.bookmanager.model.dtos.AuthorDto;
import mk.ukim.finki.lab.bookmanager.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/restapi/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.authorService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> saveAuthor(@RequestBody AuthorDto authorDto) {
        return this.authorService.saveAuthor(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
