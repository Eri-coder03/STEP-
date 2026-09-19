class Student1 {
    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student1(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class E5W6 {
    public static void main(String[] args) {

        Student1 s1 = new Student1("Ravi", 90);
        Student1 s2 = new Student1("Arjun", 85);

        Student1.printCollegeInfo();
    }
}
