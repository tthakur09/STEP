import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q5 {
    public static int[] busiestRow(int[][] grid) {
        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
            }


            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRowIndex = i;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(" ");
        }

        String input = sb.toString().trim();
        int gridStart = input.indexOf("[[");
        int gridEnd = input.lastIndexOf("]]");

        if (gridStart == -1 || gridEnd == -1) {
            scanner.close();
            return;
        }

        String content = input.substring(gridStart + 1, gridEnd + 1).trim();
        List<int[]> rowList = new ArrayList<>();

        int idx = 0;
        while (idx < content.length()) {
            int start = content.indexOf('[', idx);
            if (start == -1) break;
            int end = content.indexOf(']', start);
            if (end == -1) break;

            String rowStr = content.substring(start + 1, end).trim();
            if (!rowStr.isEmpty()) {
                String[] tokens = rowStr.split("[,\\s]+");
                int[] row = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Integer.parseInt(tokens[i]);
                }
                rowList.add(row);
            }
            idx = end + 1;
        }

        int[][] grid = rowList.toArray(new int[0][]);
        int[] result = busiestRow(grid);

        System.out.printf("Row %d, Total %d\n", result[0], result[1]);
        scanner.close();
    }
}