package app.services;

import app.dbcp.ConnectionManager;
import app.transaction.TransactionManager;
import app.utils.AttributesNames;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

public class TicketServiceTest {

    private TransactionManager transactionManager;
    private TicketService ticketService;
    private ConnectionManager connectionManager;

    public void setUp() {
        connectionManager = new ConnectionManager();
        transactionManager = new TransactionManager(connectionManager);
        ticketService = new TicketService(transactionManager);
    }

    @Test
    public void checkTicketTest() {
        assertEquals(ticketService.checkTicket(1, 1, 4), AttributesNames.RESERVED_PLACE);
    }
}
