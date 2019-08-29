package app.controller;

import app.controller.commands.*;
import app.controller.commands.user.*;
import app.services.*;
import app.utils.UrlRequests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Command command;
    private Map<String, Command> commands;

    public CommandManager(MovieService movieService, HallService hallService, SessionService sessionService, TicketService ticketService, UserService userService) {
        commands = new HashMap<>();
        MainPageView mainPageView = new MainPageView(movieService);
        SchedulePageView schedulePageView = new SchedulePageView(sessionService);
        TicketsPageView ticketsPageView = new TicketsPageView(ticketService, sessionService);
        RegistrationPageView registrationPageView = new RegistrationPageView(userService);
        RegistrateUser registrateUser = new RegistrateUser(userService, mainPageView);
        LoginPageView loginPageView = new LoginPageView(userService);
        Login login = new Login(userService, mainPageView);
        LogOut logOut = new LogOut(mainPageView);
        PersonalCabinetView personalCabinetView = new PersonalCabinetView(ticketService);
        BuyTicket buyTicket = new BuyTicket(ticketService, loginPageView,mainPageView);

        commands.put(UrlRequests.MAIN_PAGE, mainPageView);
        commands.put(UrlRequests.SCHEDULE, schedulePageView);
        commands.put(UrlRequests.TICKETS, ticketsPageView);
        commands.put(UrlRequests.REGISTRATION_PAGE, registrationPageView);
        commands.put(UrlRequests.REGISTRATE, registrateUser);
        commands.put(UrlRequests.LOGIN, loginPageView);
        commands.put(UrlRequests.LOGIN_USER, login);
        commands.put(UrlRequests.LOGOUT_USER, logOut);
        commands.put(UrlRequests.OPEN_CABINET, personalCabinetView);
        commands.put(UrlRequests.BUY_TICKET, buyTicket);
    }

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = commands.get(req.getRequestURI());
        command.execute(req, resp);
    }
}
