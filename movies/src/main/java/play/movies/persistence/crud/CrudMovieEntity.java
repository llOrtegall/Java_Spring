package play.movies.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import play.movies.persistence.entity.MovieEntity;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirtsBytitulo(String titulo);
}
