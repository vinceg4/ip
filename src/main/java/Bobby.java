import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bobby {
    private static List<String> storage = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        greet();
        while (true) {
            System.out.println();
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                bye();
                System.out.println();
                break;
            }

            if (input.equals("list")) {
                listOutTasks();
                System.out.println();
            } else {
                addToList(input);
            }
        }
    }

    // Make a horizontal line of x dashes
    public static void horizontalLine(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print("-");
        }
    }

    public static void greet() {
        horizontalLine(35);
        System.out.println();
        System.out.println("Hello! I'm Bobby");
        System.out.println("What can I do for you?");
        horizontalLine(35);
    }

    public static void bye() {
        horizontalLine(35);
        System.out.println();
        System.out.println("Bye. Hope to see you again soon!");
        horizontalLine(35);
    }

    public static void repeat(String s) {
        horizontalLine(35);
        System.out.println();
        System.out.println(s);
        horizontalLine(35);
    }

    public static void addToList(String s) {
        Bobby.storage.add(s);
        horizontalLine(35);
        System.out.println();
        System.out.println("added: " + s);
        horizontalLine(35);
    }

    public static void listOutTasks() {
        horizontalLine(35);
        int n = Bobby.storage.size();
        System.out.println();
        for (int i = 0; i < n; i++) {
            int number = i + 1;
            System.out.println(number + ". " + Bobby.storage.get(i));
        }
        horizontalLine(35);
    }
}
