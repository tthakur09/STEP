import java.util.Scanner;

public class q4{


    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }


    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            sb.append("Row ").append(i).append(": ").append(zone);

            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();

        int[][] seatingScores = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            System.out.print("Enter number of scores in Row " + i + ": ");
            int cols = scanner.nextInt();
            seatingScores[i] = new int[cols];

            System.out.print("Enter scores for Row " + i + " separated by space: ");
            for (int j = 0; j < cols; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        String result = classifyRows(seatingScores, threshold);
        System.out.println(result);

        scanner.close();
    }
}
