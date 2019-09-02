package app.controller.command;

import app.controller.commands.Command;
import app.controller.commands.RegistrateUser;
import app.models.User;
import app.models.enums.UserRole;
import app.services.UserService;
import app.utils.AttributesNames;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrateUserTest {

    @Mock
    private UserService userService;

    @Mock
    private Command openMainPage;

    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String USER_NAME = "userName";
    private static final String USER_PASSWORD = "userPassword";
    private static final String EMAIL = "email";

    @Mock
    private User user;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Test
    public void shouldRegistrateUser() throws ServletException, IOException {
        when(request.getParameter(AttributesNames.USER_FIRST_NAME)).thenReturn(FIRST_NAME);
        when(request.getParameter(AttributesNames.USER_SECOND_NAME)).thenReturn(SECOND_NAME);
        when(request.getParameter(AttributesNames.USER_NAME)).thenReturn(USER_NAME);
        when(request.getParameter(AttributesNames.USER_PASSWORD)).thenReturn(USER_PASSWORD);
        when(request.getParameter(AttributesNames.USER_EMAIL)).thenReturn(EMAIL);
        when(request.getSession()).thenReturn(session);
        new RegistrateUser(userService, openMainPage).execute(request, response);
        verify(userService).create(new User(FIRST_NAME, SECOND_NAME, USER_NAME, USER_PASSWORD, EMAIL, UserRole.USER));
    }
}
