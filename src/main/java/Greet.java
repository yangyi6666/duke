import java.util.Scanner;

public class Greet {
    static String[] list = new String[100];
    static int countList = 0;

    public static void main(String[] args) {
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
            if (text.equalsIgnoreCase("list")) {
                System.out.println(tasklist.print_list());
            } else if (text.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                System.exit(0);
            } else if (input.equalsIgnoreCase("done")) {
                if (input.equals("done")) {
                    int doneIndex = Integer.valueOf(text.split(" ")[1]);
                    task.mark_done();
                    tasklist.done(doneIndex);
                    System.out.print("Nice! I've marked this task as done:\n");
                    System.out.println(task.getDoneIcon() + tasklist.taskname(doneIndex));
                    System.out.print("__________________________________________________________\n");
                }
            } else if (input.equalsIgnoreCase("todo")) {
                System.out.println("Got it. I've added this task: ");
                String newtext = text.split(" ", 2)[1];
                Todo newtask = new Todo(newtext);
                System.out.println(newtask.toString());
                tasklist.addtolist(newtask);
                System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                System.out.print("____________________________________________________________\n");
            } else if (input.equalsIgnoreCase("deadline")) {
                System.out.println("Got it. I've added this task: ");
                String newtext = text.split(" ", 2)[1];
                String middleword = newtext.split("/by")[0];
                String deadlinedate = newtext.split("/by")[1];
                Deadline newtask = new Deadline(middleword,deadlinedate);
                System.out.println(newtask.toString());
                tasklist.addtolist(newtask);
                System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                System.out.print("____________________________________________________________\n");
            } else if (input.equalsIgnoreCase("event")) {
                System.out.println("Got it. I've added this task: ");
                String newtext = text.split(" ", 2)[1];
                String middleword = newtext.split("/at")[0];
                String eventdate = newtext.split("/at")[1];
                Event newtask = new Event(middleword,eventdate);
                System.out.println(newtask.toString());
                tasklist.addtolist(newtask);
                System.out.println("Now you have " + tasklist.getlistsize() + " tasks in the list");
                System.out.print("____________________________________________________________\n");
            } else {
                Task new_task = new Task(text);
                tasklist.addtolist(new_task);
                System.out.println("____________________________________________________________");
                System.out.println("added: " + text);
                System.out.println("____________________________________________________________");
            }
            text = in.nextLine();
        }
    }
}