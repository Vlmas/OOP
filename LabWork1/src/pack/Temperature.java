package pack;

public class Temperature {
    private double value;
    private char scale;

    public Temperature() {
        this.scale='C';
    }

    public Temperature(double value) {
        this();
        this.value=value;
    }

    public Temperature(char scale) {
        this.scale=scale;
    }

    public Temperature(double value,char scale) {
        this.value=value;
        this.scale=scale;
    }

    public double getValueInCelsius() {
        return (scale=='C')?value:(value-32)*((double)5/9);
    }

    public double getValueInFahrenheit() {
        return (scale=='F')?value:(value*((double)9/5)+32);
    }

    public char getScale() {
        return this.scale;
    }

    public void setValue(double value) {
        this.value=value;
    }

    public void setScale(char scale) {
        this.scale=scale;
    }

    public void setValueAndScale(double value,char scale) {
        setValue(value);
        setScale(scale);
    }
}