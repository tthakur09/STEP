import java.util.Random;

public class q3 {


    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }


    public static void printWellnessReport(double[] heights, double[] weights) {
        int n = heights.length;
        double[] bmis = new double[n];
        String[] statuses = new String[n];


        for (int i = 0; i < n; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            statuses[i] = getBmiStatus(bmis[i]);
        }


        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d — Height: %.2f m, Weight: %.2f kg -> BMI: %.2f | Status: %s%n",
                    i + 1, heights[i], weights[i], bmis[i], statuses[i]);
        }


        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-8s | %-11s | %-11s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s | %-11.2f | %-11.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {

        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random rand = new Random();

        heights[0] = 1.75;
        weights[0] = 70.0;

        heights[1] = 1.60;
        weights[1] = 90.0;


        for (int i = 2; i < teamSize; i++) {
            heights[i] = 1.50 + (rand.nextDouble() * (1.95 - 1.50));
            weights[i] = 45.0 + (rand.nextDouble() * (110.0 - 45.0));
        }

        printWellnessReport(heights, weights);
    }
}