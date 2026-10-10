import java.util.Scanner;

public class q1 {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        line = line.replace("[", "").replace("]", "").trim();

        if (line.isEmpty()) {
            System.out.println(-1);
            scanner.close();
            return;
        }

        String[] tokens = line.split("[,\\s]+");
        int[] scores = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            scores[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(secondHighest(scores));
        scanner.close();
    }
}
