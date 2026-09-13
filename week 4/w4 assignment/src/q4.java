import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q4 {


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;


        Map<Integer, Integer> prefixSumFreq = new HashMap<>();


        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentSum += num;


            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }


            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
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

        System.out.print("Enter target sum (k): ");
        int k = scanner.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Total Subarrays: " + result);

        scanner.close();
    }
}
