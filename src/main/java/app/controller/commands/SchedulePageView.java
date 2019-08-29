package app.controller.commands;

import app.services.SessionService;
import app.utils.AttributesNames;
import app.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SchedulePageView implements Command {
    private SessionService sessionService;

    public SchedulePageView(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(AttributesNames.MOVIE_ID) != null) {
            request.setAttribute(AttributesNames.MOVIE_SCHEDULE, sessionService.getSessionsByMovieId(Integer.valueOf(request.getParameter(AttributesNames.MOVIE_ID))));
        } else {
            request.setAttribute("Trial", "Bad info");
        }
        request.getRequestDispatcher(Pages.SCHEDULE).forward(request, response);
    }
}
