package pack;

import java.util.Scanner;

public class Analyzer {
    private final Data data;

    public Analyzer(Data data) {
        this.data=data;
    }

    public void analyze() {
        Scanner scanner=new Scanner(System.in);
        String numWrap;
        double num;

        while(true) {
            System.out.print("Enter number (Q to quit): ");
            numWrap=scanner.nextLine();

            if(numWrap.equals("Q")) {
                System.out.println("Average = "+data.getAverage());
                System.out.print("Maximum = "+data.getMaximum());
                break;
            } else {
                num=Double.parseDouble(numWrap);
                data.add(num);
            }
        }
    }
}