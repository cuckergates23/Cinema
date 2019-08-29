package app.controller.commands.user;

import app.controller.commands.Command;
import app.models.Ticket;
import app.models.User;
import app.services.TicketService;
import app.utils.AttributesNames;
import app.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PersonalCabinetView implements Command {
    private TicketService ticketService;

    public PersonalCabinetView(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(AttributesNames.USER);
        if (user == null) {

        } else {
            List<Ticket> tickets = ticketService.getByUserName(user.getUserName());
            request.setAttribute(AttributesNames.TICKETS, tickets);
            request.getRequestDispatcher(Pages.CABINET).forward(request, response);
        }
    }
}
