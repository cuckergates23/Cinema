package app.services;

import app.dbcp.ConnectionManager;
import app.models.Movie;
import app.transaction.TransactionManager;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MovieServiceTest {
    private ConnectionManager connectionManager;
    private TransactionManager transactionManager;
    private MovieService movieService;

    @Before
    public void setUp(){
        connectionManager = new ConnectionManager();
        transactionManager = new TransactionManager(connectionManager);
        movieService = new MovieService(transactionManager);
    }

    @Test
    public void shouldReturnMovieById(){
        assertThat(movieService.get(1), instanceOf(Movie.class));
    }
}
