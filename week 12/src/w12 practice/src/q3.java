
import java.util.Scanner;

public class q3 {
    static String[] pile = new String[3];
    static int top = -1;

    static String[] queue = new String[3];
    static int front = 0, rear = -1, size = 0;

    static void returnBook(String book) {
        if (top == 2) {
            System.out.println(book + " rejected: pile is full");
        } else {
            pile[++top] = book;
            System.out.println(book + " placed on pile");
        }
    }

    static void shelve() {
        if (top == -1) {
            System.out.println("pile is empty");
        } else {
            System.out.println("shelved " + pile[top--]);
        }
    }

    static void waitStudent(String name) {
        if (size == 3) {
            System.out.println(name + " rejected: line is full");
        } else {
            rear = (rear + 1) % 3;
            queue[rear] = name;
            size++;
            System.out.println(name + " joined the line");
        }
    }

    static void serve() {
        if (size == 0) {
            System.out.println("no one waiting");
        } else {
            System.out.println("served " + queue[front]);
            front = (front + 1) % 3;
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) continue;

            String[] commands = line.split(",");

            for (String command : commands) {
                String[] parts = command.trim().split("\\s+", 2);
                String action = parts[0].toUpperCase();

                switch (action) {
                    case "RETURN":
                        if (parts.length > 1)
                            returnBook(parts[1]);
                        break;

                    case "SHELVE":
                        shelve();
                        break;

                    case "WAIT":
                        if (parts.length > 1)
                            waitStudent(parts[1]);
                        break;

                    case "SERVE":
                        serve();
                        break;
                }
            }
        }

        sc.close();
    }
}
