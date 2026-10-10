import java.util.*;

public class E2W9 {
    static abstract class Staff {
        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double pay();
    }

    static class FullTime extends Staff {
        double salary;

        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }

        double pay() {
            return salary;
        }
    }

    static class Hourly extends Staff {
        double hours, rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double pay() {
            return Math.min(hours, 40) * rate
                    + Math.max(hours - 40, 0) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double pay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;

            switch (type) {
                case "FULLTIME":
                    staff = new FullTime(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    staff = new Hourly(
                            name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    staff = new Intern(name, sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }

            double pay = staff.pay();
            total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", name, pay);
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
        sc.close();
    }
}