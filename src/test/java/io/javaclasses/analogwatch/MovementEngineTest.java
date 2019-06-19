/*
 * Copyright (C) 2019 Oleksii Kucheruk <oleksii.kucheruk@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.javaclasses.analogwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.testing.NullPointerTester;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MovementEngineTest {

    @ParameterizedTest
    @MethodSource("provideTimeAndHourHandGraduation")
    void testFailsIfHourHandGraduationIncorrect(Time time, double graduation) {

        assertEquals(graduation,
                     new MovementEngine().hourHandGraduation(time),
                     "Hour hand graduation is incorrect.");
    }

    private static Stream<Arguments> provideTimeAndHourHandGraduation()
            throws InvalidTimeException {

        return Stream.of(
                Arguments.of(new Time().withHour(12)
                                       .withMinute(0), 0),
                Arguments.of(new Time().withHour(3)
                                       .withMinute(0), 90),
                Arguments.of(new Time().withHour(6)
                                       .withMinute(0), 180),
                Arguments.of(new Time().withHour(9)
                                       .withMinute(0), 270),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(1), 0.5),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(2), 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTimeAndMinuteHandGraduation")
    void testFailsIfMinuteHandGraduationIncorrect(Time time, double graduation) {

        assertEquals(graduation,
                     new MovementEngine().minuteHandGraduation(time),
                     "Minute hand graduation is incorrect.");
    }

    private static Stream<Arguments> provideTimeAndMinuteHandGraduation()
            throws InvalidTimeException {

        return Stream.of(
                Arguments.of(new Time().withHour(12)
                                       .withMinute(0), 0),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(15), 90),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(30), 180),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(45), 270),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(1), 6),
                Arguments.of(new Time().withHour(12)
                                       .withMinute(2), 12)
        );
    }

    @Test
    void testFailsIfMovementThrowNPE() {

        //noinspection UnstableApiUsage
        new NullPointerTester()
                .testAllPublicInstanceMethods(new MovementEngine());
    }

}
