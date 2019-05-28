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
/**
 * HAND_REVOLUTION = 360 degrees
 * MINUTE_HAND_GRADUATION = HAND_REVOLUTION / 60 * MINUTES
 * HOUR_HAND_GRADUATION = HAND_REVOLUTION / 12 * HOURS + MINUTE_HAND_GRADUATION / 12
 *
 */
package io.javaclasses.analogwatch;

public class Movement {

    private final Time time;

    public Movement() {
        this(new Time());
    }

    private Movement(Time time) {
        this.time = time;
    }

    public Movement withTime(Time time) {
        return new Movement(time);
    }

    public double hourHandGraduation() {

        // (HOUR_HAND_GRADUATION + MINUTE_HAND_GRADUATION/12) mod HAND_REVOLUTION
        return ((time.hour() * 60 + time.minute()) * 0.5) % 360;
    }

    public double minuteHandGraduation() {
        return time.minute() * 6;
    }

    public double handsGraduationDiff() {
        return Math.abs(hourHandGraduation() - minuteHandGraduation());
    }

}
