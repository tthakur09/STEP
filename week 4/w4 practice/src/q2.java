import java.util.Scanner;

public class q2 {


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;


        for (int i = 1; i < prices.length; i++) {
            int potentialProfit = prices[i] - minPrice;
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }


    public static void printTradeAnalysis(int[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("0 (prices only fall, so no trade is profitable)");
            return;
        }

        int minPrice = prices[0];
        int minDay = 1;

        int maxProfit = 0;
        int buyDay = 1;
        int sellDay = 1;
        int buyPrice = prices[0];
        int sellPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int potentialProfit = prices[i] - minPrice;

            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
                buyDay = minDay;
                sellDay = i + 1;
                buyPrice = minPrice;
                sellPrice = prices[i];
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minDay = i + 1;
            }
        }

        if (maxProfit > 0) {
            System.out.printf("%d (buy on day %d at price %d, sell on day %d at price %d)%n",
                    maxProfit, buyDay, buyPrice, sellDay, sellPrice);
        } else {
            System.out.println("0 (prices only fall, so no trade is profitable)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.print("Enter prices separated by space: ");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        printTradeAnalysis(prices);

        scanner.close();
    }
}