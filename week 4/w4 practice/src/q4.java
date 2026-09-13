import java.util.Arrays;
import java.util.Scanner;

public class q4{


    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int p1 = 0;
        int p2 = 0;
        int k = 0;


        while (p1 < n1 && p2 < n2) {
            if (arr1[p1] <= arr2[p2]) {
                result[k++] = arr1[p1++];
            } else {
                result[k++] = arr2[p2++];
            }
        }


        while (p1 < n1) {
            result[k++] = arr1[p1++];
        }


        while (p2 < n2) {
            result[k++] = arr2[p2++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter size of first sorted array: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        if (n1 > 0) {
            System.out.print("Enter sorted elements for first array: ");
            for (int i = 0; i < n1; i++) {
                arr1[i] = scanner.nextInt();
            }
        }


        System.out.print("Enter size of second sorted array: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        if (n2 > 0) {
            System.out.print("Enter sorted elements for second array: ");
            for (int i = 0; i < n2; i++) {
                arr2[i] = scanner.nextInt();
            }
        }

        int[] merged = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(merged));

        scanner.close();
    }
}
