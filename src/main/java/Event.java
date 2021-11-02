public class Event extends Task{

    protected String date_time;

    public Event(String description, String date_time) {
        super(description);
        this.date_time = date_time;
        this.type = "E";
    }
    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString() + " (at: " + date_time + ")";
    }

}