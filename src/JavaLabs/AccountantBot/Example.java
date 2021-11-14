package JavaLabs.AccountantBot;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Example {
    private static final ArrayList<Employee> employees = Employee.createShortList();

    public static void printEmployees() {
        int index = 1;
        for(Employee employee : employees) {
            System.out.println("Работник №" + index++ + "\n" + employee);
        }
    }

    //Use Streams:

    public static void payPremiumWomen() {
        System.out.println("Выплата премии женщинам");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getGender() == Employee.Gender.FEMALE).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryFromDept(Employee.Dept dept) {
        System.out.println("Выплата зарплаты работникам отдела "
                + (dept.equals(Employee.Dept.IT) ? "IT" :
                   dept.equals(Employee.Dept.FINANCE) ? "финансов" :
                   dept.equals(Employee.Dept.HUMAN_RESOURCES) ? "кадров" :
                   dept.equals(Employee.Dept.LOGISTICS) ? "логистики" :
                   dept.equals(Employee.Dept.MARKETING) ? "маркетинга" :
                   dept.equals(Employee.Dept.PURCHASING) ? "закупок" :
                   dept.equals(Employee.Dept.RESEARCH_AND_DEVELOPMENT) ? "исследования и развития" :
                   dept.equals(Employee.Dept.SALES) ? "продаж" : ""));
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumOverThirtyFromDept(Employee.Dept dept) {
        System.out.println("Выплата зарплаты работникам старше 30 лет из отдела "
                + (dept.equals(Employee.Dept.IT) ? "IT" :
                   dept.equals(Employee.Dept.FINANCE) ? "финансов" :
                   dept.equals(Employee.Dept.HUMAN_RESOURCES) ? "кадров" :
                   dept.equals(Employee.Dept.LOGISTICS) ? "логистики" :
                   dept.equals(Employee.Dept.MARKETING) ? "маркетинга" :
                   dept.equals(Employee.Dept.PURCHASING) ? "закупок" :
                   dept.equals(Employee.Dept.RESEARCH_AND_DEVELOPMENT) ? "исследования и развития" :
                   dept.equals(Employee.Dept.SALES) ? "продаж" : ""));
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept && employee.getAge() > 30).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryManagers() {
        System.out.println("Выплата зарплаты менеджерам");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Employee.Role.MANAGER).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumStaff() {
        System.out.println("Выплата премии сотрудникам");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Employee.Role.STAFF).map(Accountant::payPremium).forEach(System.out::println);
    }

    //Use Lambda Expressions

    public static void exampleConsumer() {
        //Print info about first person by name
        Consumer<String> consumer;
        consumer = (name) -> {
            System.out.println("Информация о первом человеке с именем " + name + ":");
            for (Employee employee:employees) {
                if (employee.getGivenName().equals(name)) {
                    System.out.println(employee);
                    return;
                }
            }
            System.out.println("Человек с таким именем не найден.\n");
        };
        consumer.accept("Александр");
        consumer.accept("Мария");
    }

    public static void exampleFunction() {
        //Get age by name
        Function<String, Integer> function;
        function = (name) -> {
            for (Employee employee:employees) {
                if (employee.getGivenName().equals(name)) {
                    return employee.getAge();
                }
            }
            return null;
        };
        String name = "Кирилл";
        System.out.println("Возраст человека с именем " + name + ":");
        Integer age = function.apply(name);
        if(age == null) {
            System.out.println("Человек с таким именем не найден.\n");
        } else {
            System.out.println("Возраст равен " + age + "\n");
        }
        name = "Полина";
        System.out.println("Возраст человека с именем " + name + ":");
        age = function.apply(name);
        if(age == null) {
            System.out.println("Человек с таким именем не найден.\n");
        } else {
            System.out.println("Возраст равен" + age + "\n");
        }
    }
}
