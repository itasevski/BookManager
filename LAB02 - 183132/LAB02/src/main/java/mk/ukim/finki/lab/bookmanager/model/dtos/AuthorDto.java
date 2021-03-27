package mk.ukim.finki.lab.bookmanager.model.dtos;

import lombok.Data;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Long countryId;

    public AuthorDto() {}

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

}
