package lab3.bigtask;

import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Cloneable, Comparable<Employee> {
    private double salary;
    private Date hireDate;
    private String insuranceNumber;

    public Employee() {}

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, double salary, Date hireDate, String insuranceNumber) {
        this(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.insuranceNumber = insuranceNumber;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ("My name: " + getName() + ", salary: " + salary + ", hire date: " + hireDate + ", number: " + insuranceNumber);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return (
                Double.compare(
                employee.salary, salary) == 0 &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(insuranceNumber, employee.insuranceNumber
        ));
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, hireDate, insuranceNumber);
    }

    @Override
    public int compareTo(Employee o) {
        if(salary == o.salary) {
            return 0;
        }
        return ((salary > o.salary) ? 1 : -1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee e = (Employee) super.clone();
        e.hireDate = (Date) this.hireDate.clone();
        return e;
    }
}