package parser;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

import task.*;
import ui.*;
import command.*;

public class parser {

    public static String[] commandToArray(String parseText) {
        return parseText.split(" ",2);
    }

    public static String[] dateToArray(String parseText) {
        return parseText.split(" /by | /at ",2);
    }

    public static LocalDate parseDate(String[] command) throws DateTimeParseException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate date;
        date = LocalDate.parse(command[1], formatter);
        return date;
    }

    public static LocalDateTime parseDateTime(String[] command) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        LocalDateTime dateTime;
        dateTime = LocalDateTime.parse(command[1].split(" /by | /at ")[1], formatter);
        return dateTime;
    }

    public static LocalDateTime parseDateTimeFromFile(String[] command) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        LocalDateTime dateTimeFromFile;
        dateTimeFromFile = LocalDateTime.parse(command[1].split(" /by | /at ")[1], formatter);
        return dateTimeFromFile;
    }

    public static command parser(String text, Tasklist taskList) throws IllegalArgumentException{
        assert text != null : "Command be null";
        String[] command = commandToArray(text);
        String instruction = command[0].toUpperCase();
        LocalDateTime dateTime;

        CommandFilter commandFilter = null;
        try {
            commandFilter = CommandFilter.valueOf(instruction);
        } catch (IllegalArgumentException e) {
            System.out.println("☹ Invalid Command");
        }


        switch (commandFilter) {
            case TODO:
                ui.todo_error(command);
                return new AddCommand(new Todo(text));
            case DEADLINE:
                try{
                    ui.deadline_error(command);
                    dateTime = parser.parseDateTime(command);
                    return new AddCommand(new Deadline(text,dateTime));
                }catch (DateTimeParseException e) {
                    return new InvalidCommand(ui.validateDateTime());
                }
            case EVENT:
                try{
                    ui.event_error(command);
                    dateTime = parser.parseDateTime(command);
                    return new AddCommand(new Event(text,dateTime));
                }catch (DateTimeParseException e) {
                    return new InvalidCommand(ui.validateDateTime());
                }
            case LIST:
                return new ListCommand();
            case DONE:
                ui.validateDone(command, taskList);
                return new DoneCommand(command);
            case DELETE:
                ui.validateDelete(command, taskList);
                command delete = new DeleteCommand(command);
                return delete;
            /*
            case VIEW:
                try{
                    Ui.validateViewCommand(command);
                    LocalDate date = parseDate(command);
                    return new ViewCommand(date);
                }catch (DateTimeParseException e) {
                    return new InvalidCommand("☹ Please enter datetime in the format of 'd/M/yyyy'");
                }
            case SEARCH:
                Ui.validateSearchCommand(command);
                String keyword = command[1];
                return new SearchCommand(keyword);

             */
            case BYE:
                return new ByeCommand();
            default:
                return new InvalidCommand("☹ Sorry, I don't know what it means :-(");
        }

    }
}
