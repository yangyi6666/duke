package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {

    protected LocalDateTime date;

    public Deadline(String description, LocalDateTime date) {
        super(description);
        this.date = date;
        this.type = "D";
    }

    @Override
    public String toString() {
        return "[" + getType() + "]"  + getDoneIcon() + " " + getName();
    }

    public String getTaskStr() {
        return "[" + getType() + "]"  + getDoneIcon() + " " +description.substring(9,description.indexOf('/'));
    }

    public  String getDateTimeStr() {
        return date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT));
    }

    public String[] getKeyword (){
        return description.split("/by");
    }
}
