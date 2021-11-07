package task;

public class Todo extends Task {

    public Todo(String description){

        super(description);
        this.type="T";
    }

    public String toString(){
        return "[" + getType() + "]"  + super.toString();
    }

    public String getTaskStr() {
        return "[" + getType() + "]" + getDoneIcon() + description.substring(5);
    }
}
