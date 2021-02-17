package pack;

import java.util.*;

public class Car {
    private long serialNumber;
    private double length;
    private double width;
    private double height;
    private double weight;

    private Body body;
    private Status status;
    private Brand brand;

    private final static HashSet<Long> serialNumbers;
    public static int carCount;
    private final static HashMap<String,String[]> brandModels;

    static {
        serialNumbers=new HashSet<>();
        brandModels=new HashMap<>();
        brandModels.put("Toyota",new String[] {"Yaris","Corolla","Camry","Avalon","Rav4","Land Cruiser"});
        brandModels.put("Lexus",new String[] {"IS","ES","GS","RC","LC","RX","GX","LX"});
    }

    {
        carCount++;
    }

    public Car() {}

    public Car(double length,double width,double height,double weight) {
        this.length=length;
        this.width=width;
        this.height=height;
        this.weight=weight;
    }

    public Car(double length,double width,double height,double weight,Body body,Status status, Brand brand,long serialNumber) {
        this(length,width,height,weight);
        this.body=body;
        this.status=status;
        this.brand=brand;

        if(existingSerialNumber(serialNumber)) {
            throw new IllegalArgumentException("You are committing a crime!");
        } else {
            this.serialNumber=serialNumber;
            serialNumbers.add(serialNumber);
        }
    }

    private boolean existingSerialNumber(int serialNumber) {
        return serialNumbers.contains((long)serialNumber);
    }

    private boolean existingSerialNumber(long serialNumber) {
        return serialNumbers.contains(serialNumber);
    }

    @Override
    public String toString() {
        return "Car "+this.brand+" has a serial number of "+this.serialNumber+" with weight "+this.weight+" and dimensions "+this.length+", "+this.width+", "+this.height;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public Body getBody() {
        return this.body;
    }

    public Status getStatus() {
        return this.status;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setStatus(Status status) {
        this.status=status;
    }
}