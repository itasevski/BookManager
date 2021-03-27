package mk.ukim.finki.lab.bookmanager.model.dtos;

import lombok.Data;
import mk.ukim.finki.lab.bookmanager.model.enumerations.EnumCategory;

@Data
public class BookDto {

    private String name;

    private EnumCategory category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto() {}

    public BookDto(String name, EnumCategory category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

}
