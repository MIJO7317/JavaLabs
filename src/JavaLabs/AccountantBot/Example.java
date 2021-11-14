package JavaLabs.AccountantBot;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
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
        Consumer<String> printInfoByName;
        printInfoByName = (name) -> {
            System.out.println("Информация о первом человеке с именем " + name + ":");
            for (Employee employee : employees) {
                if (employee.getGivenName().equals(name)) {
                    System.out.println(employee);
                    return;
                }
            }
            System.out.println("Человек с таким именем не найден.\n");
        };
        printInfoByName.accept("Александр");
        printInfoByName.accept("Мария");
    }

    public static void exampleFunction() {
        //Get age of first person by name
        Function<String, Integer> getAgeByName;
        getAgeByName = (name) -> {
            for (Employee employee:employees) {
                if (employee.getGivenName().equals(name)) {
                    return employee.getAge();
                }
            }
            return null;
        };

        String name = "Кирилл";
        System.out.println("Возраст человека с именем " + name + ":");
        Integer age = getAgeByName.apply(name);
        if(age == null) {
            System.out.println("Человек с таким именем не найден.\n");
        } else {
            System.out.println("Возраст равен " + age + ".\n");
        }

        name = "Полина";
        System.out.println("Возраст человека с именем " + name + ":");
        age = getAgeByName.apply(name);
        if(age == null) {
            System.out.println("Человек с таким именем не найден.\n");
        } else {
            System.out.println("Возраст равен " + age + ".\n");
        }
    }

    public static void exampleSupplier() {
        //Get List of men
        Supplier<List<Employee>> getListOfMen;
        getListOfMen = () -> {
            List<Employee> employeeList = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getGender() == Employee.Gender.MALE) {
                    employeeList.add(employee);
                }
            }
            return employeeList;
        };
        System.out.println("Работники мужчины:");
        for (Employee employee : getListOfMen.get()) {
            System.out.println(employee.getGivenName() + " " + employee.getSurName());
        }
        System.out.println();
    }

    public static void exampleBiPredicate() {
        //Compare two Employees by age
        BiPredicate<Employee, Employee> compareEmployeesByAge;
        compareEmployeesByAge = (firstEmployee, secondEmployee) -> firstEmployee.getAge() == secondEmployee.getAge();
        SecureRandom secureRandom = new SecureRandom();
        Employee firstEmployee = employees.get(secureRandom.nextInt(employees.size()));
        Employee secondEmployee = employees.get(secureRandom.nextInt(employees.size()));
        System.out.println(firstEmployee.getGivenName() + " " + firstEmployee.getSurName()
                            + " ( возраст " + firstEmployee.getAge() + " ) "
                            + "и " + secondEmployee.getGivenName() + " " + secondEmployee.getSurName()
                            + " ( возраст " + secondEmployee.getAge() + " ) "
                            + (compareEmployeesByAge.test(firstEmployee, secondEmployee) ? "одногодки." : "не одногодки.") );
    }
}
