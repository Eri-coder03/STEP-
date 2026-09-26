import java.util.Scanner;

interface Question {
    double calculateScore();
    String getType();
}

class MCQ implements Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    MCQ(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (correctAnswer.equals(studentAnswer)) {
            return points;
        }
        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TF implements Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    TF(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (correctAnswer.equals(studentAnswer)) {
            return points;
        }
        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class Essay implements Question {
    String keywords;
    String studentAnswer;
    double points;

    Essay(String keywords, String studentAnswer, double points) {
        this.keywords = keywords;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        String answer = studentAnswer.toLowerCase();
        String[] words = keywords.toLowerCase().split(",");

        int count = 0;

        for (String word : words) {
            if (answer.contains(word.trim())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class E4W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            String questionText = sc.next();
            String correctAnswer = sc.next();
            String studentAnswer = sc.next();
            double points = sc.nextDouble();

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                question = new TF(correctAnswer, studentAnswer, points);
            } else {
                question = new Essay(correctAnswer, studentAnswer, points);
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", question.getType(), score);
            total += score;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
