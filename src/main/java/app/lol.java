package app;

import app.dbcp.ConnectionManager;
import app.dto.TicketDTO;
import app.services.TicketService;
import app.transaction.TransactionManager;
import app.utils.DefaultValues;


public class lol {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        TransactionManager transactionManager = new TransactionManager(connectionManager);
        TicketService ticketService = new TicketService(transactionManager);

        TicketDTO ticketDTO = new TicketDTO(4,1,"3/3", DefaultValues.DEFAULT_TICKET_PRICE);
       ticketService.buyTicket(ticketDTO);
    }
}
