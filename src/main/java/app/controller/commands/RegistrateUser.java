package app.controller.commands;

import app.models.User;
import app.models.enums.UserRole;
import app.services.UserService;
import app.utils.AttributesNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrateUser implements Command {
    private UserService userService;
    Command openMainPage;

    public RegistrateUser(UserService userService, Command openMainPage) {
        this.userService = userService;
        this.openMainPage = openMainPage;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter(AttributesNames.USER_FIRST_NAME);
        String secondName = request.getParameter(AttributesNames.USER_SECOND_NAME);
        String userName = request.getParameter(AttributesNames.USER_NAME);
        String userPassword = request.getParameter(AttributesNames.USER_PASSWORD);
        String email = request.getParameter(AttributesNames.USER_EMAIL);
        User user = new User(firstName, secondName, userName, userPassword, email, UserRole.USER);
        userService.create(user);
        user = userService.loginUser(user.getUserName(), user.getUserPassword());
        request.getSession().setAttribute(AttributesNames.USER, user);
        openMainPage.execute(request, response);
    }
}
