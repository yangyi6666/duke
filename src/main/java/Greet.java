import java.io.IOException;
import java.util.Scanner;

public class Greet {
    static String[] list = new String[100];
    static int countList = 0;

    public static void main(String[] args) throws DukeException {
        String text;
        Scanner in = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        text = in.nextLine();

        Tasklist tasklist = new Tasklist();
        Task task = new Task(text);

        while (text != null) {
            String input = text.split(" ")[0];
        try {
            if (text.equalsIgnoreCase("list")) {
                System.out.println(tasklist.print_list());

            } else if (text.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                System.exit(0);

            } else if (input.equalsIgnoreCase("done")) {
                try {
                    int doneIndex = Integer.valueOf(text.split(" ")[1]);
                    task.mark_done();
                    tasklist.done(doneIndex);
                    System.out.print("Nice! I've marked this task as done:\n");
                    System.out.println(tasklist.getIndex(doneIndex));
                    System.out.print("__________________________________________________________\n");
                } catch (Exception e){
                    throw new DukeException("☹ OOPS!!! The is no such task in the list, please try another one.");
                }

            } else if (input.equalsIgnoreCase("todo")) {
                try {
                    String newtext = text.split(" ", 2)[1];
                    Todo newtask = new Todo(newtext);
                    System.out.println(newtask.toString());
                    tasklist.addtolist(newtask);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                    System.out.print("____________________________________________________________\n");
                } catch (Exception e) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }

            } else if (input.equalsIgnoreCase("deadline")) {
                try {
                    String newtext = text.split(" ", 2)[1];
                    String middleword = newtext.split("/by")[0];
                    String deadlinedate = newtext.split("/by")[1];
                    Deadline newtask = new Deadline(middleword, deadlinedate);
                    System.out.println(newtask.toString());
                    tasklist.addtolist(newtask);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                    System.out.print("____________________________________________________________\n");
                } catch (Exception e){
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }

            } else if (input.equalsIgnoreCase("event")) {
                try {
                    String newtext = text.split(" ", 2)[1];
                    String middleword = newtext.split("/at")[0];
                    String eventdate = newtext.split("/at")[1];
                    Event newtask = new Event(middleword, eventdate);
                    System.out.println(newtask.toString());
                    tasklist.addtolist(newtask);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                    System.out.print("____________________________________________________________\n");
                } catch (Exception e){
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                }

            } else if (input.equalsIgnoreCase("delete")) {
                try {
                    int delete_index = Integer.valueOf(text.split(" ")[1]);
                    System.out.print("Noted. I've removed this task:\n");
                    System.out.println(tasklist.getIndex(delete_index));
                    tasklist.delete(delete_index);
                    System.out.print("__________________________________________________________\n");
                    System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                } catch (Exception e){
                    throw new DukeException("☹ OOPS!!! The commend of delete cannot be empty.");
                }

            }else {
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

        } catch (DukeException e){
            System.err.println("\t" + e);
        }
            text = in.nextLine();
        }
    }
}