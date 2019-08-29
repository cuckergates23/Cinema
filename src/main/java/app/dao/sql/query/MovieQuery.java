package app.dao.sql.query;

public class MovieQuery {
    public static final String TABLE_NAME = "movies";

    public static final String ID = "id";
    public static final String MOVIE_NAME = "movie_name";
    public static final String GENRE_ID = "genre_id";
    public static final String DURATION = "duration";
    public static final String MOVIE_DESCRIPTION = "movie_description";
    public static final String MOVIE_GENRE = "genre";

    public static final String SQL_GET_MOVIE = "Select movies.id,movies.movie_name,genres.genre,movies.duration,movies.movie_description" +
            " From movies Inner Join genres ON movies.id=genres.id Where movies.id =(?)";

    public static final String SQL_GET_ALL_ACTIVE_MOVIES = "Select movies.id,movies.movie_name,genres.genre,movies.duration,movies.movie_description" +
            " From movies Inner Join genres ON movies.id=genres.id Where movies.is_active='Yes'";


}
