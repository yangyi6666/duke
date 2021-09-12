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
        while(text!=null){
             if(text.equalsIgnoreCase("list")){
                 printlist(list);
             } else if (text.equalsIgnoreCase("bye")){
                 System.out.println("____________________________________________________________");
                 System.out.println("Bye. Hope to see you again soon!");
                 System.out.println("____________________________________________________________");
                 System.exit(0);
             } else {
                 addToList(text);
                 System.out.println("____________________________________________________________");
                 System.out.println("added: " + text);
                 System.out.println("____________________________________________________________");
             }
             text = in.nextLine();
        }
    }

    private static void addToList(String text) {
        list[countList]=text;
        countList++;
    }

    private static void printlist(String[] list) {
        for (int i =0; i < list.length; i ++){
            if (list[i] != null){
                System.out.println(i+1 + ". " + list[i]);
            }
        }
    }
}
