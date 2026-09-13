import java.util.Scanner;

public class Q4 {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Error: Phone number must be exactly 10 digits.";
        }


        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Error: Phone number must contain only numeric digits.";
            }
        }


        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 10-digit phone number: ");
        String phone = scanner.nextLine();

        System.out.println(maskPhoneNumber(phone));

        scanner.close();
    }
}
