package app.dao.sql;

import app.dao.TicketDAO;
import app.dao.mappers.Mapper;
import app.dao.mappers.TicketMapper;
import app.dao.sql.query.TicketQuery;
import app.dto.TicketDTO;
import app.models.Ticket;
import app.transaction.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketSqlDAO implements TicketDAO {
    private TransactionManager transactionManager;
    private Mapper<Ticket> ticketMapper = new TicketMapper();

    public TicketSqlDAO(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Ticket getTicketById(int id) {
        Ticket ticket = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(TicketQuery.GET_TICKET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticket = ticketMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getTicketBySessionId(int sessionId) {
        List<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(TicketQuery.GET_TICKETS_BY_SESSION_ID);
            preparedStatement.setInt(1, sessionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(ticketMapper.getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public List<Ticket> getTicketByUserName(String userName) {
        List<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(TicketQuery.GET_TICKETS_BY_USER_ID);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(ticketMapper.getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket checkPlace(int sessionId, int rowNumber, int place) {
        Ticket ticket = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = transactionManager.getConnection().prepareStatement(TicketQuery.CHECK_PLACE);
            preparedStatement.setInt(1, sessionId);
            preparedStatement.setInt(2, rowNumber);
            preparedStatement.setInt(3, place);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ticket = ticketMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void create(TicketDTO ticketDTO) {
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(TicketQuery.BUY_TICKET);
            preparedStatement.setInt(1, ticketDTO.getUserId());
            preparedStatement.setInt(2, ticketDTO.getSessionId());
            preparedStatement.setInt(3, ticketDTO.getRowNumber());
            preparedStatement.setInt(4, ticketDTO.getPlaceNumber());
            preparedStatement.setInt(5, ticketDTO.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
