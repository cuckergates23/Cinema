package app.servlets;

import app.controller.CommandManager;
import app.dbcp.ConnectionManager;
import app.services.*;
import app.transaction.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private CommandManager commandManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandManager.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandManager.execute(req, resp);
    }

    @Override
    public void init() throws ServletException {
        ConnectionManager connectionManager = new ConnectionManager();
        TransactionManager transactionManager = new TransactionManager(connectionManager);

        MovieService movieService = new MovieService(transactionManager);
        HallService hallService = new HallService(transactionManager);
        SessionService sessionService = new SessionService(transactionManager);
        TicketService ticketService = new TicketService(transactionManager);
        UserService userService = new UserService(transactionManager);
        commandManager = new CommandManager(movieService, hallService, sessionService, ticketService, userService);
    }
}
