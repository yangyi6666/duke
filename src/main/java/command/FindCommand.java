package command;

import exception.DukeException;
import storage.Storage;
import task.*;
import ui.ui;

/**
 * find command
 */
public class FindCommand extends command {

    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(Tasklist taskList, ui ui, Storage storage) throws DukeException {
        Tasklist taskByKeyword = taskList.getTaskByKeyword(keyword, taskList);
        ui.printTaskList(taskByKeyword);
        ui.printTaskByKeyword(taskByKeyword, keyword);
    }
}
