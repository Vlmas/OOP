package lab3.sorting;

import lab3.bigtask.*;

import java.util.Date;
import java.util.Vector;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Chocolates:");

        Chocolate c1 = new Chocolate(100, "Snickers");
        Chocolate c2 = new Chocolate(80, "Milka");
        Chocolate c3 = new Chocolate(500, "KitKat");
        Chocolate c4 = new Chocolate(150, "Mars");
        Chocolate c5 = new Chocolate(100, "Twix");
        Chocolate c6 = new Chocolate(400, "AlpenGold");

        Chocolate[] chocolates = {c1, c2, c3, c4, c5, c6};

        //Sort.quickSort(chocolates, 0, chocolates.length - 1);
        Sort.insertionSort(chocolates);

        for(Chocolate chocolate : chocolates) {
            System.out.println(chocolate);
        }

        System.out.println("\nTimes:");

        Time t1 = new Time(17, 0, 0);
        Time t2 = new Time(22, 59, 59);
        Time t3 = new Time(21, 49, 59);
        Time t4 = new Time(20, 50, 3);
        Time t5 = new Time(20, 50, 3);

        Time[] times = {t1, t2, t3, t4, t5};

        //Sort.quickSort(times, 0, times.length - 1);
        Sort.insertionSort(times);

        for(Time time : times) {
            System.out.println(time);
        }

        System.out.println("\nEmployees:");

        Employee e1 = new Employee("A", 500000, new Date(), "abc");
        Employee e2 = new Employee("B", 600000, new Date(), "abc");
        Employee e3 = new Employee("C", 200000, new Date(), "abc");
        Employee e4 = new Employee("D", 300000, new Date(), "abc");
        Employee e5 = new Employee("E", 100000, new Date(), "abc");

        Employee[] employees = {e1, e2, e3, e4, e5};

        //Sort.quickSort(employees, 0, employees.length - 1);
        Sort.insertionSort(employees);

        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }
}