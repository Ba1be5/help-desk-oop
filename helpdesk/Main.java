package helpdesk;

import helpdesk.model.Customer;
import helpdesk.model.SupportAgent;
import helpdesk.model.Ticket;
import helpdesk.model.TicketPriority;
import helpdesk.repository.TicketRepository;
import helpdesk.service.ConsoleNotificationService;
import helpdesk.service.NotificationService;
import helpdesk.service.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        // 1. Создаём клиентов и специалиста
        Customer customer = new Customer(1, "Anna Petrova", "anna@mail.ru");
        SupportAgent agent = new SupportAgent(2, "Sergey Ivanov", "sergey@helpdesk.ru");

        System.out.println("Customer: " + customer.getName());
        System.out.println("Agent: " + agent.getName());

        // 2. Создаём заявку
        Ticket ticket = new Ticket(1, "Wi-Fi not working", "No internet connection at home", TicketPriority.HIGH);
        System.out.println("Ticket #" + ticket.getId() + ": " + ticket.getTitle() 
        + " | " + ticket.getStatus() + " | " + ticket.getPriority());
        System.out.println("Created at: " + ticket.getCreatedAt());
        // 3. Сервисы
        NotificationService notificationService = new ConsoleNotificationService();
        TicketService ticketService = new TicketService(notificationService);
        TicketRepository repository = new TicketRepository();

        // 4. Жизненный цикл заявки
        ticketService.startTicket(ticket);
        System.out.println("Status: " + ticket.getStatus());

        ticketService.resolveTicket(ticket);
        System.out.println("Status: " + ticket.getStatus());

        ticketService.closeTicket(ticket);
        System.out.println("Status: " + ticket.getStatus());

        // 5. Сохраняем заявку в репозиторий
        repository.add(ticket);

        // 6. Выводим все заявки
        System.out.println("\nAll tickets:");
        for (Ticket t : repository.findAll()) {
            System.out.println("#" + t.getId() + " " + t.getTitle() + " | " + t.getStatus());
        }
        ticket.cancel();
        System.out.println("Status after cancel: " + ticket.getStatus());
        //Ticket badTicket = new Ticket(2, "", "Some description", TicketPriority.LOW);
    }
}