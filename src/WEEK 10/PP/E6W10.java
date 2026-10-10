import java.util.Scanner;

public class E6W10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            boolean prime = number > 1;

            for (int i = 2; i <= number / i && prime; i++) {
                if (number % i == 0)
                    prime = false;
            }

            System.out.println(number +
                    (prime ? " is prime" : " is not prime"));
        }

        sc.close();
    }
}
