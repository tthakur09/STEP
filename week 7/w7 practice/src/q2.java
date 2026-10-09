public class q2{

    private final boolean[] results;
    private int count;


    public q2(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }


    public void recordAnswer(boolean isCorrect) {
        if (count < results.length) {
            results[count] = isCorrect;
            count++;
        }
    }


    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        q2 sc = new q2(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}
