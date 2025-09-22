package play.movies.domain.repository;

import java.util.List;

import play.movies.domain.dto.MovieDto;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
}
