import java.time.LocalDate;
import java.util.Scanner;

interface Plan {
    LocalDate calculateRenewalDate();
    String getName();
}

class BasicPlan implements Plan {
    String name;
    LocalDate startDate;

    BasicPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }

    public String getName() {
        return name;
    }
}

class StandardPlan implements Plan {
    String name;
    LocalDate startDate;

    StandardPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }

    public String getName() {
        return name;
    }
}

class PremiumPlan implements Plan {
    String name;
    LocalDate startDate;

    PremiumPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }

    public String getName() {
        return name;
    }
}

public class A5W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(name, startDate);
            } else {
                plan = new PremiumPlan(name, startDate);
            }

            System.out.println(
                    plan.getName() + ": " + plan.calculateRenewalDate()
            );
        }
    }
}
