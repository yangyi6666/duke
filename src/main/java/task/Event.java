package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event extends Task {

    protected LocalDateTime date_time;

    public Event(String description, LocalDateTime date_time) {
        super(description);
        this.date_time = date_time;
        this.type = "E";
    }

    @Override
    public String toString() {
        return "[" + getType() + "]"  + getDoneIcon() + " " +  getName();
    }

    public String getTaskStr() {return  "[" + getType() + "]"  + getDoneIcon() + " " +description.substring(6,description.indexOf('/'));}

    public String getDateTimeStr() {
        return date_time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT));
    }

    public String[] getKeyword (){
        return description.split("/at");
    }

}
