import java.util.Scanner;

public class E3W10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();
        int even = 0, odd = 0;

        if (!line.isEmpty()) {
            for (String value : line.split("\\s+")) {
                int number = Integer.parseInt(value);

                if (number % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
