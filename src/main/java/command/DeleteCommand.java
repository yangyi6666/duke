package command;

import storage.Storage;
import task.*;
import ui.ui;

import java.io.IOException;

/**
 * delete command
 */
public class DeleteCommand extends command{
    String[] command;

    public DeleteCommand(String[] command){
        this.command = command;
    }

    public void execute(Tasklist taskList, ui ui, Storage storage) throws IOException {
        int taskNumber = Integer.parseInt(command[1]) - 1;
        ui.printDelete(taskNumber,taskList);
        taskList.delete(taskNumber);
        storage.saveTask(taskList.getTasks());
    }
}
