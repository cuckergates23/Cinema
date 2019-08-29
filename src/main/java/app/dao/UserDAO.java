package app.dao;

import app.models.User;

public interface UserDAO {
    User getUserById(int id);

    void create(int userRoleId, User user);

    User getUserByUserName(String userName);
}
