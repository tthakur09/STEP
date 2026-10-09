import java.util.Scanner;

interface SaverCapable {
}

abstract class Appliance {
    protected double hours;
    protected boolean saverMode;

    public Appliance(double hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    public abstract double getPower();
    public abstract String getType();

    public boolean supportsSaverMode() {
        return this instanceof SaverCapable;
    }

    public double calculateUnits() {
        double units = (getPower() * hours) / 1000.0;
        if (saverMode) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverCapable {
    public AirConditioner(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 1500.0;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 100.0;
    }

    @Override
    public String getType() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverCapable {
    public WashingMachine(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    @Override
    public double getPower() {
        return 500.0;
    }

    @Override
    public String getType() {
        return "WASHER";
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        Appliance[] appliances = new Appliance[n];

        int count = 0;
        while (count < n && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaver = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

            switch (type) {
                case "FRIDGE":
                    appliances[count] = new Fridge(hours, isSaver);
                    break;
                case "AC":
                    appliances[count] = new AirConditioner(hours, isSaver);
                    break;
                case "TV":
                    appliances[count] = new TV(hours, isSaver);
                    break;
                case "WASHER":
                    appliances[count] = new WashingMachine(hours, isSaver);
                    break;
            }
            count++;
        }

        double totalCost = 0.0;
        for (int i = 0; i < count; i++) {
            Appliance app = appliances[i];
            if (app.saverMode && !app.supportsSaverMode()) {
                System.out.printf("%s: saver mode not supported\n", app.getType());
            } else {
                double units = app.calculateUnits();
                double cost = app.calculateCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getType(), units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}

