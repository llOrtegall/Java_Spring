package play.movies.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String movieTitle){
        super("La Pelicula " + movieTitle + " ya existe.");
    }
}
