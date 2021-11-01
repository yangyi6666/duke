public class Event extends Task{

    protected String date_time;

    public Event(String description, String date_time) {
        super(description);
        this.date_time = date_time;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + date_time + ")";
    }

}