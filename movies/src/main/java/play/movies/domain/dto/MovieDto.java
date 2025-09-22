package play.movies.domain.dto;

import java.time.LocalDate;

import play.movies.domain.Genre;

public record MovieDto(
    Long id,
    String title,
    Integer duration,
    Genre genre,
    Boolean state,
    LocalDate releaseDate,
    Double rating
) {

}
