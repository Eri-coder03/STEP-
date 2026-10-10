import java.util.Locale;
import java.util.Scanner;

public class E10W10 {
    static class Student {
        private String name;
        private int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            double total = 0;

            for (int mark : marks)
                total += mark;

            return total / marks.length;
        }

        char grade(double average) {
            if (average >= 75)
                return 'B';
            else if (average >= 60)
                return 'C';
            else if (average >= 40)
                return 'D';
            else
                return 'F';
        }

        void display() {
            double avg = average();

            System.out.printf(Locale.US,
                    "%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(Locale.ROOT), avg, grade(avg));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine()
                    .replaceAll("[\\[\\],]", " ").trim();

            if (line.isEmpty())
                continue;

            String[] values = line.split("\\s+");
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++)
                marks[i] = Integer.parseInt(values[i + 1]);

            Student student = new Student(values[0], marks);
            student.display();
        }

        sc.close();
    }
}