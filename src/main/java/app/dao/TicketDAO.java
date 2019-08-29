package app.dao;

import app.dto.TicketDTO;
import app.models.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket getTicketById(int id);

    void create(TicketDTO ticketDTO);

    List<Ticket> getTicketBySessionId(int sessionId);

    List<Ticket> getTicketByUserName(String userName);

    Ticket checkPlace(int sessionId,int rowNumber,int place);
}
