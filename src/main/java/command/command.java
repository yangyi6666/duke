package command;

import storage.Storage;
import task.Tasklist;
import ui.ui;
import exception.*;
import java.io.*;

public abstract class command {
    protected boolean isExit = false;

    public command(){}

    public command(String str){ System.out.println(str);}

    public abstract void execute(Tasklist taskList, ui ui, Storage storage) throws DukeException, IOException;

    public void setExit(boolean exit){
        isExit = exit;
    }

    public boolean isExit(){
        return isExit;
    }

}
