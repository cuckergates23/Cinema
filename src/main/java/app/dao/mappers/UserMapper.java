package app.dao.mappers;

import app.dao.sql.query.UserQuery;
import app.models.User;
import app.models.enums.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User getEntity(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return null;
        }
        return new User(resultSet.getInt(UserQuery.ID),
                resultSet.getString(UserQuery.FIRST_NAME),
                resultSet.getString(UserQuery.SECOND_NAME),
                resultSet.getString(UserQuery.USER_NAME),
                resultSet.getString(UserQuery.USER_PASSWORD),
                resultSet.getString(UserQuery.EMAIL),
                UserRole.valueOf(resultSet.getString("user_role").toUpperCase()));
    }
}
