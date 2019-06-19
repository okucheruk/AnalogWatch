package io.javaclasses.analogwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TimeTest {

    @Test
    void testFailsIfConstructedTimeIncorrect() throws InvalidTimeException {

        assertEquals("12:00",
                     new Time().toString(),
                     "Constructed time is incorrect.");

        assertEquals("05:55",
                     new Time().withHour(5)
                               .withMinute(55)
                               .toString(),
                     "Constructed time is incorrect.");

        assertNotEquals("12:01",
                        new Time().toString(),
                        "Constructed time is incorrect.");
    }

    @Test
    void testFailsIfTimeHourBelowRangeDontThrowException() {

        try {

            new Time().withHour(0);

            fail("Time Hour don't throw exception.");

        } catch (InvalidTimeException e) {

            assertEquals("Hour value is out of range [1-12]!",
                         e.getMessage(),
                         "Exception message is incorrect.");
        }

    }

    @Test
    void testFailsIfTimeHourAboveRangeDontThrowException() {

        try {

            new Time().withHour(13);

            fail("Time Hour don't throw exception.");

        } catch (InvalidTimeException e) {

            assertEquals("Hour value is out of range [1-12]!",
                         e.getMessage(),
                         "Exception message is incorrect.");
        }

    }

    @Test
    void testFailsIfTimeMinuteBelowRangeDontThrowException() {

        try {

            new Time().withMinute(-1);

            fail("Time Minute do not throws exception.");

        } catch (InvalidTimeException e) {

            assertEquals("Minute value is out of range [0-59]!",
                         e.getMessage(),
                         "Exception message is incorrect.");
        }

    }

    @Test
    void testFailsIfTimeMinuteAboveRangeDontThrowException() {

        try {

            new Time().withMinute(60);

            fail("Time Minute do not throws exception.");

        } catch (InvalidTimeException e) {

            assertEquals("Minute value is out of range [0-59]!",
                         e.getMessage(),
                         "Exception message is incorrect.");
        }

    }

}
