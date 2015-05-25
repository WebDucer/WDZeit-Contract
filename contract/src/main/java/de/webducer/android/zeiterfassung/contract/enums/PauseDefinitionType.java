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

package de.webducer.android.zeiterfassung.contract.enums;

import android.content.Context;

import de.webducer.android.zeiterfassung.contract.R;

/**
 * Enumeration for the pause definition type
 *
 * @author WebDucer - IT &amp; Internet Service
 * @version 0.2
 * @since 2015-04-09
 */
public enum PauseDefinitionType implements ITranslatableEnum {
   /**
    * Not defined
    */
   None(0, R.string.enum_pause_definition_type_none),
   /**
    * Time based pause definition
    */
   TimeBased(1, R.string.enum_pause_definition_type_time_based),
   /**
    * Duration based pause definition
    */
   DurationBased(2, R.string.enum_pause_definition_type_duration_based);

   /* Private fields */
   private final int _enumCode;
   private final int _enumTranslationId;
   private String _translatedValue = null;

   /* Constructors */
   private PauseDefinitionType(int enumCode, int enumTranslationId) {

      _enumCode = enumCode;
      _enumTranslationId = enumTranslationId;
   }

   @Override
   public int getEnumCode() {

      return _enumCode;
   }

   @Override
   public int getTranslationId() {

      return _enumTranslationId;
   }

   @Override
   public String getTranslatedValue(Context context) {

      if (_translatedValue == null) {
         _translatedValue = context.getString(_enumTranslationId);
      }

      return _translatedValue;
   }

   /**
    * Get Enum value by given enum code
    *
    * @param enumCode Enum code (eg. from data base)
    * @return Resolved enum value or 'None' if no match
    */
   public static PauseDefinitionType getPauseDefinitionTypeByCode(int enumCode) {

      switch (enumCode) {
         case 1:
            return TimeBased;

         case 2:
            return DurationBased;

         default:
            return None;
      }
   }

   public static PauseDefinitionType[] getVisibleValues() {

      return new PauseDefinitionType[] {TimeBased, DurationBased};
   }

   @Override
   public ITranslatableEnum getByEnumCode(int enumCode) {

      return getPauseDefinitionTypeByCode(enumCode);
   }
}
