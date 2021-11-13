package command;

import storage.Storage;
import task.*;
import ui.ui;

/**
 * execute bye when user enters "bye"
 */
public class ByeCommand extends command{
    public void execute(Tasklist taskList, ui ui, Storage storage) {
        ui.goodbye();
        super.setExit(true);
    }
}
