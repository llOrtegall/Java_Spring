package play.movies.persistence.mapper;

import org.mapstruct.Named;

import play.movies.domain.Genre;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String g){
        if(g == null) return null;

        return switch (g.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "COMEDY" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATED;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            case "DOCUMENTARY" -> Genre.DOCUMENTARY;
            case "THRILLER" -> Genre.THRILLER;
            case "ROMANCE" -> Genre.ROMANCE;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre g){
        if(g == null) return null;

        return switch (g) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDY";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
            case DOCUMENTARY -> "DOCUMENTARY";
            case THRILLER -> "THRILLER";
            case ROMANCE -> "ROMANCE";
        };
    }
}
