import java.util.Scanner;

interface Employee3 {
    double calculateBonus();
    String getName();
}

class FullTimeEmployee implements Employee3 {
    String name;
    double salary;

    FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements Employee3 {
    String name;
    double salary;

    PartTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class Intern implements Employee3 {
    String name;
    double salary;

    Intern(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }

    public String getName() {
        return name;
    }
}

public class A4W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee3 employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
