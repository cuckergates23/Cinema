package app.dao.sql.query;

public class SessionQuery {
    public static final String TABLE_NAME = "sessions";

    public static final String ID = "id";
    public static final String SHOW_DATE = "show_date";
    public static final String SHOW_TIME = "show_time";
    public static final String HALL_NAME = "hall_name";
    public static final String MOVIE_NAME = "movie_name";

    public static final String GET_SESSION_BY_ID = "Select sessions.id, sessions.show_date,sessions.show_time, " +
            "halls.id,halls.rows_amount,halls.places_in_row,halls.hall_name, " +
            "movies.id,movies.movie_name,genres.genre,movies.duration,movies.movie_description " +
            "From " + TABLE_NAME + " Join halls ON sessions.hall_id=halls.id " +
            "Join movies ON sessions.movie_id=movies.id Join genres ON movies.genre_id=genres.id where sessions.id=(?)";

    public static final String GET_SESSION_BY_MOVIE_ID = "Select sessions.id, sessions.show_date,sessions.show_time, " +
            "halls.id,halls.rows_amount,halls.places_in_row,halls.hall_name, " +
            "movies.id,movies.movie_name,genres.genre,movies.duration,movies.movie_description " +
            "From " + TABLE_NAME + " Join halls ON sessions.hall_id=halls.id " +
            "Join movies ON sessions.movie_id=movies.id Join genres ON movies.genre_id=genres.id where movies.id=(?)";
}
