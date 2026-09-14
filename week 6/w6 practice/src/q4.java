

import java.util.Scanner;

public class q4 {


    static class IdCard {
        String name;
        int booksIssued;


        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter initial books issued: ");
        int initialBooks = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter updated books issued: ");
        int updatedBooks = Integer.parseInt(scanner.nextLine().trim());


        IdCard ravi = new IdCard(name, initialBooks);


        IdCard duplicate = ravi;


        duplicate.booksIssued = updatedBooks;


        IdCard separate = new IdCard(name, updatedBooks);


        System.out.println(ravi.name + "'s booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        scanner.close();
    }
}