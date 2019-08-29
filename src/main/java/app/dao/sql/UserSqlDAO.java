package app.dao.sql;

import app.dao.UserDAO;
import app.dao.mappers.Mapper;
import app.dao.mappers.UserMapper;
import app.dao.sql.query.UserQuery;
import app.models.User;
import app.transaction.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSqlDAO implements UserDAO {
    private TransactionManager transactionManager;
    private Mapper<User> userMapper = new UserMapper();

    public UserSqlDAO(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(UserQuery.GET_USER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = userMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(int userRoleId, User user) {
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(UserQuery.CREATE_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, userRoleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = null;
        try {
            PreparedStatement preparedStatement = transactionManager.getConnection().prepareStatement(UserQuery.GET_USER_BY_USER_NAME);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = userMapper.getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
