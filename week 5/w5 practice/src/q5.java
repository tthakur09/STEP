import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q5{

    public static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;
        private final double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;

            this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Sort in descending order of composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }


    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }


    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }


    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> qualifiedList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                qualifiedList.add(c);
            }
        }

        Candidate[] shortlisted = qualifiedList.toArray(new Candidate[0]);


        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (")
                    .append(String.format("%.1f", shortlisted[i].getCompositeScore()))
                    .append(")");

            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = new Candidate[]{
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        String leaderboard = shortlistAndRank(batch);
        System.out.println(leaderboard);
    }
}
