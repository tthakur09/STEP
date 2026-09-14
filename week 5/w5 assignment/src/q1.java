import java.util.Arrays;
import java.util.Scanner;

public class q1 {


    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }


        playerScores[captainIndex] *= 2.0;


        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = scanner.nextInt();

        double[] scores = new double[n];
        System.out.print("Enter player scores separated by space: ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextDouble();
        }

        System.out.print("Enter Captain index: ");
        int captainIndex = scanner.nextInt();

        System.out.print("Enter Vice-Captain index: ");
        int viceCaptainIndex = scanner.nextInt();


        applyMultipliers(scores, captainIndex, viceCaptainIndex);


        System.out.println(Arrays.toString(scores));

        scanner.close();
    }
}