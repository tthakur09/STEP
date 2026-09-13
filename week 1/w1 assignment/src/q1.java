public class q1 {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyReported = true;
                    break;
                }
            }

            if (alreadyReported) {
                continue;
            }


            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.print("Duplicate seat no in hall 1: ");
        int[] hall1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(hall1);

        // Test Case 2
        System.out.print("Duplicate seat no in hall 2: ");

        int[] hall2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(hall2);
    }
}