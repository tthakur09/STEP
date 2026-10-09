import java.util.Scanner;

interface UsesBus {
}

abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getBaseFee();

    public double calculateTotalFee() {
        double total = getBaseFee();
        if (this instanceof UsesBus) {
            total += TRANSPORT_FEE;
        }
        return total;
    }
}

class DayScholarStudent extends Student implements UsesBus {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseFee() {
        return 40000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarStudent extends Student implements UsesBus {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseFee() {
        return 20000.0;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholarStudent(name);
                    break;
                case "HOSTELLER":
                    students[i] = new HostellerStudent(name);
                    break;
                case "SCHOLAR":
                    students[i] = new ScholarStudent(name);
                    break;
            }
        }

        double totalCollected = 0.0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}