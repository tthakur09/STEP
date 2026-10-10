import java.util.Scanner;

public class q4{
    public static int[] attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        int startBracket = line.indexOf('[');
        int endBracket = line.indexOf(']');

        if (startBracket == -1 || endBracket == -1) {
            scanner.close();
            return;
        }

        String inner = line.substring(startBracket + 1, endBracket).trim();
        if (inner.isEmpty()) {
            System.out.println("Present: 0, Longest streak: 0");
            scanner.close();
            return;
        }

        String[] tokens = inner.split("[,\\s]+");
        int[] days = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            days[i] = Integer.parseInt(tokens[i]);
        }

        int[] result = attendanceSummary(days);
        System.out.printf("Present: %d, Longest streak: %d\n", result[0], result[1]);
        scanner.close();
    }
}
