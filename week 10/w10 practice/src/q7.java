import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
            System.out.println(fact);
        }
        scanner.close();
    }
}