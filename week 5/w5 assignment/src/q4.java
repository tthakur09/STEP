import java.util.Scanner;

public class q4 {


    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }


    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            sb.append("Match ").append(i).append(": ").append(status);

            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = scanner.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {
            System.out.print("Enter number of overs for Match " + i + ": ");
            int overs = scanner.nextInt();
            runsPerOver[i] = new int[overs];

            System.out.print("Enter runs per over for Match " + i + " separated by space: ");
            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        String result = classifyMatches(runsPerOver, threshold);
        System.out.println(result);

        scanner.close();
    }
}
