import java.util.*;

public class E4W9 {
    static abstract class Connection {
        double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double bill();
    }

    static class Home extends Connection {
        Home(double units) {
            super(units);
        }

        double bill() {
            return Math.min(units, 100) * 5
                    + Math.max(units - 100, 0) * 7;
        }
    }

    static class Shop extends Connection {
        Shop(double units) {
            super(units);
        }

        double bill() {
            return units * 8 + 100;
        }
    }

    static class Factory extends Connection {
        Factory(double units) {
            super(units);
        }

        double bill() {
            return Math.max(units * 6, 1000);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;
                case "SHOP":
                    connection = new Shop(units);
                    break;
                case "FACTORY":
                    connection = new Factory(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid connection");
            }

            double bill = connection.bill();
            total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
