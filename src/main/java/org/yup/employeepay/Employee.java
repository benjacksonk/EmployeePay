package org.yup.employeepay;

public class Employee {

    int employeeID;
    String name;
    float hoursWorked;
    float payRate;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(int employeeID, String name, float hoursWorked, float payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float calculateGrossPay() {
        return payRate * hoursWorked;
    }

    public String payPeriodInfo() {
        return String.format(
                "Employee %d: %s has a gross pay of: $%.2f\n",
                this.getEmployeeID(),
                this.getName(),
                this.calculateGrossPay()
        );
    }

}
