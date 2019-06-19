package io.javaclasses.analogwatch;

public class AnalogWatchUtils {

    /**
     * Returns angle between hour and minute hands of specified time.
     *
     * @param time
     *         Time.
     * @return Angle between hour and minute hands
     */
    public double handsGraduationDiff(Time time) {

        MovementEngine movementEngine =
                new MovementEngine();

        double absoluteAngle = Math.abs(movementEngine.hourHandGraduation(time) -
                                                movementEngine.minuteHandGraduation(time));

        if (absoluteAngle < 180) {

            return absoluteAngle;

        } else {

            return 360 - absoluteAngle;
        }
    }

}
