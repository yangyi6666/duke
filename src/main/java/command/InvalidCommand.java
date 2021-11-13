package command;

import exception.*;
import storage.*;
import task.*;
import ui.*;

/**
 * invalide command and show error message
 */
public class InvalidCommand extends command{
    private final String errorMsg;

    public InvalidCommand(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public void execute(Tasklist taskList, ui ui, Storage storage) throws DukeException {
        throw new DukeException(errorMsg);
    }
}
