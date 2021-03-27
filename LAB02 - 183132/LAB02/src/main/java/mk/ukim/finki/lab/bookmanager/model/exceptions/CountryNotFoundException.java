package mk.ukim.finki.lab.bookmanager.model.exceptions;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("Country not found");
    }

}
