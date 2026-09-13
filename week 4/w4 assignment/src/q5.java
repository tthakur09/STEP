import java.util.Scanner;

public class q5 {


    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;


            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {

                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter elements separated by space: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int minElement = findMin(nums);
        System.out.println("Minimum element: " + minElement);

        scanner.close();
    }
}