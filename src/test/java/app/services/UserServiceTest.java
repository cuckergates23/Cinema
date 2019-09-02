package app.services;

import app.dbcp.ConnectionManager;
import app.models.User;
import app.transaction.TransactionManager;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class UserServiceTest {
    private ConnectionManager connectionManager = new ConnectionManager();
    private TransactionManager transactionManager = new TransactionManager(connectionManager);
    private UserService userService = new UserService(transactionManager);

    private static final String wrongPassword = "Wrong password";
    private static final String wrongUserName = "Wrong username";

    private static final String correctUserName = "NewUser";
    private static final String correctPassword = "NewPassword";


    @Test
    public void shouldRejectWrongUser() {
        assertNull(userService.loginUser(wrongUserName, wrongPassword));
    }

    @Test
    public void shouldReturnUser() {
        assertThat(userService.loginUser(correctUserName, correctPassword), instanceOf(User.class));
    }
}
