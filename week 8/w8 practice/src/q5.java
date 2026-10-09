import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            switch (type) {
                case "BUS":
                    journeys[i] = new BusTransport(distance);
                    break;
                case "TRAIN":
                    journeys[i] = new TrainTransport(distance);
                    break;
                case "METRO":
                    double factor = scanner.nextDouble();
                    journeys[i] = new MetroTransport(distance, factor);
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
