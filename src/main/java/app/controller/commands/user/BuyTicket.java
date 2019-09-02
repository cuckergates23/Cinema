package app.controller.commands.user;

import app.controller.commands.Command;
import app.controller.commands.MainPageView;
import app.dto.TicketDTO;
import app.models.Session;
import app.models.User;
import app.services.TicketService;
import app.utils.AttributesNames;
import app.utils.DefaultValues;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BuyTicket implements Command {
    private TicketService ticketService;
    private Command loginPageView;
    private Command mainPageView;

    public BuyTicket(TicketService ticketService, Command loginPageView, Command mainPageView) {
        this.ticketService = ticketService;
        this.loginPageView = loginPageView;
        this.mainPageView = mainPageView;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(AttributesNames.USER);
        if (user == null) {
            loginPageView.execute(request, response);
        } else {
            Session session = (Session) httpSession.getAttribute(AttributesNames.SESSION_TICKETS);
            TicketDTO ticketDTO = new TicketDTO(user.getId(), session.getId(), request.getParameter(AttributesNames.BUY_TICKETS), DefaultValues.DEFAULT_TICKET_PRICE);
            ticketService.buyTicket(ticketDTO);
            mainPageView.execute(request, response);
        }
    }
}
