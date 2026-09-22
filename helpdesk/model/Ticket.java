package helpdesk.model;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private TicketStatus status;

    private TicketPriority priority;
    private final java.time.LocalDateTime createdAt;

    public Ticket(long id, String title, String description, TicketPriority priority) {
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.createdAt = java.time.LocalDateTime.now();
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TicketStatus.NEW;
        this.priority = priority;
    }
    public void reopen() {
        if (status != TicketStatus.RESOLVED && status != TicketStatus.CLOSED) {
            System.out.println("Error: can only reopen a RESOLVED or CLOSED ticket");
            return;
        }
        status = TicketStatus.REOPENED;
    }
    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TicketPriority getPriority() {
        return priority;
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
    public void cancel() {
        if (status == TicketStatus.CLOSED) {
            System.out.println("Error: cannot cancel a CLOSED ticket");
            return;
        }
        status = TicketStatus.CANCELLED;
    }
}