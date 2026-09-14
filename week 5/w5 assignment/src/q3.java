import java.util.Scanner;

public class q3 {


    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "";
        }

        int min = scores[0];
        int max = scores[0];


        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.print("Enter scores separated by space: ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        String result = findMinMaxSpread(scores);
        System.out.println(result);

        scanner.close();
    }
}