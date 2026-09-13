import java.util.Scanner;

public class q5 {


    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        char[] reversedChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversedChars[i] = chars[chars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}
