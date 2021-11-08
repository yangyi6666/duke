package storage;

import task.*;
import parser.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Storage {

    protected String filePath;

    public Storage (String filePath){
        this.filePath = filePath;
    }

    public void saveTask(ArrayList <Task> taskList) throws IOException {
        File file = new File(filePath);
        File dir = file.getParentFile();
        if(!file.exists()){
            if(!dir.exists()){
                dir.mkdirs();
            }
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        for(Task task : taskList){
            String type = task.getType();
            String toText = null;
            String description = task.getTaskStr();
            String dateTime = task.getDateTimeStr();

            switch (type){
                case "T":
                    toText = "Todo " + description + "\n";
                    break;
                case "D":
                    toText = "Deadline " + description + "/by " + dateTime + "\n";
                    break;
                case "E":
                    toText = "Event " +description + "/at " + dateTime + "\n";
                    break;
            }
            assert toText != null;
            fw.write(toText);
        }
        fw.close();
    }


    public ArrayList<Task> load() throws FileNotFoundException {
        Tasklist taskList = new Tasklist();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String text = sc.nextLine();
            String parseText = text.replaceAll(" \\[.*?] ", " ");
            boolean isDone = text.contains("X");
            String[] command = parser.commandToArray(parseText);
            String keyword = command[0];
            LocalDateTime dateTime;
            Task task;

            if(keyword.equals("Todo")){
                task = new Todo(parseText);
                task.setDone(isDone);
            }
            else if(keyword.equals("Deadline")){
                dateTime = parser.parseDateTimeFromFile(command);
                task = new Deadline(parseText, dateTime);
                task.setDone(isDone);
            }
            else{
                dateTime = parser.parseDateTimeFromFile(command);
                task = new Event(parseText, dateTime);
                task.setDone(isDone);
            }
            taskList.addtolist(task);
        }
        return taskList;
    }

}