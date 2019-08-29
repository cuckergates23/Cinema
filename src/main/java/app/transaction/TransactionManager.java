package app.transaction;

import app.dbcp.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    private ThreadLocal<Connection> threadConnection = new ThreadLocal<>();
    private ConnectionManager connectionManager;

    public TransactionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Connection getConnection() throws SQLException {
        startConnection();
        return threadConnection.get();
    }

    public void stopConnection() {
        try {
            Connection connection = threadConnection.get();
            if (connection != null) {
                connection.close();
            }
            threadConnection.remove();
        } catch (SQLException e) {
        }
    }

    private void startConnection() throws SQLException {
        if (threadConnection.get() == null) {
            threadConnection.set(connectionManager.getConnection());
        }
    }

    public void startTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        connection.setSavepoint();
    }

    public void endTransaction() throws SQLException {
        Connection connection = getConnection();
        if (connection == null) {
            // throw exception;
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                // throw rollback exception
            }
            //  throw commitException;
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stopConnection();
        }
    }
}
