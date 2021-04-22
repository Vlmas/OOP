package lab3.bigtask;

import java.util.Date;
import java.util.Vector;

public class Tester {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e1 = new Employee("A", 500000, new Date(), "abcd");
        Employee e2 = new Employee("B", 600000, new Date(), "abcd");
        Employee e3 = new Employee("C", 700000, new Date(), "abcd");
        Employee e4 = new Employee("D", 300000, new Date(), "abcd");
        Employee e5 = new Employee("E", 500000, new Date(), "abcd");
        System.out.println("Test of compareTo():");
        System.out.println(e1.compareTo(e4));
        System.out.println(e1.compareTo(e5));
        System.out.println(e1.compareTo(e2));

        System.out.println("--------------------\nTest of clone():\n");

        Employee e6 = (Employee) e5.clone();
        System.out.println(e5);
        System.out.println(e6);
        e5.setSalary(500010);
        System.out.println(e5);
        System.out.println(e6);

        System.out.println("--------------------\nTest of equals() and manager's compareTo():\n");

        Vector<Employee> employees = new Vector<>();
        employees.add(e1); employees.add(e3); employees.add(e2); employees.add(e5); employees.add(e4); employees.add(e6);

        Manager m1 = new Manager("M", 500000, new Date(), "abc", employees, 1);
        Manager m2 = new Manager("M", 520000, new Date(), "abc", employees, 1);
        Manager m3 = new Manager("M", 500000, new Date(), "abc", employees, 1);

        System.out.println(m1.equals(m2));
        System.out.println(m1.equals((m3)));

        for(int i = 0; i < employees.size(); i++) {
            for(int j = 0; j < employees.size(); j++) {
                int result = m1.getEmployees().get(i).compareTo(m1.getEmployees().get(j));
                if(result == 1) {
                    System.out.print("Employee " + m1.getEmployees().get(i).getName() + " has more salary than " + m1.getEmployees().get(j).getName());
                    System.out.println(" (" + m1.getEmployees().get(i).getSalary() + ", " + m1.getEmployees().get(j).getSalary() + ")");
                }
                else if(result == 0) {
                    System.out.print("Employee " + m1.getEmployees().get(i).getName() + " has the same salary as " + m1.getEmployees().get(j).getName());
                    System.out.println(" (" + m1.getEmployees().get(i).getSalary() + ", " + m1.getEmployees().get(j).getSalary() + ")");
                }
            }
        }

        System.out.println("--------------------\nSorting by name:\n");
        employees.sort(new NameComparator());

        for(Employee employee : employees) {
            System.out.print(employee.getName() + " ");
        }
    }
}