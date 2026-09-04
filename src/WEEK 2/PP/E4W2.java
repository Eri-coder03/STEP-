import java.util.Scanner;

public class E4W2 {

    public static String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedPhone = new StringBuilder();

        maskedPhone.append("XXXXXX");

        maskedPhone.append("-");

        maskedPhone.append(phone.substring(6));

        return maskedPhone.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        String result = maskPhoneNumber(phone);

        System.out.println(result);

        sc.close();
    }
}