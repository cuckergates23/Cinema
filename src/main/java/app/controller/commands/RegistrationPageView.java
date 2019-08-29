package app.controller.commands;

import app.services.UserService;
import app.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageView implements Command {
    private UserService userService;

    public RegistrationPageView(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Pages.REGISTRATION).forward(request, response);
    }
}
