package helpdesk.model;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private TicketStatus status;

    public Ticket(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TicketStatus.NEW;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void startProcessing() {
        if (status != TicketStatus.NEW) {
            System.out.println("Error: can only start processing a NEW ticket");
            return;
        }
        status = TicketStatus.IN_PROGRESS;
    }

    public void resolve() {
        if (status != TicketStatus.IN_PROGRESS) {
            System.out.println("Error: can only resolve a ticket that is IN_PROGRESS");
            return;
        }
        status = TicketStatus.RESOLVED;
    }

    public void close() {
        if (status != TicketStatus.RESOLVED) {
            System.out.println("Error: can only close a RESOLVED ticket");
            return;
        }
        status = TicketStatus.CLOSED;
    }
}