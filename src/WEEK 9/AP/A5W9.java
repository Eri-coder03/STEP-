import java.util.*;

public class A5W9 {
    interface SaverMode {
        default double savedUnits(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        double hours;
        static final double COST_PER_UNIT = 8;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double power();

        final double units() {
            return power() * hours / 1000;
        }

        final double cost(double units) {
            return units * COST_PER_UNIT;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        double power() {
            return 150;
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }

        double power() {
            return 1500;
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        double power() {
            return 100;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        double power() {
            return 500;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        sc.nextLine();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }

            String[] input = line.split("\\s+");
            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2 && input[2].equals("SAVER");
            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance");
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.units();

            if (saver) {
                units = ((SaverMode) appliance).savedUnits(units);
            }

            double cost = appliance.cost(units);
            totalCost += cost;

            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
