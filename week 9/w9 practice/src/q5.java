import java.util.Scanner;

abstract class Booking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double getBaseFare();
    public abstract String getMode();

    public double calculateTotal() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return 2.0 * distanceKm;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return 1.5 * distanceKm;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getBaseFare() {
        return 2500.0 + (4.0 * distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distanceKm);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distanceKm);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distanceKm);
                    break;
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.calculateTotal());
        }

        scanner.close();
    }
}