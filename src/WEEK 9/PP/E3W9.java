import java.util.*;

public class E3W9 {
    static abstract class Item {
        String title;
        int daysLate;

        Item(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends Item {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return daysLate * 2.0;
        }
    }

    static class DVD extends Item {
        DVD(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return Math.min(daysLate * 5.0, 50);
        }
    }

    static class Magazine extends Item {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            Item item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;
                case "DVD":
                    item = new DVD(title, days);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }

            double fine = item.fine();
            total += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
        sc.close();
    }
}
