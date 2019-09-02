package app.services;

import app.dao.SessionDAO;
import app.dao.sql.SessionSqlDAO;
import app.models.Session;
import app.transaction.TransactionManager;

import java.sql.SQLException;
import java.util.List;

public class SessionService {
    private SessionDAO sessionDAO;
    private TransactionManager transactionManager;

    public SessionService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.sessionDAO = new SessionSqlDAO(transactionManager);
    }

    public Session get(int id) {
        try {
            transactionManager.getConnection();
            return sessionDAO.getSessionById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public List<Session> getSessionsByMovieId(int movieId) {
        try {
            transactionManager.getConnection();
            return sessionDAO.getSessionsByMovieId(movieId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }
}
