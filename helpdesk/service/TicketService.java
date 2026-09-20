package helpdesk.service;

import helpdesk.model.Ticket;

public class TicketService {
    private final NotificationService notificationService;

    public TicketService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void startTicket(Ticket ticket) {
        ticket.startProcessing();
        notificationService.send("Ticket #" + ticket.getId() + " is now in progress");
    }

    public void resolveTicket(Ticket ticket) {
        ticket.resolve();
        notificationService.send("Ticket #" + ticket.getId() + " has been resolved");
    }

    public void closeTicket(Ticket ticket) {
        ticket.close();
        notificationService.send("Ticket #" + ticket.getId() + " has been closed");
    }
    public void cancelTicket(Ticket ticket) {
        ticket.cancel();
        notificationService.send("Ticket #" + ticket.getId() + " has been cancelled");
    }
}