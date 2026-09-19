package helpdesk;

import helpdesk.model.Ticket;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Ticket ticket = new Ticket(
                1,
                "Internet not working",
                "No connection after reboot"
        );

        System.out.println("1. " + ticket.getTitle() + " | " + ticket.getStatus());

        ticket.startProcessing();
        System.out.println("2. " + ticket.getStatus());

        ticket.resolve();
        System.out.println("3. " + ticket.getStatus());

        ticket.close();
        System.out.println("4. " + ticket.getStatus());
    }
}