package JavaLabs.AccountantBot;

public class EmployeeBuilder {

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Employee.Gender gender) {
        this.gender = gender;
    }

    public void setRole(Employee.Role role) {
        this.role = role;
    }

    public void setDept(Employee.Dept dept) {
        this.dept = dept;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Employee getResult() {
        return new Employee(this.givenName, this.surName, this.age,
                this.gender, this.role, this.dept, this.eMail, this.phone,
                this.address, this.city, this.state, this.stateCode);
    }

    private String givenName;
    private String surName;
    private int age;
    private Employee.Gender gender;
    private Employee.Role role;
    private Employee.Dept dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String stateCode;
}
