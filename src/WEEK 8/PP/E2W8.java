import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    LocalDate calculateDueDate();
    String getTitle();
}

class Book1 implements LibraryItem {
    String title;
    LocalDate date;

    Book1(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public LocalDate calculateDueDate() {
        return date.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    String title;
    LocalDate date;

    DVD(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public LocalDate calculateDueDate() {
        return date.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    String title;
    LocalDate date;

    Magazine(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public LocalDate calculateDueDate() {
        return date.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class E2W8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LocalDate date = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            sc.nextLine();

            String title = sc.nextLine();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book1(title, date);
            } else if (type.equals("DVD")) {
                item = new DVD(title, date);
            } else {
                item = new Magazine(title, date);
            }

            System.out.println(item.getTitle() + ": " + item.calculateDueDate());
        }
    }
}
