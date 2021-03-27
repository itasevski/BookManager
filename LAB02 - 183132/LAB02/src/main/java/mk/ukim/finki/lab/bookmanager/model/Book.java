package mk.ukim.finki.lab.bookmanager.model;

import lombok.Data;
import mk.ukim.finki.lab.bookmanager.model.enumerations.EnumCategory;

import javax.persistence.*;
import java.util.Comparator;

@Data
@Entity
public class Book {

    @Transient
    public static final Comparator<Book> byNameComparator = Comparator.comparing(Book::getName);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private EnumCategory category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {}

    public Book(String name, EnumCategory category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

}
