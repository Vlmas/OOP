package pack;

import java.util.HashMap;
import java.util.Vector;

public class GradeBook {
    private Course course;
    private Vector<Student> students;
    private HashMap<Integer,String> marksDistribution;

    public GradeBook() {}

    public GradeBook(Course course) {
        this.course=course;
        this.students=new Vector<>();
        this.marksDistribution=new HashMap<>();

        for(int i=0;i<10;i++) {
            marksDistribution.put(i,"");
        }
    }

    public GradeBook(Course course, Vector<Student> students) {
        this(course);
        this.students.addAll(students);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String displayMessage() {
        return "Welcome to the grade book for "+this.course.getName()+"!";
    }

    public void displayGradeReport() {
        int lowest=determineClassLowestIndex();
        int highest=determineClassHighestIndex();

        System.out.println("Class average is "+determineClassAverage()+". Lowest grade is "+students.get(lowest).getGrade()+" (Student "+students.get(lowest).getName()+", id: "+students.get(lowest).getId()+").");
        System.out.println("Highest grade is "+students.get(highest).getGrade()+" (Student "+students.get(highest).getName()+", id: "+students.get(highest).getId()+").");
        outputBarChart();
    }

    private void outputBarChart() {
        String numberOfHundreds="";

        for(Student student : students) {
            if(student.getGrade()==100) {
                numberOfHundreds+="*";
            } else {
                marksDistribution.replace((int) Math.floor((float) student.getGrade()/10),marksDistribution.get((int) Math.floor((float) student.getGrade()/10))+"*");
            }
        }

        System.out.println("Grades distribution: ");
        System.out.println("00-09: "+marksDistribution.get(0));
        System.out.println("10-19: "+marksDistribution.get(1));
        System.out.println("20-29: "+marksDistribution.get(2));
        System.out.println("30-39: "+marksDistribution.get(3));
        System.out.println("40-49: "+marksDistribution.get(4));
        System.out.println("50-59: "+marksDistribution.get(5));
        System.out.println("60-69: "+marksDistribution.get(6));
        System.out.println("70-79: "+marksDistribution.get(7));
        System.out.println("80-89: "+marksDistribution.get(8));
        System.out.println("90-99: "+marksDistribution.get(9));
        System.out.println("100: "+numberOfHundreds);
    }

    public float determineClassAverage() {
        float sumOfGrades=0;

        for(Student student : students) {
            sumOfGrades+=(float)student.getGrade();
        }

        return sumOfGrades/students.size();
    }

    public int determineClassLowestIndex() {
        int lowestIndex=0;
        int lowestGrade=students.firstElement().getGrade();

        for(Student st : students) {
            if(st.getGrade()<lowestGrade) {
                lowestGrade=st.getGrade();
                lowestIndex=students.indexOf(st);
            }
        }
        return lowestIndex;
    }

    public int determineClassHighestIndex() {
        int highestGrade=students.firstElement().getGrade();
        int highestIndex=0;

        for(Student student : students) {
            if(student.getGrade()>highestGrade) {
                highestGrade=student.getGrade();
                highestIndex=students.indexOf(student);
            }
        }

        return highestIndex;
    }

    public int getStudentsCount() {
        return this.students.size();
    }

    public Student getStudentAt(int i) {
        return this.students.elementAt(i);
    }

    public String toString() {
        return "This is the grade book for "+course.getName()+" class!";
    }
}