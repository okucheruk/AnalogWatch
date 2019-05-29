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

class MovementTest {

    @Test
    void testFailsIfHourHandGraduationIncorrect() throws InvalidTimeException {

        for (int h = 1; h < 13; h++) {

            for (int m = 0; m < 60; m++) {

                Time time =
                        new Time()
                                .withHour(h)
                                .withMinute(m);

                assertEquals((h * 60 + m) * 0.5 % 360,
                             new Movement().hourHandGraduation(time),
                             "Hour hand graduation is incorrect.");

            }
        }

    }

    @Test
    void testFailsIfMinuteHandGraduationIncorrect() throws InvalidTimeException {

        for (int m = 0; m < 60; m++) {

            Time time =
                    new Time()
                            .withHour(12)
                            .withMinute(m);

            assertEquals((m * 6),
                         new Movement().minuteHandGraduation(time),
                    "Minute hand graduation is incorrect.");
        }
    }

    @Test
    void testFailsIfHandsGraduationDiffIncorrect() throws InvalidTimeException {

        Time time =
                new Time()
                        .withHour(6)
                        .withMinute(0);

        assertEquals(180,
                     new Movement().handsGraduationDiff(time),
                     "Angle between hour and minute hands is incorrect.");
    }
}
