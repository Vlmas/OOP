package lab3.sorting;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private int second;

    public Time() {}

    public Time(int hour, int minute, int second) {
        if (hour <= 24 && hour >= 0 && minute >= 0 && minute <= 60 && second >= 0 && second <= 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            throw new IllegalArgumentException("Wrong values!");
        }
    }

    public String toStandard() {
        String result = "";
        int hourValue = hour;
        boolean isPm = false;

        if (hour >= 12) {
            isPm = true;
            hourValue -= 12;
        }

        if (hourValue < 10) {
            result += "0";
        }
        result += Integer.toString(hourValue);
        result += ":";

        if (minute < 10) {
            result += "0";
        }
        result += Integer.toString(minute);
        result += ":";

        if (second < 10) {
            result += "0";
        }
        result += Integer.toString(second);

        if (isPm) {
            result += " PM";
        } else {
            result += " AM";
        }

        return result;
    }

    public String toUniversal() {
        String result = "";

        if (hour < 10) {
            result += "0";
        }
        result += Integer.toString(hour);
        result += ":";

        if (minute < 10) {
            result += "0";
        }
        result += Integer.toString(minute);
        result += ":";

        if (second < 10) {
            result += "0";
        }
        result += Integer.toString(second);

        return result;
    }

    public void add(Time time) {
        if (time.second + this.second > 60) {
            this.second = this.second + time.second - 60;
            this.minute++;
        } else {
            this.second += time.second;
        }

        if (time.minute + this.minute > 60) {
            this.minute = this.minute + time.minute - 60;
            this.hour++;
        } else {
            this.minute += time.minute;
        }

        if (time.hour + this.hour > 24) {
            this.hour = this.hour + time.hour - 24;
        } else {
            this.hour += time.hour;
        }
    }

    public String toString() {
        return this.toUniversal();
    }

    @Override
    public int compareTo(Time o) {
        if (hour == o.hour) {
            if (minute == o.minute) {
                if (second == o.second) {
                    return 0;
                }
                return (second > o.second) ? 1 : -1;
            }
            return (minute > o.minute) ? 1 : -1;
        }
        return (hour > o.hour) ? 1 : -1;
    }
}