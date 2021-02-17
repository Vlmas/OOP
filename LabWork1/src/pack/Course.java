package pack;

import java.util.*;

public class Course {
    private String name;
    private String description;
    private int numberOfCredits;
    private Vector<Course> prerequisites;

    public Course() {}

    public Course(String name,String description,int numberOfCredits) {
        this.name=name;
        this.description=description;
        this.numberOfCredits=numberOfCredits;
    }

    public Course(String name,String description,int numberOfCredits,Course prerequisite) {
        this(name,description,numberOfCredits);
        this.prerequisites=new Vector<>();
        this.prerequisites.add(prerequisite);
    }

    public Course(String name,String description,int numberOfCredits,Course firstPrerequisite,Course secondPrerequisite) {
        this(name,description,numberOfCredits,firstPrerequisite);
        this.prerequisites.add(secondPrerequisite);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getNumberOfCredits() {
        return this.numberOfCredits;
    }

    public Vector<Course> getPrerequisites() {
        return this.prerequisites;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits=numberOfCredits;
    }

    public void setPrerequisites(Vector<Course> prerequisites) {
        this.prerequisites.clear();
        this.prerequisites.addAll(prerequisites);
    }

    public void addPrerequisite(Course prerequisite) {
        this.prerequisites.add(prerequisite);
    }

    public String toString() {
        return "I'm "+name+" course and I have such description: \""+description+"\"!";
    }
}