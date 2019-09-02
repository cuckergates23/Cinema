package app.controller.command;

import app.controller.commands.Command;
import app.controller.commands.user.Login;
import app.models.User;
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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    private static final String USER_NAME = "NewUser";
    private static final String PASSWORD = "NewPassword";

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private User user;

    @Mock
    private Command mainPageView;

    @Mock
    private HttpSession httpSession;

    @Test
    public void shouldLoginCorrectUser() throws ServletException, IOException {
        when(request.getParameter(AttributesNames.USER_NAME)).thenReturn(USER_NAME);
        when(request.getParameter(AttributesNames.USER_PASSWORD)).thenReturn(PASSWORD);
        when(userService.loginUser(USER_NAME, PASSWORD)).thenReturn(user);
        when(request.getSession()).thenReturn(httpSession);
        new Login(userService, mainPageView).execute(request, response);
        verify(httpSession).setAttribute(AttributesNames.USER, user);
    }

    @Test
    public void shouldNotLoginWrongUser() throws ServletException, IOException {
        when(request.getParameter(AttributesNames.USER_NAME)).thenReturn(USER_NAME);
        when(request.getParameter(AttributesNames.USER_PASSWORD)).thenReturn(PASSWORD);
        when(userService.loginUser(USER_NAME, PASSWORD)).thenReturn(null);
        when(request.getSession()).thenReturn(httpSession);
        new Login(userService, mainPageView).execute(request, response);
        verify(httpSession,never()).setAttribute(AttributesNames.USER,user);
    }
}
