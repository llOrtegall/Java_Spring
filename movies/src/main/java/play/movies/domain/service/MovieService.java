package play.movies.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import play.movies.domain.dto.MovieDto;
import play.movies.domain.dto.UpdateMovieDto;
import play.movies.domain.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return this.movieRepository.getById(id);
    }

    public MovieDto addNewMovie(MovieDto movieDto){
        return this.movieRepository.save(movieDto);
    }

    public MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void deleteMovie(long id){
        this.movieRepository.delete(id);
    }
}
