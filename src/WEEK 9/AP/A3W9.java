import java.util.*;

public class A3W9 {
    interface BusUser {
        default double transportFee() {
            return 12000;
        }
    }

    static abstract class Student {
        String name;
        static final double NORMAL_TUITION = 40000;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();

        double extraFee() {
            return 0;
        }

        final double totalFee() {
            double transport = this instanceof BusUser
                    ? ((BusUser) this).transportFee() : 0;
            return tuition() + extraFee() + transport;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double tuition() {
            return NORMAL_TUITION;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double tuition() {
            return NORMAL_TUITION;
        }

        double extraFee() {
            return 60000;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        double tuition() {
            return NORMAL_TUITION / 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.totalFee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n",
                    student.name, fee);
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
        sc.close();
    }
}
