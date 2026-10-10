import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLong()) return;

        long num = scanner.nextLong();
        long temp = num;

        long sumOfDigits = 0;
        long reversedNum = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sumOfDigits += digit;
            reversedNum = reversedNum * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Reverse: " + reversedNum);

        scanner.close();
    }
}