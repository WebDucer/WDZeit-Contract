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

import java.util.ArrayList;
import java.util.List;

import de.webducer.android.zeiterfassung.contract.enums.ITranslatableEnum;

/**
 * Created by eugen on 08.02.15.
 */
public abstract class ITranslatableEnumTests extends TestCase {
   public void test_getEnumCode_ReturnUniqueCode() {
      ITranslatableEnum[] values = getEnumValues();
      List<Integer> enumCodes = new ArrayList<Integer>();

      for (ITranslatableEnum value : values) {
         int enumCode = value.getEnumCode();
         Assert.assertFalse("Enum code is not unique", enumCodes.contains(enumCode));

         enumCodes.add(enumCode);
      }
   }

   protected abstract ITranslatableEnum[] getEnumValues();

   public void test_getTranslationId_ReturnValidId() {
      ITranslatableEnum[] values = getEnumValues();

      for (ITranslatableEnum value : values) {
         int resourceId = value.getTranslationId();

         Assert.assertFalse("Resource ID could not be lower or equal 0", resourceId <= 0);
      }
   }

   public void test_getByEnumCode_ReturnsNotNull() {
      int[] enumCodes = getEnumCodes();
      ITranslatableEnum testValue = getSingleValue();

      for (int enumCode : enumCodes) {
         ITranslatableEnum value = testValue.getByEnumCode(enumCode);

         Assert.assertNotNull("Value is null", value);
      }
   }

   protected abstract int[] getEnumCodes();

   protected abstract ITranslatableEnum getSingleValue();
}
