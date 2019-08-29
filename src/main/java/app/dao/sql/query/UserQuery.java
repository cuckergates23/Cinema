package app.dao.sql.query;

public class UserQuery {
    public static final String TABLE_NAME = "users";

    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String SECOND_NAME = "second_name";
    public static final String USER_NAME = "user_name";
    public static final String USER_PASSWORD = "user_password";
    public static final String EMAIL = "email";
    public static final String USER_ROLE = "user_role_id";

    public static final String GET_USER = "Select users.id, users.first_name, users.second_name, users.user_name, users.user_password, users.email,user_roles.user_role " +
            "From users Inner Join user_roles ON users.user_role_id=user_roles.id Where users.id=(?)";

    public static final String CREATE_USER = "Insert Into " + TABLE_NAME + " (" + FIRST_NAME + ", " + SECOND_NAME + ", " + USER_NAME + ", " + USER_PASSWORD + ", " + EMAIL + ", " + USER_ROLE + ")" +
            " VALUES (?,?,?,?,?,?)";
    public static final String GET_USER_BY_USER_NAME = "Select users.id, users.first_name, users.second_name, users.user_name, users.user_password, users.email,user_roles.user_role " +
            "From users Inner Join user_roles ON users.user_role_id=user_roles.id Where users.user_name=(?)";
}
