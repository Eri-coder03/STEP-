import java.util.Scanner;
import java.math.BigInteger;

public class E5W10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger number = sc.nextBigInteger();
        BigInteger reverse = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;

        while (number.signum() > 0) {
            BigInteger digit = number.remainder(BigInteger.TEN);
            sum = sum.add(digit);
            reverse = reverse.multiply(BigInteger.TEN).add(digit);
            number = number.divide(BigInteger.TEN);
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        sc.close();
    }
}
