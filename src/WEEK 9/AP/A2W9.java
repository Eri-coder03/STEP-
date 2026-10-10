import java.util.*;

public class A2W9 {
    interface Insurable {
        double insurance();
    }

    static abstract class Parcel {
        double weight, declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double charge();
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) {
            super(weight, value);
        }

        double charge() {
            return 40 + weight * 10;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) {
            super(weight, value);
        }

        double charge() {
            return 80 + weight * 15;
        }

        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    static class Fragile extends Standard implements Insurable {
        Fragile(double weight, double value) {
            super(weight, value);
        }

        double charge() {
            return super.charge() + 50;
        }

        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }

            double charge = parcel.charge();
            double insurance = parcel instanceof Insurable
                    ? ((Insurable) parcel).insurance() : 0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
