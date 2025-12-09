package play.movies.domain.repository;

import java.util.List;

import play.movies.domain.dto.MovieDto;
import play.movies.domain.dto.UpdateMovieDto;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}
