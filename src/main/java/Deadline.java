public class Deadline extends Task {

    protected String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
        this.type = "D";
    }

    @Override
    public String toString() {
        return "[" + getType() + "]" + super.toString() + " (by: " + date + ")";
    }
}