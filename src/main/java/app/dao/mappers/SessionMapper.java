package app.dao.mappers;

import app.dao.sql.query.SessionQuery;
import app.models.Hall;
import app.models.Movie;
import app.models.Session;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionMapper implements Mapper<Session> {
    private Mapper<Hall> hallMapper = new HallMapper();
    private Mapper<Movie> movieMapper = new MovieMapper();

    @Override
    public Session getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new Session(resultSet.getInt(SessionQuery.ID),
                resultSet.getDate(SessionQuery.SHOW_DATE),
                resultSet.getTime(SessionQuery.SHOW_TIME),
                hallMapper.getEntity(resultSet),
                movieMapper.getEntity(resultSet));
    }
}
