import java.util.Scanner;

public class q3 {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;

        int effectiveK = (int) (k % n);
        if (effectiveK == 0) return names;


        reverse(names, 0, n - 1);
        reverse(names, 0, effectiveK - 1);
        reverse(names, effectiveK, n - 1);

        return names;
    }

    private static void reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        long k = 0;

        int kIdx = line.indexOf("k =");
        if (kIdx == -1) {
            kIdx = line.indexOf("k=");
        }

        String namesPart = line;
        if (kIdx != -1) {
            namesPart = line.substring(0, kIdx);
            String kPart = line.substring(kIdx);

            if (kPart.contains("//")) {
                kPart = kPart.substring(0, kPart.indexOf("//"));
            }
            String[] kv = kPart.split("=");
            if (kv.length >= 2) {
                k = Long.parseLong(kv[1].trim());
            }
        }

        int startBracket = namesPart.indexOf('[');
        int endBracket = namesPart.indexOf(']');
        if (startBracket == -1 || endBracket == -1) {
            scanner.close();
            return;
        }

        String inner = namesPart.substring(startBracket + 1, endBracket).trim();
        if (inner.isEmpty()) {
            System.out.println("[]");
            scanner.close();
            return;
        }

        String[] tokens = inner.split("[,\\s]+");


        if (kIdx == -1 && scanner.hasNextLong()) {
            k = scanner.nextLong();
        }

        rotateRoster(tokens, k);

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tokens.length; i++) {
            sb.append(tokens[i]);
            if (i < tokens.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb.toString());
        scanner.close();
    }
}
