package app.controller.commands;

import app.services.MovieService;
import app.utils.AttributesNames;
import app.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageView implements Command {
    private MovieService movieService;

    public MainPageView(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(AttributesNames.ACTIVE_MOVIES, movieService.getAllActiveMovies());
        request.getRequestDispatcher(Pages.MAIN).forward(request, response);
    }
}
