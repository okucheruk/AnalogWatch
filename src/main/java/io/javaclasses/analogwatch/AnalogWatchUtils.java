package io.javaclasses.analogwatch;

import org.checkerframework.checker.nullness.qual.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class AnalogWatchUtils {

    /**
     * Returns angle between hour and minute hands of specified time.
     *
     * @param time
     *         Time.
     * @return Angle between hour and minute hands
     */
    public double handsGraduationDiff(@NonNull Time time) {

        checkNotNull(time, "Time must be specified!");

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
