package mk.ukim.finki.lab.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BookManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManagerApplication.class, args);
    }

}
