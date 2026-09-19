public class E2W7 {
    static class Scorecard {
        private boolean[] results;
        private int count;
        private int score;

        Scorecard(int questions) {
            results = new boolean[questions];
            count = 0;
            score = 0;
        }

        public void recordAnswer(boolean correct) {
            if (count < results.length) {
                results[count] = correct;

                if (correct) {
                    score++;
                }

                count++;
            }
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
