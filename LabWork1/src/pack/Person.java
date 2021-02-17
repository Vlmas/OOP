package pack;

public class Person {
    private String name;
    private Gender gender;

    public Person() {}

    public Person(String name,Gender gender) {
        this.name=name;
        this.gender=gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "My name is "+name+" and I'm "+((gender==Gender.MALE)?"male":"female");
    }
}
