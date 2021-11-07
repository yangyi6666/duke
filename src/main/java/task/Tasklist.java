package task;

import java.util.ArrayList;
import java.util.List;


public class Tasklist {
    private List<Task> tasks;

    public Tasklist(ArrayList<Task> load){
        this.tasks = new ArrayList<>();
    }

    public Tasklist() {
        tasks = new ArrayList<>();
    }

    public void addtolist(Task task){
        tasks.add(task);
    }

    public Task get(int i) {
        return tasks.get(i);
    }

    public void done(int index){
        tasks.get(index-1).mark_done();
    }

    public ArrayList<Task> getTasks() {
        return (ArrayList<Task>) tasks;
    }

    public void delete(int index){
        tasks.remove(index);
    }

    public Task getIndex (int index){
        return this.tasks.get(index-1);
    }

    public String taskname(int index){
        return tasks.get(index-1).description;
    }

    public int getlistsize(){
        return tasks.size();
    }


}