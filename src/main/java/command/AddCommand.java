package command;

import storage.Storage;
import task.*;
import ui.ui;
import java.io.*;

/**
 * add command to tasklist, call storage and ui to save and display message to user
 */

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
