package pack;

public class Student {
    private String name;
    private String id;
    private int yearOfStudy;
    private int grade;

    public Student() {}

    public Student(String name,String id) {
        this.name=name;
        this.id=id;
        this.yearOfStudy=1;
    }

    public Student(String name,String id,int grade) {
        this(name,id);
        this.grade=grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade=grade;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getId() {
        return this.id;
    }

    public void incrementYearOfStudy() {
        yearOfStudy++;
    }

    public String toString() {
        return "Hey, my name is "+name+" and I'm at "+yearOfStudy+" year of study!";
    }
}