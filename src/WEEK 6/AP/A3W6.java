class Employee1 {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee1(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee1(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }
}

public class A3W6 {
    public static void main(String[] args) {

        Employee1 e1 = new Employee1("E-101", "Divya", 65000);
        Employee1 e2 = new Employee1("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();
    }
}