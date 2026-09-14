

import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;


    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initializing to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }


    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount: Must be greater than 0.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }


    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percent: Must be between 0 and 100.");
            return;
        }
        double taxAmount = (this.basicSalary * percent) / 100.0;
        this.basicSalary -= taxAmount;
        System.out.println("Tax deducted: " + (int) percent + "%");
    }


    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        PayrollAccount account = new PayrollAccount(basicSalary);

        System.out.print("Enter bonus to credit: ");
        double bonus = scanner.nextDouble();
        account.creditBonus(bonus);

        System.out.print("Enter tax percentage to deduct: ");
        double taxPercent = scanner.nextDouble();
        account.deductTax(taxPercent);

        System.out.println("Net salary: Rs " + account.getNetSalary());

        scanner.close();
    }
}