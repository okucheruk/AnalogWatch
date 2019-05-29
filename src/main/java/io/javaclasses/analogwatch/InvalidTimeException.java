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
 * The class {@code InvalidTimeException} indicates conditions of specifying invalid time values for
 * time hour or minute.
 */
final class InvalidTimeException extends AnalogWatchException {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message
     *         The detail message. The detail message is saved for later retrieval by the
     *         getMessage() method.
     */
    InvalidTimeException(String message) {
        super(message);
    }

}
