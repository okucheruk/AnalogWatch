package io.javaclasses.analogwatch;

import com.google.common.testing.NullPointerTester;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AnalogWatchUtilsTest {

    @ParameterizedTest
    @MethodSource("provideTimeAndAngle")
    void testFailsIfHandsGraduationDiffIncorrect(Time time, double angle) {

        assertEquals(angle,
                     new AnalogWatchUtils().handsGraduationDiff(time),
                     "Angle between hour and minute hands is incorrect.");
    }

    private static Stream<Arguments> provideTimeAndAngle()
            throws InvalidTimeException {

        return Stream.of(
                Arguments.of(new Time().withHour(12)
                                       .withMinute(0), 0),
                Arguments.of(new Time().withHour(3)
                                       .withMinute(0), 90),
                Arguments.of(new Time().withHour(6)
                                       .withMinute(0), 180),
                Arguments.of(new Time().withHour(9)
                                       .withMinute(0), 90),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(1), 5.5),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(2), 11.0)
        );
    }

    @Test
    void testFailsIfCheckNotNullBroken() {

        try {

            //noinspection ConstantConditions
            new AnalogWatchUtils().handsGraduationDiff(null);

            fail("AnalogWatchUtils do not throws NullPointerException.");

        } catch (NullPointerException npe) {

            assertEquals("Time must be specified!",
                         npe.getMessage(),
                         "Exception message is incorrect.");
        }
    }

    @Test
    void testFailsIfAnalogWatchUtilsThrowsNPE() {

        //noinspection UnstableApiUsage
        NullPointerTester tester = new NullPointerTester();

        tester.testAllPublicConstructors(AnalogWatchUtils.class);
        tester.testAllPublicInstanceMethods(new AnalogWatchUtils());
    }

}
