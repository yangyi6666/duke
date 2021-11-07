package command;

import storage.Storage;
import task.*;
import ui.ui;
import java.io.*;


public class AddCommand extends command {

    Task task;

    public AddCommand(Task task){
        this.task = task;
    }

    public void execute(Tasklist taskList, ui ui, Storage storage) throws IOException {
        taskList.addtolist(task);
        storage.saveTask(taskList.getTasks());
        ui.add_task(taskList);
    }

}
