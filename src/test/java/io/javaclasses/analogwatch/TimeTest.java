package io.javaclasses.analogwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TimeTest {

    @Test
    void testFailIfConstructedTimeIncorrect() {

        assertEquals("00:00",
                     new Time().toString(),
                     "Constructed time is incorrect");

        assertEquals("05:55",
                     new Time().withHour(5).withMinute(55).toString(),
                     "Constructed time is incorrect");

        assertNotEquals("00:01",
                     new Time().toString(),
                     "Constructed time is incorrect");
    }

}
