import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double getAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01;
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new CardPayment(amount);
                    break;
                case "WALLET":
                    payments[i] = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payments[i] = new BankTransferPayment(amount);
                    break;
            }
        }

        double totalProcessed = 0.0;
        for (Payment payment : payments) {
            double adjusted = payment.getAdjustedAmount();
            totalProcessed += adjusted;
            System.out.printf("%s: %.2f\n", payment.getType(), adjusted);
        }

        System.out.printf("Total: %.2f\n", totalProcessed);
        scanner.close();
    }
}