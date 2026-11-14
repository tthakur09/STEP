import java.util.Arrays;

public class q3 {

    static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;

            System.out.println("After placing " + key + ": "
                    + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] books = {30, 10, 40, 20};

        shelf(books);
    }
}
