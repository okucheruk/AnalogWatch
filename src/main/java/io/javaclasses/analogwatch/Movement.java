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

/**
 * <code>Movement</code> provides methods for calculating angle between analog watch hour and
 * minute hands of specified hands movement time.
 *
 * <p>
 * <code>Movement</code> helps you to define watch hands graduation, angle between hour and minute
 * hands.
 *
 * <p>
 * Calculation details:
 * <blockquote>
 * Watch hands revolution is 360 degrees.
 * <p>
 * One graduation of minute hand is revolution devided into 60 intervals (minutes).
 * <p>
 * One graduation of hour hand is revolution devided into 720 intervals (12 hours * 60 minutes).
 * </blockquote>
 */

public class Movement {

    /*
     * 360 degrees / 60 minutes = 6 degrees
     */
    private final double ONE_MINUTEHAND_GRADUATION = 6;

    /*
     * 360 degrees / (12 hours * 60 minutes) = 0.5 degrees
     */
    private final double ONE_HOURHAND_GRADUATION = 0.5;

    /**
     * Returns hour hand graduation value of specified time.
     *
     * @param time
     *         Time.
     * @return Hour hand graduation.
     */
    public double hourHandGraduation(Time time) {
        return ((time.hour() * 60 + time.minute()) * ONE_HOURHAND_GRADUATION) % 360;
    }

    /**
     * Returns minute hand graduation value of specified time.
     *
     * @param time
     *         Time.
     * @return Minute hand graduation.
     */
    public double minuteHandGraduation(Time time) {
        return (double) time.minute() * ONE_MINUTEHAND_GRADUATION;
    }

    /**
     * Returns angle between hour and minute hands of specified time.
     *
     * @param time
     *         Time.
     * @return Angle between hour and minute hands
     */
    public double handsGraduationDiff(Time time) {
        return Math.abs(hourHandGraduation(time) - minuteHandGraduation(time));
    }

}
