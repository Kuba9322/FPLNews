package pl.sturnusdev.fantasypremierleaguenews.tools;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToString {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }
    public static LocalDateTime stringToLocalDateTime(String stringDate) {
        return LocalDateTime.parse(stringDate, formatter);
    }
}
