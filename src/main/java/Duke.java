import command.*;
import exception.*;
import parser.*;
import storage.*;
import task.*;
import ui.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {

    private Tasklist tasklist;
    private Storage storage;
    private ui ui;


    public Duke(String filePath) {
        ui = new ui();
        storage = new Storage(filePath);
        try {
            tasklist = new Tasklist(storage.load());
        } catch (DukeException e) {
            ui.error(e);
        } catch (FileNotFoundException e) {
            ui.error(e);
            tasklist = new Tasklist();
        }
    }

    public void run() {
        ui.hello();
        boolean isExit = false;
        while(!isExit){
            try {
                String userInput = ui.input();
                ui.Separator();
                command c = parser.parser(userInput, tasklist);
                c.execute(tasklist, ui, storage);
                isExit = c.isExit();
            } catch (DukeException | IOException e){
                ui.errorMessage(e);
            } finally {
                ui.Separator();
            }
        }
    }

    public static void main(String[] args){
        new Duke("src/data/tasks.txt").run();
    }

}