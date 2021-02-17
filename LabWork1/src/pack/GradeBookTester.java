package pack;

import java.util.Scanner;
import java.util.Vector;

public class GradeBookTester {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Vector<Student> students=new Vector<>();
        students.add(new Student("A","1"));
        students.add(new Student("B","4"));
        students.add(new Student("C","2"));
        students.add(new Student("D","87"));
        students.add(new Student("E","5"));
        students.add(new Student("F","6"));
        students.add(new Student("G","7"));
        students.add(new Student("H","8"));
        students.add(new Student("I","9"));
        students.add(new Student("J","10"));

        Course course=new Course("CS101 OOP","OOP developing course",3,new Course("PP1","pp1",4));

        GradeBook gradeBook=new GradeBook(course,students);

        System.out.println("Please, input grades for students:");

        for(int i=0;i<gradeBook.getStudentsCount();i++) {
            System.out.print("Student "+gradeBook.getStudentAt(i).getName()+": ");
            gradeBook.getStudentAt(i).setGrade(scanner.nextInt());
        }

        System.out.println(gradeBook.displayMessage());
        gradeBook.displayGradeReport();
    }
}