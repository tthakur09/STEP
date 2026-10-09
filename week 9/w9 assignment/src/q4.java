import java.util.Scanner;

interface NightServiceable {
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double getRatePerKm();
    public abstract String getType();

    public boolean isNightServiceAllowed() {
        return this instanceof NightServiceable;
    }

    public double calculateFare() {
        double fare = Math.max(km * getRatePerKm(), 100.0);
        if (time.equals("NIGHT")) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            switch (type) {
                case "MINI":
                    cabs[i] = new MiniCab(km, time);
                    break;
                case "SEDAN":
                    cabs[i] = new SedanCab(km, time);
                    break;
                case "SUV":
                    cabs[i] = new SUVCab(km, time);
                    break;
            }
        }

        double totalFare = 0.0;
        for (Cab cab : cabs) {
            if (cab.time.equals("NIGHT") && !cab.isNightServiceAllowed()) {
                System.out.printf("%s: night service not available\n", cab.getType());
            } else {
                double fare = cab.calculateFare();
                totalFare += fare;
                System.out.printf("%s: %.2f\n", cab.getType(), fare);
            }
        }

        System.out.printf("Total: %.2f\n", totalFare);
        scanner.close();
    }
}

