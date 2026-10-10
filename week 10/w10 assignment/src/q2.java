import java.util.Scanner;

public class q2 {
    // Finds the first index where scores[i] >= low (lower bound)
    private static int findFirstIndex(int[] scores, int low) {
        int left = 0;
        int right = scores.length - 1;
        int result = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= low) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Finds the last index where scores[i] <= high (upper bound)
    private static int findLastIndex(int[] scores, int high) {
        int left = 0;
        int right = scores.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= high) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int first = findFirstIndex(scores, low);
        int last = findLastIndex(scores, high);

        if (first > last || first >= scores.length || last < 0) {
            return 0;
        }

        return last - first + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        int low = 0;
        int high = 0;

        // Parse low and high if on the same line or read from standard format
        int lowIdx = line.indexOf("low");
        int highIdx = line.indexOf("high");

        String arrayPart = line;
        if (lowIdx != -1) {
            arrayPart = line.substring(0, lowIdx);
            String rest = line.substring(lowIdx);
            String[] parts = rest.split(",");
            for (String part : parts) {
                String[] kv = part.split("=");
                if (kv.length == 2) {
                    String k = kv[0].trim();
                    int v = Integer.parseInt(kv[1].trim());
                    if (k.equals("low")) low = v;
                    if (k.equals("high")) high = v;
                }
            }
        }

        int startBracket = arrayPart.indexOf('[');
        int endBracket = arrayPart.indexOf(']');
        if (startBracket == -1 || endBracket == -1) {
            scanner.close();
            return;
        }

        String inner = arrayPart.substring(startBracket + 1, endBracket).trim();
        if (inner.isEmpty()) {
            System.out.println(0);
            scanner.close();
            return;
        }

        String[] tokens = inner.split("[,\\s]+");
        int[] scores = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            scores[i] = Integer.parseInt(tokens[i]);
        }

        // If low/high weren't on the line, read next tokens
        if (lowIdx == -1 && scanner.hasNextInt()) {
            low = scanner.nextInt();
            high = scanner.nextInt();
        }

        System.out.println(countInBand(scores, low, high));
        scanner.close();
    }
}