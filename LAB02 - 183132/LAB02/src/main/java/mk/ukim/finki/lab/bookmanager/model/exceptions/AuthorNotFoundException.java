package mk.ukim.finki.lab.bookmanager.model.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {
        super("Author not found");
    }

}
