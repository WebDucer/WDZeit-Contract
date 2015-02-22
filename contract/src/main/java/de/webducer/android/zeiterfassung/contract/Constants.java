/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Eugen [WebDucer] Richter
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.webducer.android.zeiterfassung.contract;

public final class Constants {
   /**
    * Empty string value
    */
   public final static String EMPTY = "";

   /**
    * Constant for a number of hours in a day
    */
   public final static int HOURS_IN_A_DAY = 24;

   /**
    * Constant for a number of minutes in an hour
    */
   public final static int MINUTES_IN_A_HOUR = 60;

   /**
    * Constant for a number of minutes in a day
    */
   public final static int MINUTES_IN_A_DAY = HOURS_IN_A_DAY * MINUTES_IN_A_HOUR;

   /**
    * Constant for the package name of the core app (WebDucer Zeiterfassung)
    */
   public final static String CORE_PACKAGE_NAME = "de.webducer.android.zeiterfassung.core";
}
