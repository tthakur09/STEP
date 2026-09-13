import java.util.Scanner;

public class q3 {


    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter numbers separated by space: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean hasDuplicate = containsDuplicate(nums);

        if (hasDuplicate) {
            System.out.println("true (duplicate found)");
        } else {
            System.out.println("false (every value is distinct)");
        }

        scanner.close();
    }
}