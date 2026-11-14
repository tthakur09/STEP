
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];
        double total = 0;
        int wettestDay = 0;
        int dryDays = 0;

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();

            total += rainfall[i];

            if (rainfall[i] == 0) {
                dryDays++;
            }

            if (rainfall[i] > rainfall[wettestDay]) {
                wettestDay = i;
            }
        }

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rainfall[i] + " ");
        }

        System.out.println();
        System.out.println("Total Rainfall: " + total + " mm");

        System.out.printf(java.util.Locale.US,
                "Average Rainfall: %.2f mm%n", total / 7);

        System.out.println("Wettest Day: Day "
                + (wettestDay + 1) + " ("
                + rainfall[wettestDay] + " mm)");

        System.out.println("Total Dry Days: " + dryDays);
        sc.close();
    }
}
