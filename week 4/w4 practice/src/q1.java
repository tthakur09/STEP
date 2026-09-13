import java.util.Scanner;

public class q1 {


    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter item prices separated by space: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int[] indices = twoSum(nums, target);

        if (indices.length == 2) {
            int i = indices[0];
            int j = indices[1];
            System.out.printf("[%d, %d] (nums[%d] + nums[%d] = %d + %d = %d)%n",
                    i, j, i, j, nums[i], nums[j], target);
        } else {
            System.out.println("No pair found.");
        }

        scanner.close();
    }
}