class Course1 {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course1(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course1(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

public class E3W6 {
    public static void main(String[] args) {

        Course1 c1 = new Course1(
                "21CSC201J",
                "Data Structures",
                4
        );

        Course1 c2 = new Course1(
                "21CSC205L",
                "DSA Lab",
                3,
                1
        );

        System.out.println(c1.code + " total credits: "
                + c1.totalCredits());

        System.out.println(c2.code + " total credits: "
                + c2.totalCredits());
    }
}
