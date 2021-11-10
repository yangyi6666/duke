package task;


public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getName(){
        return  description;
    }

    public boolean isDone() { return isDone; }

    public void setDone(boolean isDone) {this.isDone = isDone;}

    public void mark_done(){
        isDone = true;
    }

    public String getDoneIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public String getType(){
        return type;
    }

    public String toString(){
        /*String desc = getDoneIcon() + " " + description;

         */
        return "";
    }

    public String getTaskStr() {
        return "";
    }

    public String getDateTimeStr(){
        return "";
    }

    public String[] getKeyword(){
        return description.split(" ");
    }
}
