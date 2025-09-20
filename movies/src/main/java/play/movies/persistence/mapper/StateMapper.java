package play.movies.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean stringToBoolean (String s){
        if (s == null) return null;

        return switch (s) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }


    @Named("booleanToString")
    public static String booleanToString(Boolean state) {
        return state == null ? null : (state ? "D" : "N");
    }
}
