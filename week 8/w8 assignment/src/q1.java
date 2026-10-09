import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double getFinalAmount();
    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double getFinalAmount() {
        return amount + 10.0;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Customer[] bills = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills[i] = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    bills[i] = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    bills[i] = new GuestCustomer(amount);
                    break;
            }
        }

        double grandTotal = 0;
        for (Customer bill : bills) {
            double finalAmount = bill.getFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", bill.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
