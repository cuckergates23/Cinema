package app.services;

import app.dao.TicketDAO;
import app.dao.sql.TicketSqlDAO;
import app.dto.TicketDTO;
import app.models.Ticket;
import app.transaction.TransactionManager;
import app.utils.AttributesNames;

import java.sql.SQLException;
import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;
    private TransactionManager transactionManager;

    public TicketService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.ticketDAO = new TicketSqlDAO(transactionManager);
    }

    public Ticket get(int userId) {
        try {
            transactionManager.getConnection();
            return ticketDAO.getTicketById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public List<Ticket> getBySessionId(int sessionId) {
        try {
            transactionManager.getConnection();
            return ticketDAO.getTicketBySessionId(sessionId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public List<Ticket> getByUserName(String userName) {
        try {
            transactionManager.getConnection();
            return ticketDAO.getTicketByUserName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public String checkTicket(int sessionId, int rowNumber, int place) {
        String check = AttributesNames.RESERVED_PLACE;
        try {
            transactionManager.getConnection();
            if (ticketDAO.checkPlace(sessionId, rowNumber, place) == null) {
                check = AttributesNames.FREE_PLACE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
        return check;
    }

    public void buyTicket(TicketDTO ticketDTO) {
        try {
            transactionManager.getConnection();
            ticketDAO.create(ticketDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            transactionManager.stopConnection();
        }
    }
}
