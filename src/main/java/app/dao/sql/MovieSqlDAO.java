package app.dao.sql;

import app.dao.MovieDAO;
import app.dao.mappers.Mapper;
import app.dao.mappers.MovieMapper;
import app.dao.sql.query.MovieQuery;
import app.models.Movie;
import app.transaction.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieSqlDAO implements MovieDAO {
    private TransactionManager transactionManager;
    private Mapper<Movie> movieMapper = new MovieMapper();

    public MovieSqlDAO(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(MovieQuery.SQL_GET_MOVIE);
            preparedStatement.setInt(1, movieId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movie = movieMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> getAllActiveMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(MovieQuery.SQL_GET_ALL_ACTIVE_MOVIES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies.add(movieMapper.getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public void create() {

    }
}
