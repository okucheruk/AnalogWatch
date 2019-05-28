package io.javaclasses.analogwatch;

public final class Time {

    private final int hour;

    private final int minute;

    public Time() {
        this(0, 0);
    }

    private Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time withHour(int newhour) {
        return new Time(newhour, this.minute);
    }

    public Time withMinute(int newminute) {
        return new Time(this.hour, newminute);
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minute);
    }

    public static void main(String[] args) {

        System.out.println(new Time().withHour(5).withMinute(55));
    }

}
