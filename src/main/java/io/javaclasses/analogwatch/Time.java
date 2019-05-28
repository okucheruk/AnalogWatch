package io.javaclasses.analogwatch;

public final class Time {

    private final int hour;

    private final int minute;

    public Time() {
        this(12, 0);
    }

    private Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time withHour(int newhour) throws InvalidTimeException {

        if ((newhour > 12) || (newhour < 1)) {

            throw new InvalidTimeException("Hour value is out of boundaries!");
        }
        return new Time(newhour, this.minute);
    }

    public Time withMinute(int newminute) throws InvalidTimeException {

        if ((newminute > 59) || (newminute < 0)) {

            throw new InvalidTimeException("Minute value is out of boundaries!");
        }

        return new Time(this.hour, newminute);
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minute);
    }

    public static void main(String[] args) {

        try {

            Time time =
                    new Time()
                            .withHour(5)
                            .withMinute(55);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


/*
        Watch watch =
                new Watch().withTime()
*/

    }

}
