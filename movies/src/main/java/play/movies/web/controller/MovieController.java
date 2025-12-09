package play.movies.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import play.movies.domain.dto.MovieDto;
import play.movies.domain.service.MovieService;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> getAllMovies(){
        return this.movieService.getAllMovies();
    }

}
