package mk.ukim.finki.lab.bookmanager.model.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book not found");
    }

}
