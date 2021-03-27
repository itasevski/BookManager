package mk.ukim.finki.lab.bookmanager.model.dtos;

import lombok.Data;

@Data
public class CountryDto {

    private String name;

    private String continent;

    public CountryDto() {}

    public CountryDto(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
