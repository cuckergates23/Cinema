package app.services;

import app.dbcp.ConnectionManager;
import app.models.Hall;
import app.transaction.TransactionManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class HallServiceTest {
    private ConnectionManager connectionManager;
    private TransactionManager transactionManager;
    private HallService hallService;

    @Before
    public void setUp(){
        connectionManager = new ConnectionManager();
        transactionManager = new TransactionManager(connectionManager);
        hallService = new HallService(transactionManager);
    }

    @Test
    public void shouldReturnMovieById(){
        assertThat(hallService.get(1),instanceOf(Hall.class));
    }
}
