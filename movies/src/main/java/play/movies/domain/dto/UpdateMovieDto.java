package play.movies.domain.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record UpdateMovieDto(
    @NotBlank(message = "El titulo es obligatorio")
    String title,
    @PastOrPresent(message = "la fecha de lanzazmiento debe ser ant a la fecha actual")
    LocalDate releaseDate,
    @Min(value = 0, message = "El rating no puede ser menor a 0")
    @Max(value = 10, message = "el rating no puede ser mayor a 10")
    Double rating
) {

}
