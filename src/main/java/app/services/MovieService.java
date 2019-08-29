package app.services;

import app.dao.MovieDAO;
import app.dao.sql.MovieSqlDAO;
import app.models.Movie;
import app.transaction.TransactionManager;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private MovieDAO movieDAO;
    private TransactionManager transactionManager;

    public MovieService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.movieDAO = new MovieSqlDAO(transactionManager);
    }

    public Movie get(int userId) {
        try {
            transactionManager.getConnection();
            return movieDAO.getMovieById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public List<Movie> getAllActiveMovies() {
        try {
            transactionManager.getConnection();
            return movieDAO.getAllActiveMovies();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }
}
