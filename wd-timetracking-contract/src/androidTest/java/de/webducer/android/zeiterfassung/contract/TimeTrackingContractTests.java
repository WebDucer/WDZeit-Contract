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
import junit.framework.TestCase;


public class TimeTrackingContractTests extends TestCase {
   public final void testConcatArrays_WithNullFirst_ReturnSecond() {
      final String value1 = "Value 1";

      final String[] actual = TimeTrackingContract.concatArrays(null, value1);

      final int expected = 1;
      Assert.assertNotNull(actual);
      Assert.assertEquals(expected, actual.length);
      Assert.assertEquals(value1, actual[0]);
   }

   public final void testConcatArrays_WithEmptyFirst_ReturnSecond() {
      final String value1 = "Value 1";
      final String[] first = {};

      final String[] actual = TimeTrackingContract.concatArrays(first, value1);

      final int expected = 1;
      Assert.assertNotNull(actual);
      Assert.assertEquals(expected, actual.length);
      Assert.assertEquals(value1, actual[0]);
   }

   public final void testConcatArrays_WithNullSecond_ReturnFirst() {
      final String value1 = "Value 1";
      final String[] first = {value1};

      final String[] actual = TimeTrackingContract.concatArrays(first);

      final int expected = 1;
      Assert.assertNotNull(actual);
      Assert.assertEquals(expected, actual.length);
      Assert.assertEquals(value1, actual[0]);
   }

   public final void testConcatArrays_WithBoth_ReturnCombinationOfBoth() {
      final String value1 = "Value 1";
      final String value2 = "Value 2";
      final String value3 = "Value 3";
      final String value4 = "Value 4";
      final String value5 = "Value 5";
      final String[] first = {value1, value2};

      final String[] actual = TimeTrackingContract.concatArrays(first, value3, value4, value5);

      final int expected = 5;
      Assert.assertNotNull(actual);
      Assert.assertEquals(expected, actual.length);
      Assert.assertEquals(value1, actual[0]);
      Assert.assertEquals(value2, actual[1]);
      Assert.assertEquals(value3, actual[2]);
      Assert.assertEquals(value4, actual[3]);
      Assert.assertEquals(value5, actual[4]);
   }
}
