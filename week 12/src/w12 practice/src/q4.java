
import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount + amount * 0.02;
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        String[] modes = new String[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            amounts[i] = sc.nextDouble();

            switch (modes[i].toLowerCase()) {
                case "cash":
                    payments[i] = new CashPayment();
                    break;
                case "card":
                    payments[i] = new CardPayment();
                    break;
                case "upi":
                    payments[i] = new UpiPayment();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mode");
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double processed =
                    payments[i].processPayment(amounts[i]);

            double fee = processed - amounts[i];

            System.out.println(modes[i] + ": amount "
                    + amounts[i] + ", fee " + fee
                    + ", processed " + processed);

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);
        sc.close();
    }
}

