import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        line = line.replace("[", "").replace("]", "");

        if (line.isEmpty()) {
            System.out.println("Even: 0");
            System.out.println("Odd: 0");
            scanner.close();
            return;
        }

        String[] tokens = line.split("[,\\s]+");
        int evenCount = 0;
        int oddCount = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);

        scanner.close();
    }
}