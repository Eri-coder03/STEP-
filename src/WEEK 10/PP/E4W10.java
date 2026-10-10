import java.util.Arrays;
import java.util.Scanner;

public class E4W10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();
        String[] values = line.isEmpty()
                ? new String[0] : line.split("\\s+");

        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++)
            numbers[i] = Integer.parseInt(values[i]);

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(numbers));
        sc.close();
    }
}