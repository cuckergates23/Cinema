package app.controller.commands;

import app.dto.PlaceDTO;
import app.models.Session;
import app.services.SessionService;
import app.services.TicketService;
import app.utils.AttributesNames;
import app.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketsPageView implements Command {
    private TicketService ticketService;
    private SessionService sessionService;

    public TicketsPageView(TicketService ticketService, SessionService sessionService) {
        this.ticketService = ticketService;
        this.sessionService = sessionService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(AttributesNames.SESSION_ID) != null) {
            int id = Integer.valueOf(request.getParameter(AttributesNames.SESSION_ID));
            Session session = sessionService.get(id);
            request.getSession().setAttribute(AttributesNames.SESSION_TICKETS, session);
            List<PlaceDTO> placeDTOList = new ArrayList<>();
            for (int i = 1; i <= session.getHall().getRowsAmount(); i++) {
                for (int j = 1; j <= session.getHall().getPlacesInRow(); j++) {
                    placeDTOList.add(new PlaceDTO(j, i, ticketService.checkTicket(session.getId(), i, j)));
                }
            }
            request.setAttribute(AttributesNames.PLACES, placeDTOList);
        }
        request.getRequestDispatcher(Pages.TICKETS).forward(request, response);
    }
}
