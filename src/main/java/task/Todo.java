package task;

/**
 * class todo takes "todo" type of task and convert input to task format
 */
public class Todo extends Task {

    public Todo(String description){

        super(description);
        this.type="T";
    }

    public String toString(){
        return  "[" + getType() + "]"  + getDoneIcon() + " " + getName();
    }

    public String getTaskStr() {
        return "[" + getType() + "]"  + getDoneIcon() + " " +description.substring(5);
    }

    public String[] getKeyword (){
        return description.split(" ");
    }
}
