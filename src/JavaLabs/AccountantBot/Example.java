package JavaLabs.AccountantBot;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Example {
    private static final ArrayList<Employee> employees = Employee.createShortList();

    public static void payPremiumWomen() {
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getGender() == Employee.Gender.FEMALE).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryFromDept(Employee.Dept dept) {
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumOverThirtyFromDept(Employee.Dept dept) {
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept && employee.getAge() > 30).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryManagers() {
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Employee.Role.MANAGER).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumStaff() {
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Employee.Role.STAFF).map(Accountant::payPremium).forEach(System.out::println);
    }
}
