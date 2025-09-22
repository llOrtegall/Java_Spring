package play.movies.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import play.movies.domain.dto.MovieDto;
import play.movies.domain.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAllMovies(){
        return this.movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieDto getById(@PathVariable long id){
        return this.movieService.getById(id);
    }

}
