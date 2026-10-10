import java.util.*;

public class E5W9 {
    static abstract class Booking {
        static final double BOOKING_FEE = 50;
        double distance;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double fare();

        final double total() {
            return fare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {
        Bus(double distance) {
            super(distance);
        }

        double fare() {
            return distance * 2;
        }
    }

    static class Train extends Booking {
        Train(double distance) {
            super(distance);
        }

        double fare() {
            return distance * 1.5;
        }
    }

    static class Flight extends Booking {
        Flight(double distance) {
            super(distance);
        }

        double fare() {
            return 2500 + distance * 4;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;
                case "TRAIN":
                    booking = new Train(distance);
                    break;
                case "FLIGHT":
                    booking = new Flight(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    mode, booking.total());
        }

        sc.close();
    }
}
