package lab3.bigtask;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee {
    private Vector<Employee> employees;
    private int bonus;

    public Manager() {}

    public Manager(String name, double salary, Date hireDate, String insuranceNumber) {
        super(name, salary, hireDate, insuranceNumber);
    }

    public Manager(String name, double salary, Date hireDate, String insuranceNumber, Vector<Employee> employees, int bonus) {
        this(name, salary, hireDate, insuranceNumber);
        this.employees = employees;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", employees: " + employees.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        if(!super.equals(o)) {
            return false;
        }
        Manager manager = (Manager) o;
        return employees.equals(manager.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employees);
    }

    @Override
    public int compareTo(Employee o) {
        if(super.compareTo(o) == 0) {
            Manager m = (Manager) o;
            if(bonus == m.bonus) {
                return 0;
            }
            return ((bonus > m.bonus) ? 1 : -1);
        }
        return super.compareTo(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Manager m = (Manager) super.clone();
        m.bonus = bonus;
        return m;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Vector<Employee> getEmployees() {
        return employees;
    }

    public int getBonus() {
        return bonus;
    }
}