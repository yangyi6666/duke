package task;

public class Todo extends Task {

    public Todo(String description){

        super(description);
        this.type="T";
    }

    public String toString(){
        return "[" + getType() + "]"  + super.toString();
    }
}
