import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getBasePrice();
    public abstract String getSeatType();

    public double calculateTotal() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Ticket[] bookings = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            switch (seat) {
                case "REGULAR":
                    bookings[i] = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    bookings[i] = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    bookings[i] = new ReclinerTicket(count);
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Ticket booking : bookings) {
            double amount = booking.calculateTotal();
            grandTotal += amount;
            System.out.printf("%s: %.2f\n", booking.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
