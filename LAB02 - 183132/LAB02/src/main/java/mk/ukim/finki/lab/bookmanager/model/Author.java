package mk.ukim.finki.lab.bookmanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

//    @OneToMany(mappedBy = "author")
//    private List<Book> books;

    public Author() {}

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

}
