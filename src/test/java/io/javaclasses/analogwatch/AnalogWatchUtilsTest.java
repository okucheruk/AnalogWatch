package io.javaclasses.analogwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalogWatchUtilsTest {

    @Test
    void testFailsIfHandsGraduationDiffIncorrect() throws InvalidTimeException {

        Time time =
                new Time()
                        .withHour(6)
                        .withMinute(0);

        assertEquals(180,
                     new AnalogWatchUtils().handsGraduationDiff(time),
                     "Angle between hour and minute hands is incorrect.");
    }

}
