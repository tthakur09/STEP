import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String lowerStudent = studentAnswer.toLowerCase();
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudent.contains(trimmedKw)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        Question[] questions = new Question[n];

        int count = 0;
        while (count < n && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace).trim();
            String rest = line.substring(firstSpace + 1).trim();

            List<String> quotedParts = new ArrayList<>();
            int idx = 0;
            while (idx < rest.length() && quotedParts.size() < 3) {
                int startQuote = rest.indexOf('"', idx);
                if (startQuote == -1) break;
                int endQuote = rest.indexOf('"', startQuote + 1);
                if (endQuote == -1) break;
                quotedParts.add(rest.substring(startQuote + 1, endQuote));
                idx = endQuote + 1;
            }

            int points = Integer.parseInt(rest.substring(idx).trim());

            String qText = quotedParts.get(0);
            String correctAns = quotedParts.get(1);
            String studentAns = quotedParts.get(2);

            switch (type) {
                case "MCQ":
                    questions[count] = new MCQQuestion(qText, correctAns, studentAns, points);
                    break;
                case "TF":
                    questions[count] = new TFQuestion(qText, correctAns, studentAns, points);
                    break;
                case "ESSAY":
                    questions[count] = new EssayQuestion(qText, correctAns, studentAns, points);
                    break;
            }
            count++;
        }

        double totalScore = 0.0;
        for (int i = 0; i < count; i++) {
            double score = questions[i].calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", questions[i].getType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}