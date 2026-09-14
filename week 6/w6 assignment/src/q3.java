

import java.util.Scanner;

class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;


    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }


    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }


    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter Permanent Employee ID: ");
        String permId = scanner.nextLine().trim();

        System.out.print("Enter Permanent Employee Name: ");
        String permName = scanner.nextLine().trim();

        System.out.print("Enter Permanent Employee Salary: ");
        double permSalary = Double.parseDouble(scanner.nextLine().trim());


        System.out.print("Enter Intern ID: ");
        String internId = scanner.nextLine().trim();

        System.out.print("Enter Intern Name: ");
        String internName = scanner.nextLine().trim();


        Employee permanentEmployee = new Employee(permId, permName, permSalary);
        Employee internEmployee = new Employee(internId, internName);


        permanentEmployee.printProfile();
        internEmployee.printProfile();

        scanner.close();
    }
}