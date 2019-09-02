package app.controller.command;

import app.controller.commands.Command;
import app.controller.commands.user.LogOut;
import app.utils.AttributesNames;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogOutTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private Command mainPageView;

    @Test
    public void shouldLogOut() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        new LogOut(mainPageView).execute(request, response);

        verify(session).removeAttribute(AttributesNames.USER);
    }
}
