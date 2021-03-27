package mk.ukim.finki.lab.bookmanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
//    private List<Author> authors;

    public Country() {}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
