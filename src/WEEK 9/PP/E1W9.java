import java.util.*;

public class E1W9 {
    static abstract class Plot {
        String owner, shape;

        Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        abstract double area();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        double area() {
            return length * width;
        }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        double area() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            switch (type) {
                case "CIRCLE":
                    plots[i] = new Circle(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plots[i] = new Rectangle(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plots[i] = new Triangle(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape");
            }
        }

        double total = 0;

        for (Plot plot : plots) {
            double area = plot.area();
            total += area;
            System.out.printf(Locale.US, "%s (%s): %.2f%n",
                    plot.owner, plot.shape, area);
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
        sc.close();
    }
}
