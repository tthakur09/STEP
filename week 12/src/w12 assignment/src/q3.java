
import java.util.Scanner;

public class q3 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static String find(Node head, String id) {
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }

            position++;
            temp = temp.next;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position "
                + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            Node newNode = new Node(id);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String target = sc.next();

        System.out.println(find(head, target));

        sc.close();
    }
}

