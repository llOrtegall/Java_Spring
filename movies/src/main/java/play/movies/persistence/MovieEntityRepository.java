package play.movies.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import play.movies.domain.dto.MovieDto;
import play.movies.domain.repository.MovieRepository;
import play.movies.persistence.crud.CrudMovieEntity;
import play.movies.persistence.entity.MovieEntity;
import play.movies.persistence.mapper.MovieMapper;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper){
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

}
