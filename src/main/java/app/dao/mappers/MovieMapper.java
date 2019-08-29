package app.dao.mappers;

import app.dao.sql.query.MovieQuery;
import app.models.Movie;
import app.models.enums.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements Mapper<Movie> {
    @Override
    public Movie getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Movie(resultSet.getInt(MovieQuery.ID),
                resultSet.getString(MovieQuery.MOVIE_NAME),
                Genre.valueOf(resultSet.getString(MovieQuery.MOVIE_GENRE).toUpperCase()),
                resultSet.getInt(MovieQuery.DURATION),
                resultSet.getString(MovieQuery.MOVIE_DESCRIPTION));
    }
}
