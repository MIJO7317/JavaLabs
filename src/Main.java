import JavaLabs.AccountantBot.Employee;
import JavaLabs.AccountantBot.Example;

public class Main
{
    public static void main(String[] args) {
        Example.printEmployees();
        System.out.println();
        Example.payPremiumWomen();
        System.out.println();
        Example.paySalaryFromDept(Employee.Dept.IT);
        System.out.println();
        Example.payPremiumOverThirtyFromDept(Employee.Dept.RESEARCH_AND_DEVELOPMENT);
        System.out.println();
        Example.paySalaryManagers();
        System.out.println();
        Example.payPremiumStaff();
        System.out.println();

        Example.exampleConsumer();
        Example.exampleFunction();
        Example.exampleSupplier();
        Example.exampleBiPredicate();
    }
}
