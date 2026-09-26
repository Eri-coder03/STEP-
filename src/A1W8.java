import java.util.Scanner;

interface Customer {
    double calculateAmount();
    String getType();
}

class Student2 implements Customer {
    double amount;

    Student2(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class Staff implements Customer {
    double amount;

    Staff(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class Guest implements Customer {
    double amount;

    Guest(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class A1W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student2(amount);
            } else if (type.equals("STAFF")) {
                customer = new Staff(amount);
            } else {
                customer = new Guest(amount);
            }

            double result = customer.calculateAmount();

            System.out.printf("%s: %.2f%n", customer.getType(), result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
