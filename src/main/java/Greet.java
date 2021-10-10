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