import java.util.Scanner;

class Employee {
    String name;
    int age;
    long phNo;
    String address;
    double salary;

    void printSalary() {
        System.out.println("Salary: " + this.salary);
    }
}

class Officer extends Employee {
    String specialization;
    String department;

    Officer(String name, int age, long phNo, String address, double salary, String spec, String dep) {
        super.name = name;
        super.age = age;
        super.phNo = phNo;
        super.address = address;
        super.salary = salary;
        this.specialization = spec;
        this.department = dep;
    }
}

class Manager extends Employee {
    String specialization;
    String department;

    Manager(String name, int age, long phNo, String address, double salary, String spec, String dep) {
        super.name = name;
        super.age = age;
        super.phNo = phNo;
        super.address = address;
        super.salary = salary;
        this.specialization = spec;
        this.department = dep;
    }
}

public class Hier {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Officer
        System.out.println("Officer: ");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter specialization: ");
        String spec = sc.nextLine();
        System.out.print("Enter department: ");
        String dep = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter phone no: ");
        long phNo = sc.nextLong();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        Officer o1 = new Officer(name, age, phNo, address, salary, spec, dep);

        // Manager
        System.out.println("Manager: ");
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter specialization: ");
        spec = sc.nextLine();
        System.out.print("Enter department: ");
        dep = sc.nextLine();
        System.out.print("Enter address: ");
        address = sc.nextLine();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        System.out.print("Enter phone no: ");
        phNo = sc.nextLong();
        System.out.print("Enter salary: ");
        salary = sc.nextDouble();
        Manager m1 = new Manager(name, age, phNo, address, salary, spec, dep);

        System.out.println("OFFICER: Name: " + o1.name + ", Age: " + o1.age + ", phNo: " + o1.phNo +
                ", Address: " + o1.address + ", Salary: " + o1.salary + ", Specialization: " + o1.specialization +
                ", Department: " + o1.department);
        System.out.println("MANAGER: Name: " + m1.name + ", Age: " + m1.age + ", phNo: " + m1.phNo +
                ", Address: " + m1.address + ", Salary: " + m1.salary + ", Specialization: " + m1.specialization +
                ", Department: " + m1.department);
    }
}
