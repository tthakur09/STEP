import java.util.Scanner;

class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    public char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayResult() {
        System.out.printf("%s: Average %.1f, Grade %c\n",
                name.toUpperCase(), calculateAverage(), calculateGrade());
    }
}

public class q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');
            if (bracketStart == -1 || bracketEnd == -1) continue;

            String name = line.substring(0, bracketStart).trim();
            String marksStr = line.substring(bracketStart + 1, bracketEnd).trim();

            String[] tokens = marksStr.split("[,\\s]+");
            double[] marks = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                marks[i] = Double.parseDouble(tokens[i]);
            }

            Student student = new Student(name, marks);
            student.displayResult();
        }
        scanner.close();
    }
}