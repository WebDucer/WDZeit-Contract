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

import junit.framework.Assert;

import java.text.NumberFormat;

import de.webducer.android.zeiterfassung.contract.enums.DurationFormat;
import de.webducer.android.zeiterfassung.contract.enums.ITranslatableEnum;

/**
 * Created by eugen on 08.02.15.
 */
public class DurationFormatTests extends ITranslatableEnumTests {
   private final static int _totalMinutes = 2325486;
   private final static String _totalHours = "38758";
   private final static String _minutes = "06";
   private final static String _totalDays = "1614";
   private final static String _hours = "22";
   private final static int _totalNegativeMinutes = -2325486;
   private final static String _totalNegativeHours = "-38758";
   private final static String _totalNegativeDays = "-1614";

   @Override
   protected ITranslatableEnum[] getEnumValues() {
      return DurationFormat.values();
   }

   @Override
   protected int[] getEnumCodes() {
      return new int[] {DurationFormat.None.getEnumCode(), DurationFormat.Minutes.getEnumCode(), DurationFormat.HoursMinutes.getEnumCode(), DurationFormat.DaysHoursMinutes.getEnumCode()};
   }

   @Override
   protected ITranslatableEnum getSingleValue() {
      return DurationFormat.None;
   }

   public void test_getDurationFormatByCode_ReturnsValidValue() {
      DurationFormat format = DurationFormat.None;
      DurationFormat formatFromCode = DurationFormat.getDurationFormatByCode(format.getEnumCode());
      Assert.assertEquals(format, formatFromCode);

      format = DurationFormat.Minutes;
      formatFromCode = DurationFormat.getDurationFormatByCode(format.getEnumCode());
      Assert.assertEquals(format, formatFromCode);

      format = DurationFormat.HoursMinutes;
      formatFromCode = DurationFormat.getDurationFormatByCode(format.getEnumCode());
      Assert.assertEquals(format, formatFromCode);

      format = DurationFormat.DaysHoursMinutes;
      formatFromCode = DurationFormat.getDurationFormatByCode(format.getEnumCode());
      Assert.assertEquals(format, formatFromCode);
   }

   public void test_format_WithNone_ReturnsDurationInMinutes() {
      DurationFormat format = DurationFormat.None;

      String formattedValue = format.format(_totalMinutes);

      String expected = NumberFormat.getInstance().format(_totalMinutes);

      Assert.assertEquals(expected, formattedValue);
   }

   public void test_format_WithMinutes_ReturnsDurationInMinutes() {
      DurationFormat format = DurationFormat.Minutes;

      String formattedValue = format.format(_totalMinutes);

      String expected = NumberFormat.getInstance().format(_totalMinutes);

      Assert.assertEquals(expected, formattedValue);
   }

   public void test_format_WithHoursMinutes_ReturnsDurationInHoursAndMinutes() {
      DurationFormat format = DurationFormat.HoursMinutes;

      String[] actual = format.format(_totalMinutes).split("[: ]");

      Assert.assertEquals(actual[0], _totalHours);
      Assert.assertEquals(actual[1], _minutes);
   }

   public void test_format_WithDaysHoursMinutes_ReturnsDurationInDaysHoursAndMinutes() {
      DurationFormat format = DurationFormat.DaysHoursMinutes;

      String[] actual = format.format(_totalMinutes).split("[: ]");

      Assert.assertEquals(actual[0], _totalDays);
      Assert.assertEquals(actual[1], _hours);
      Assert.assertEquals(actual[2], _minutes);
   }

   public void test_format_WithNegativeNone_ReturnsDurationInMinutes() {
      DurationFormat format = DurationFormat.None;

      String formattedValue = format.format(_totalNegativeMinutes);

      String expected = NumberFormat.getInstance().format(_totalNegativeMinutes);

      Assert.assertEquals(expected, formattedValue);
   }

   public void test_format_WithNegativeMinutes_ReturnsDurationInMinutes() {
      DurationFormat format = DurationFormat.Minutes;

      String formattedValue = format.format(_totalNegativeMinutes);

      String expected = NumberFormat.getInstance().format(_totalNegativeMinutes);

      Assert.assertEquals(expected, formattedValue);
   }

   public void test_format_WithNegativeHoursMinutes_ReturnsDurationInHoursAndMinutes() {
      DurationFormat format = DurationFormat.HoursMinutes;

      String[] actual = format.format(_totalNegativeMinutes).split("[: ]");

      Assert.assertEquals(actual[0], _totalNegativeHours);
      Assert.assertEquals(actual[1], _minutes);
   }

   public void test_format_WithNegativeDaysHoursMinutes_ReturnsDurationInDaysHoursAndMinutes() {
      DurationFormat format = DurationFormat.DaysHoursMinutes;

      String[] actual = format.format(_totalNegativeMinutes).split("[: ]");

      Assert.assertEquals(actual[0], _totalNegativeDays);
      Assert.assertEquals(actual[1], _hours);
      Assert.assertEquals(actual[2], _minutes);
   }
}
