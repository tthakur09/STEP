import java.util.Scanner;

public class q2 {


    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }


        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        String[] playerNames = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter player " + (i + 1) + ": ");
            playerNames[i] = scanner.nextLine().trim();
        }

        String result = findDuplicatePick(playerNames);
        System.out.println(result);

        scanner.close();
    }
}
