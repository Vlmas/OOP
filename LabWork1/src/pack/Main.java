package pack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        //1
        /*
        Data data=new Data();
        Analyzer analyzer=new Analyzer(data);

        analyzer.analyze();
        */

        //2
        /*
        Car myCar=new Car(4850d,1850d,1550d,1500,Body.SEDAN,Status.ON_THE_RUN,Brand.TOYOTA,123456);
        //Car myNewCar=new Car(4850d,1850d,1550d,1500,Body.SEDAN,Status.ON_THE_RUN,Brand.TOYOTA,123456);

        System.out.println(Car.carCount);

        System.out.println(myCar.getBrand());
        System.out.println(myCar.getLength());
        System.out.println(myCar.getStatus());

        myCar.setStatus(Status.EMERGENCY);

        System.out.println(myCar.getStatus());
        System.out.println(myCar);
        */

        //3
        /*
        Temperature temperature=new Temperature();

        System.out.println(temperature.getValueInCelsius()+" "+temperature.getValueInFahrenheit());
        System.out.println(temperature.getScale());

        double value=input.nextDouble();
        input.nextLine();
        char scale=input.nextLine().charAt(0);

        Temperature newTemperature=new Temperature(value,scale);

        System.out.println(newTemperature.getValueInCelsius()+" "+newTemperature.getValueInFahrenheit());
        System.out.println(newTemperature.getScale());

        newTemperature.setScale('F');
        System.out.println(newTemperature.getValueInCelsius()+" "+newTemperature.getValueInFahrenheit());
        System.out.println(newTemperature.getScale());

        Temperature tempTemperature=new Temperature(scale);

        System.out.println(tempTemperature.getValueInCelsius()+" "+tempTemperature.getValueInFahrenheit());
        System.out.println(tempTemperature.getScale());
        */

        //5
        DragonLaunch scaryDragon=new DragonLaunch();
        String s=input.nextLine();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='B') {
                scaryDragon.kidnap(new Person("AAA",Gender.MALE));
            }
            else if(s.charAt(i)=='G') {
                scaryDragon.kidnap(new Person("AAA",Gender.FEMALE));
            }
        }

        System.out.println(scaryDragon.willDragonEatOrNot());
    }
}
