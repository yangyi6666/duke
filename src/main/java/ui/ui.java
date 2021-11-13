package ui;

import exception.DukeException;
import task.*;

import java.util.Scanner;

/**
 * Class ui contains output displayed when user input any comments
 * It also shows error messages for invalid input
 */
public class ui {

    private final Scanner in = new Scanner(System.in);
    private static final String SEPARATOR = "___________________________________________________________________________";

    /**
     * show seperator line
     */
    public void Separator() {System.out.println(SEPARATOR);}

    /**
     * Read input from user and convert to String format
     * @return
     */
    public String input(){
        return in.nextLine();
    }

    /**
     * Show Duke Logo
     */
    private static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    /**
     * Welcome message
     */
    public void hello() {
        System.out.println("Hello from\n" + logo);
        System.out.println(SEPARATOR);
        System.out.println("Hello! I am Duke");
        System.out.println("What can I do for you?");
        System.out.println(SEPARATOR);
    }

    /**
     * Exit Message
     */
    public void goodbye() {
        System.out.println("\nBye. Hope to see you again soon!\n" + logo);
    }

    /**
     * print error messages
     * @param e
     */
    public void error (Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * display user's new task
     * and show the list of all tasks
     * @param taskList
     */
    public void add_task(Tasklist taskList){
        System.out.println("Got it. I've added this task: ");
        System.out.println("\t"+taskList.get(taskList.getlistsize()-1).toString());
        System.out.println("Now you have " + taskList.getlistsize() + " tasks in the list");
    }

    /**
     * display invalid input for new todo, deadline, event
     * @param command
     */
    public static void todo_error(String[] command) {
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public static void deadline_error(String[] command) {
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static void event_error(String[] command) {
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("OOPS!!! The description of a event cannot be empty.");
        }
    }

    /**
     * check date time format and show the correct format if user input invalid
     * @return
     */
    public static String validateDateTime(){
        return "Task cannot be added. \n" + "Please enter datetime in the format of 'dd/MM/yyyy HHmm'";
    }

    /**
     * print task list of user's task
     * return list empty message if no task exist
     * showing total number of task in the list
     * @param taskList
     * @throws NullPointerException
     */
    public void printTaskList(Tasklist taskList) throws NullPointerException{
        if (taskList.getlistsize() == 0) {
            System.out.println("List is empty. Please add your tasks.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskList.getlistsize(); i++) {
                System.out.println("\t" + (i + 1) + "." + taskList.get(i).toString());
            }
        }
        System.out.println("Now you have " + taskList.getlistsize() + " tasks in the list");
    }

    public static void validateDone(String[] command, Tasklist taskList){
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("Please state task number.");
        }
        int taskNumber  = Integer.parseInt(command[1]) - 1;
        if (taskNumber >= taskList.getlistsize()) {
            throw new DukeException("There is no such task.");
        }
    }

    public void printDone(int i, Tasklist taskList){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t"+taskList.get(i).toString());
    }

    public static void validateDelete(String[] command, Tasklist taskList){
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("Please state task number.");
        }
        int taskNumber  = Integer.parseInt(command[1]) - 1;
        if (taskNumber >= taskList.getlistsize()) {
            throw new DukeException("There is no such task.");
        }
    }

    public void printDelete(int i, Tasklist taskList){
        System.out.println("Noted. I've removed this task: ");
        System.out.println("\t"+taskList.get(i).toString());
    }

    public static void validateFind(String[] command){
        if (command.length < 2 || command[1].equals("")) {
            throw new DukeException("Please specify keyword:");
        }
    }

    public void printTaskByKeyword(Tasklist taskList, String keyword){
        System.out.println("You have total " + (taskList.getlistsize()) +" tasks related to <" + keyword +">.");
    }

    public void errorMessage (Exception e) {
        System.out.println(e.getMessage());
    }
}