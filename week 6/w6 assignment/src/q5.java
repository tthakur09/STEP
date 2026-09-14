import java.util.Scanner;

public class q5 {


    static class Employee {
        private String empName;
        private double salary;

        public static String companyName = "Bright Horizon Technologies";
        public static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees to create: ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());

            employees[i] = new Employee(name, salary);
        }

        System.out.println();
        Employee.printCompanyInfo();

        scanner.close();
    }
}