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

public final class Time {

    private final int hour;

    private final int minute;

    public Time() {
        this(12, 0);
    }

    private Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time withHour(int newhour) throws InvalidTimeException {

        if ((newhour > 12) || (newhour < 1)) {

            throw new InvalidTimeException("Hour value is out of boundaries!");
        }
        return new Time(newhour, this.minute);
    }

    public Time withMinute(int newminute) throws InvalidTimeException {

        if ((newminute > 59) || (newminute < 0)) {

            throw new InvalidTimeException("Minute value is out of boundaries!");
        }

        return new Time(this.hour, newminute);
    }

    public int hour() {
        return hour;
    }

    public int minute() {
        return minute;
    }

    @Override
    public String toString() {

        return String.format("%02d:%02d", hour, minute);
    }

}
