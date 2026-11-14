
import java.util.Scanner;

public class q4 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addLast(Node head, String booking) {
        Node newNode = new Node(booking);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null &&
                !temp.next.data.equals(booking)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(booking + " not found");
        } else {
            temp.next = temp.next.next;
        }

        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String booking = sc.next();
            head = addLast(head, booking);
        }

        String cancel = sc.next();

        head = removeFirst(head, cancel);

        display(head);

        sc.close();
    }
}
