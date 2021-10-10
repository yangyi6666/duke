public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getName(){
        return  description;
    }

    public void mark_done(){
        isDone = true;
    }

    public String getDoneIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public boolean getStatus(){
        return isDone;
    }

    public String toString(){
        String desc = getDoneIcon() + " " + description;
        return desc;
    }
}
