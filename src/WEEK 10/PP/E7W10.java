import java.util.Scanner;
import java.math.BigInteger;

public class E7W10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            BigInteger factorial = BigInteger.ONE;

            for (long i = 2; i <= number; i++)
                factorial = factorial.multiply(BigInteger.valueOf(i));

            System.out.println(factorial);
        }

        sc.close();
    }
}
