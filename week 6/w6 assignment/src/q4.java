

import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;


    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter initial seat number: ");
        int initialSeat = scanner.nextInt();

        System.out.print("Enter updated seat number: ");
        int updatedSeat = scanner.nextInt();


        HallTicket priya = new HallTicket(name, initialSeat);


        HallTicket copy = priya;


        copy.seatNumber = updatedSeat;


        HallTicket separate = new HallTicket(name, updatedSeat);


        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        scanner.close();
    }
}