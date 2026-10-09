import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    deliveries[i] = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = scanner.nextDouble();
                    deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", d.getType(), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}