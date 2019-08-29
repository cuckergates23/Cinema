package app.services;

import app.dao.HallDAO;
import app.dao.sql.HallSqlDAO;
import app.models.Hall;
import app.transaction.TransactionManager;

import java.sql.SQLException;

public class HallService {
    private HallDAO hallDAO;
    private TransactionManager transactionManager;

    public HallService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.hallDAO = new HallSqlDAO(transactionManager);
    }

    public Hall get(int userId) {
        try {
            transactionManager.getConnection();
            return hallDAO.getHallById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }
}
