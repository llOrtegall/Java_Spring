package play.movies.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import play.movies.persistence.crud.CrudMovieEntity;
import play.movies.persistence.entity.MovieEntity;

@RestController
public class MovieController {
    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getAllMovies(){
        return (List<MovieEntity>)this.crudMovieEntity.findAll();
    }

}
