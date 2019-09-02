package app.services;

import app.dbcp.ConnectionManager;
import app.models.Session;
import app.transaction.TransactionManager;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.*;

public class SessionServiceTest {
    private ConnectionManager connectionManager;
    private TransactionManager transactionManager;
    private SessionService sessionService;
    private static final int TEST_ID = 1;

    @Before
    public void setUp() {
        connectionManager = new ConnectionManager();
        transactionManager = new TransactionManager(connectionManager);
        sessionService = new SessionService(transactionManager);
    }

    @Test
    public void shouldReturnSessionById() {
        assertThat(sessionService.get(TEST_ID), instanceOf(Session.class));
    }
}
