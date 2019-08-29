package app.dao.mappers;

import app.dao.sql.query.TicketQuery;
import app.models.Session;
import app.models.Ticket;
import app.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements Mapper<Ticket> {
    private Mapper<Session> sessionMapper = new SessionMapper();
    private Mapper<User> userMapper = new UserMapper();

    @Override
    public Ticket getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;

        }
        return new Ticket(resultSet.getInt(TicketQuery.ID),
                userMapper.getEntity(resultSet),
                sessionMapper.getEntity(resultSet),
                resultSet.getInt(TicketQuery.NUMBER_OF_ROW),
                resultSet.getInt(TicketQuery.PLACE),
                resultSet.getInt(TicketQuery.PRICE));
    }
}
