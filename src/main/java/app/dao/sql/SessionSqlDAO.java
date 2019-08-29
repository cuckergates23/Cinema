package app.dao.sql;

import app.dao.SessionDAO;
import app.dao.mappers.Mapper;
import app.dao.mappers.SessionMapper;
import app.dao.sql.query.SessionQuery;
import app.models.Session;
import app.transaction.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionSqlDAO implements SessionDAO {
    private TransactionManager transactionManager;
    private Mapper<Session> sessionMapper = new SessionMapper();

    public SessionSqlDAO(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Session getSessionById(int id) {
        Session session = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(SessionQuery.GET_SESSION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                session = sessionMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public List<Session> getSessionsByMovieId(int movieId) {
        List<Session> sessions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(SessionQuery.GET_SESSION_BY_MOVIE_ID);
            preparedStatement.setInt(1, movieId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sessions.add(sessionMapper.getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }
}
