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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>Time</code> is the immutable time object that represents a specified time, often viewed as
 * hour:minute. Time is represented to minutes precision of 12-hour time format.
 * For example, the value between "01:00" and "12:59" can be stored in a <code>Time</code>.
 */
public final class Time {

    private static final Logger logger = LoggerFactory.getLogger(Time.class);

    /*
     * Time hour field. Value range is [1-12]
     */
    private final int hour;

    /*
     * Time minute field. Value range is [0-59]
     */
    private final int minute;

    /**
     * Default constructor.
     * Creates <code>Time</code> object with 12:00 hour:minute values.
     */
    public Time() {
        this(12, 0);
    }

    /*
     * Secondary constructor. (For implicit invocation by factory methods.)
     * Creates <code>Time</code> object with specified hour:minute values.
     */
    private Time(int hour, int minute) {

        this.hour = hour;
        this.minute = minute;

        if (logger.isDebugEnabled()) {
            logger.debug("Time instance constructed " + hour + ":" + minute);
        }
    }

    /**
     * Returns new instance of <code>Time</code> with new hour value and preserved old minute value.
     * Method throws {@link InvalidTimeException} for out of range values.
     *
     * @param newhour
     *         Hour time value.
     * @return A new instance of <code>Time</code>.
     * @throws InvalidTimeException
     *         If hour value is out of range [1-12].
     */
    public Time withHour(int newhour) throws InvalidTimeException {

        if ((newhour > 12) || (newhour < 1)) {

            throw new InvalidTimeException("Hour value is out of range [1-12]!");
        }
        return new Time(newhour, this.minute);
    }

    /**
     * Returns new instance of <code>Time</code> with new minute value and preserved old hour value.
     * Method throws {@link InvalidTimeException} for out of range values.
     *
     * @param newminute
     *         Minute time value.
     * @return A new instance of <code>Time</code>.
     * @throws InvalidTimeException
     *         If minute value is out of range [0-59].
     */
    public Time withMinute(int newminute) throws InvalidTimeException {

        if ((newminute > 59) || (newminute < 0)) {

            throw new InvalidTimeException("Minute value is out of range [0-59]!");
        }

        return new Time(this.hour, newminute);
    }

    /**
     * Returns <code>Time</code> hour value.
     *
     * @return hour value.
     */
    int hour() {
        return hour;
    }

    /**
     * Returns <code>Time</code> minute value.
     *
     * @return hour value.
     */
    int minute() {
        return minute;
    }

    /**
     * Outputs this time as a {@code String} of the 12-hour format ({@code 12:59}).
     *
     * @return a string representation of this time, not null.
     */
    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minute);
    }

}
