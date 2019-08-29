package app.controller.commands.user;

import app.controller.commands.Command;
import app.utils.AttributesNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOut implements Command {
    private Command mainPageView;

    public LogOut(Command mainPageView) {
        this.mainPageView = mainPageView;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(AttributesNames.USER);
        mainPageView.execute(request, response);
    }
}
