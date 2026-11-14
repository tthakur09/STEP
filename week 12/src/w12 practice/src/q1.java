
import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    void display() {
        double bonus = getBonus();
        System.out.println(name + " (" + getType() + "): base "
                + baseSalary + ", bonus " + bonus
                + ", total " + (baseSalary + bonus));
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 5000;
    }

    @Override
    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 2000;
    }

    @Override
    String getType() {
        return "LabAssistant";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher")) {
                staff[i] = new Teacher(name, salary);
            } else if (type.equals("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            } else {
                staff[i] = new Staff(name, salary);
            }
        }

        double grandTotal = 0;

        for (Staff s : staff) {
            s.display();
            grandTotal += s.baseSalary + s.getBonus();
        }

        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}

