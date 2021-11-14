package JavaLabs.AccountantBot;

public class Accountant {
    public static String paySalary(Employee employee) {
        return switch (employee.getRole()) {
            case EXECUTIVE -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Администратор "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " зарплату в размере " + Accountant.executiveSalary + " рублей";
            case MANAGER -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Менеджер "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " зарплату в размере " + Accountant.managerSalary + " рублей";
            case STAFF -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Сотрудник "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " зарплату в размере " + Accountant.staffSalary + " рублей";
        };
    }

    public static String payPremium(Employee employee) {
        return switch (employee.getRole()) {
            case EXECUTIVE -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Администратор "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " премию в размере " + 0.3 * Accountant.executiveSalary + " рублей";
            case MANAGER -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Менеджер "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " премию в размере " + 0.2 * Accountant.managerSalary + " рублей";
            case STAFF -> (employee.getGender() == Employee.Gender.FEMALE ? "Работница " : "Работник ")
                    + employee.getGivenName() + " " + employee.getSurName()
                    + " с ролью Сотрудник "
                    + (employee.getGender() == Employee.Gender.FEMALE ? "получила" : "получил")
                    + " премию в размере " + 0.1 * Accountant.staffSalary + " рублей";
        };
    }

    private static final double executiveSalary = 150000;
    private static final double managerSalary = 70000;
    private static final double staffSalary = 40000;
}
