package play.movies.web.exception;

public record Error(
    String type,
    String message
) {

}
