package JavaLabs.AccountantBot;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
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
        stream.filter(employee -> employee.getGender() == Gender.FEMALE).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryFromDept(Dept dept) {
        System.out.println("Выплата зарплаты работникам отдела "
                + (dept.equals(Dept.IT) ? "IT" :
                   dept.equals(Dept.FINANCE) ? "финансов" :
                   dept.equals(Dept.HUMAN_RESOURCES) ? "кадров" :
                   dept.equals(Dept.LOGISTICS) ? "логистики" :
                   dept.equals(Dept.MARKETING) ? "маркетинга" :
                   dept.equals(Dept.PURCHASING) ? "закупок" :
                   dept.equals(Dept.RESEARCH_AND_DEVELOPMENT) ? "исследования и развития" :
                   dept.equals(Dept.SALES) ? "продаж" : ""));
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumOverThirtyFromDept(Dept dept) {
        System.out.println("Выплата зарплаты работникам старше 30 лет из отдела "
                + (dept.equals(Dept.IT) ? "IT" :
                   dept.equals(Dept.FINANCE) ? "финансов" :
                   dept.equals(Dept.HUMAN_RESOURCES) ? "кадров" :
                   dept.equals(Dept.LOGISTICS) ? "логистики" :
                   dept.equals(Dept.MARKETING) ? "маркетинга" :
                   dept.equals(Dept.PURCHASING) ? "закупок" :
                   dept.equals(Dept.RESEARCH_AND_DEVELOPMENT) ? "исследования и развития" :
                   dept.equals(Dept.SALES) ? "продаж" : ""));
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getDept() == dept && employee.getAge() > 30).map(Accountant::payPremium).forEach(System.out::println);
    }

    public static void paySalaryManagers() {
        System.out.println("Выплата зарплаты менеджерам");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Role.MANAGER).map(Accountant::paySalary).forEach(System.out::println);
    }

    public static void payPremiumStaff() {
        System.out.println("Выплата премии сотрудникам");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getRole() == Role.STAFF).map(Accountant::payPremium).forEach(System.out::println);
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
                if (employee.getGender() == Gender.MALE) {
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

    //Use stream methods

    public static void exampleMap() {
        DecimalFormat dec = new DecimalFormat("#0");
        System.out.println("Примеры map:");
        Stream<Employee> stream = employees.stream();
        stream.map(employee -> employee.getGivenName() + " " + employee.getSurName()
                + " получает в год "
                + dec.format(employee.getSalary()*12) + " руб").forEach(System.out::println);
        stream = employees.stream();
        stream.map(employee -> employee.getGivenName() + " " + employee.getSurName()
                + " получает в день "
                + dec.format(employee.getSalary()/30) + " руб").forEach(System.out::println);
    }

    public static void examplePeek() {
        System.out.println("Примеры peek:");
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getAge() < 30).peek(employee ->
                System.out.println(employee.getGivenName() + " младше 30")).map(employee ->
                employee.getGivenName() + " имеет возраст " + employee.getAge()).forEach(System.out::println);
        stream = employees.stream();
        stream.filter(employee -> employee.getGender() == Gender.FEMALE).peek(employee ->
                System.out.println(employee.getGivenName() + " женщина")).map(employee ->
                employee.getGivenName() + " имеет возраст " + employee.getAge()).forEach(System.out::println);
    }

    public static void exampleFindFirst() {
        System.out.println("Пример findFirst:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Первый работник:"+ "\n" + stream.findFirst().orElse(null));
    }

    public static void exampleLazyOperations() {
        System.out.println("Пример skip:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Десятый работник:"+ "\n" + stream.skip(9).findFirst().orElse(null));
        System.out.println();
        System.out.println("Пример limit:");
        stream = employees.stream();
        System.out.println("Имена первых 10 работников:");
        stream.limit(10).map(Employee::getGivenName).forEach(System.out::println);
        System.out.println();
        System.out.println("Пример sorted:");
        stream = employees.stream();
        System.out.println("Пять самых молодых работников:");
        stream.sorted(Comparator.comparingInt(Employee::getAge)).limit(5).forEach(System.out::println);
    }

    public static void exampleMax() {
        System.out.println("Примеры max:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Возраст самого старого работника:"+ "\n"
                + stream.map(Employee::getAge).max(Integer::compare).orElse(null));
        stream = employees.stream();
        System.out.println("Самое длинное имя среди работников:"+ "\n"
                + stream.map(Employee::getGivenName).max(Comparator.comparingInt(String::length)).orElse(null));
    }

    public static void exampleMin() {
        System.out.println("Примеры min:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Возраст самого молодого работника:"+ "\n"
                + stream.map(Employee::getAge).min(Integer::compare).orElse(null));
        stream = employees.stream();
        System.out.println("Самое короткое имя среди работников:"+ "\n"
                + stream.map(Employee::getGivenName).min(Comparator.comparingInt(String::length)).orElse(null));
    }

    public static void exampleSum() {
        DecimalFormat dec = new DecimalFormat("#0");
        System.out.println("Примеры sum:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Суммарная зарплата работников: "
                + dec.format(stream.mapToDouble(Employee::getSalary).sum()));
        stream = employees.stream();
        System.out.println("Суммарная зарплата IT отдела: "
                + dec.format(stream.filter(employee ->
                employee.getDept() == Dept.IT).mapToDouble(Employee::getSalary).sum()));
    }

    public static void exampleAverage() {
        DecimalFormat dec = new DecimalFormat("#0");
        System.out.println("Примеры average:");
        Stream<Employee> stream = employees.stream();
        System.out.println("Средняя зарплата работников: "
                + dec.format(stream.mapToDouble(Employee::getSalary).average().orElse(0)));
        stream = employees.stream();
        System.out.println("Средняя зарплата IT отдела: "
                + dec.format(stream.filter(employee ->
                employee.getDept() == Dept.IT).mapToDouble(Employee::getSalary).average().orElse(0)));
    }
}
