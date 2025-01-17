package task;

import java.util.ArrayList;
import java.util.List;

/**
 * tasklist contains all the tasks in arraylist format
 * contains all the functions to tasks
 */
public class Tasklist{
    private ArrayList<Task> tasks;

    public Tasklist(ArrayList<Task> load){
        this.tasks = load;
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

    public boolean contains(Task t){return tasks.contains(t);}

    public Tasklist getTaskByKeyword (String keyword, Tasklist taskList) throws IndexOutOfBoundsException{
        Tasklist taskByKeyword = new Tasklist();
        String[] keywordInTask;
        for (int i = 0; i < taskList.getlistsize(); i++){
            if (taskList.get(i).getType().equals("D") || taskList.get(i).getType().equals("E")) {
                keywordInTask = taskList.get(i).getKeyword()[0].split(" ");
            } else {
                keywordInTask = taskList.get(i).getKeyword();
            }
            for (String s : keywordInTask){
                if (s.contains(keyword) || keyword.contains(s)) {
                    if (!taskByKeyword.contains(taskList.get(i))){
                        taskByKeyword.addTask(taskList.get(i));
                    }
                }
            }
        }
        return taskByKeyword;
    }

    public void addTask (Task t) {
        tasks.add(t);
    }


}