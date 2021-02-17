package pack;

import java.util.Vector;

public class DragonLaunch {
    private Vector<Person> food;

    public DragonLaunch() {
        food=new Vector<>();
    }

    public void kidnap(Person p) {
        food.add(p);
    }

    public String willDragonEatOrNot() {
        int opened=0;
        int closed=0;

        if(food.elementAt(0).getGender()==Gender.FEMALE) {
            return "Dragon eats! Yahoo";
        } else {
            for(Person person : food) {
                if(closed>opened) {
                    return "Dragon eats! Yahoo";
                }

                if(person.getGender()==Gender.MALE) {
                    opened++;
                } else {
                    closed++;
                }
            }
        }

        return "No lunch for a dragon(((";
    }

    public String toString() {
        return "I'm a scary dragon and I have "+food.size()+" to eat today";
    }
}
