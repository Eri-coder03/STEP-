import java.util.Scanner;

interface Payment {
    double calculateAmount();
    String getType();
}

class CardPayment implements Payment {
    double amount;

    CardPayment(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    double amount;

    WalletPayment(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer implements Payment {
    double amount;

    BankTransfer(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class E1W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransfer(amount);
            }

            double result = payment.calculateAmount();

            System.out.printf("%s: %.2f%n", payment.getType(), result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
