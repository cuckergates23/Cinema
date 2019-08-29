package app.controller.commands.user;

import app.controller.commands.Command;
import app.models.User;
import app.services.UserService;
import app.utils.AttributesNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Command {
    private UserService userService;
    private Command mainPageView;

    public Login(UserService userService, Command mainPageView) {
        this.userService = userService;
        this.mainPageView = mainPageView;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter(AttributesNames.USER_NAME);
        String userPassword = request.getParameter(AttributesNames.USER_PASSWORD);
        User user = userService.loginUser(userName, userPassword);
        if (user == null) {
            new LoginPageView(userService).execute(request, response);
        } else {
            request.getSession().setAttribute(AttributesNames.USER, user);
            mainPageView.execute(request, response);
        }
    }
}
