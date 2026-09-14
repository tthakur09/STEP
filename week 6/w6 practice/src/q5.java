

import java.util.Scanner;

public class q5 {


    static class Student {

        private String name;
        private double attendance;


        public static String collegeName = "SRM Institute of Science and Technology";
        public static int studentCount = 0;


        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }


        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 2;
        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Attendance: ");
            double attendance = Double.parseDouble(scanner.nextLine().trim());

            students[i] = new Student(name, attendance);
            System.out.println();
        }


        Student.printCollegeInfo();

        scanner.close();
    }
}
