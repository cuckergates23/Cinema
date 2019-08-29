package app.services;

import app.dao.UserDAO;
import app.dao.sql.UserSqlDAO;
import app.models.User;
import app.models.enums.UserRole;
import app.transaction.TransactionManager;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

public class UserService {
    private UserDAO userDAO;
    private TransactionManager transactionManager;

    public UserService(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.userDAO = new UserSqlDAO(transactionManager);
    }

    public User get(int userId) {
        try {
            transactionManager.getConnection();
            return userDAO.getUserById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }

    public void create(User user) {
        try {
            transactionManager.getConnection();
            user.setUserPassword(DigestUtils.md5Hex(user.getUserPassword()));
            userDAO.create(getIdByRole(user.getUserRole()), user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            transactionManager.stopConnection();
        }
    }

    private int getIdByRole(UserRole userRole) {
        if (userRole == UserRole.USER) {
            return 1;
        }
        if (userRole == UserRole.ADMINISTRATOR) {
            return 2;
        }
        return 0;
    }

    public User loginUser(String userName, String userPassword) {
        try {
            transactionManager.getConnection();
            User user = userDAO.getUserByUserName(userName);
            if (user == null || !DigestUtils.md5Hex(userPassword).equals(user.getUserPassword())) {
                return null;
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            transactionManager.stopConnection();
        }
    }
}
