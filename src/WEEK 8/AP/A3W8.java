import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    double units;

    SingleRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    double units;
    double occupants;

    SharedRoom(double units, double occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACAroom implements Room {
    double units;

    ACAroom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class A3W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                double occupants = sc.nextDouble();
                room = new SharedRoom(units, occupants);
            } else {
                room = new ACAroom(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
