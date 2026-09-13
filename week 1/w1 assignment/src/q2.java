public class q2 {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchedCount = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            char c1 = original.charAt(i);
            char c2 = typed.charAt(i);

            if (c1 == c2) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {

                firstMismatchPos = i + 1;
                origMismatchChar = c1;
                typedMismatchChar = c2;
            }
        }

        double accuracy = ((double) matchedCount / totalChars) * 100.0;

        StringBuilder output = new StringBuilder();
        output.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedCount, totalChars, accuracy));

        if (firstMismatchPos == -1) {
            output.append("No Mismatches");
        } else {
            output.append(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, origMismatchChar, typedMismatchChar));
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        // Test Case 1
        checkTypingAccuracy("hello world", "hello world");

        // Test Case 2
        checkTypingAccuracy("coding", "coding");
    }
}