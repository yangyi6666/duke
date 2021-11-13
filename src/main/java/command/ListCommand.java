package command;

import storage.Storage;
import task.*;
import ui.*;

/**
 * list command to show list
 */
public class ListCommand extends command {

    public ListCommand (){}

    public void execute(Tasklist taskList, ui ui, Storage storage) {
        ui.printTaskList(taskList);
    }
}