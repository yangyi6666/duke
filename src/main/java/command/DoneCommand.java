package command;

import storage.Storage;
import task.*;
import ui.ui;

import java.io.IOException;

public class DoneCommand extends command{
    String[] command;

    public DoneCommand(String[] command){
        this.command = command;
    }

    public void execute(Tasklist taskList, ui ui, Storage storage) throws IOException {
        int taskNumber = Integer.parseInt(command[1]) - 1;
        taskList.get(taskNumber).setDone(true);
        ui.printDone(taskNumber, taskList);
        storage.saveTask(taskList.getTasks());
    }

}