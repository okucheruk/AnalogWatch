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
 * The class {@code AnalogWatchException} and its subclasses are a form of {@code Throwable} that
 * indicates conditions that a reasonable AnalogWatch application might want to catch.
 *
 * <p>The class {@code AnalogWatchException} and any subclasses that are not also subclasses of
 * {@link RuntimeException} are <em>checked exceptions</em>. Checked exceptions need to be declared
 * in a method or constructor's {@code throws} clause if they can be thrown by the execution of the
 * method or constructor and propagate outside the method or constructor boundary.
 *
 * @author Oleksii Kucheruk
 */
class AnalogWatchException extends Exception {

    AnalogWatchException(String message) {
        super(message);
    }

}
