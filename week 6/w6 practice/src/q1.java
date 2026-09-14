

import java.util.Scanner;

public class q1 {


    static class PlacementRecord {
        private String studentName;
        private String company;
        private double packageLpa;


        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }


        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 3;
        PlacementRecord[] records = new PlacementRecord[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Student Name: ");
            String studentName = scanner.nextLine().trim();

            System.out.print("Company: ");
            String company = scanner.nextLine().trim();

            System.out.print("Package (LPA): ");
            double packageLpa = Double.parseDouble(scanner.nextLine().trim());

            records[i] = new PlacementRecord(studentName, company, packageLpa);
        }

        System.out.println("\nPlacement Records:");
        for (PlacementRecord record : records) {
            record.printRecord();
        }

        scanner.close();
    }
}