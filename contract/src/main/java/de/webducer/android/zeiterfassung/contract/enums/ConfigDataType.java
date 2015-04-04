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
 * Enumeration for the time kind
 *
 * @author WebDucer - IT & Internet Service
 * @version 0.2
 * @category Enumeration, Content Provider, Contracts
 * @since 2015-04-04
 */
public enum ConfigDataType implements ITranslatableEnum {
   /**
    * Data type is not set
    */
   NotSet(0, R.string.enum_config_data_type_not_set),

   /**
    * String
    */
   String(1, R.string.enum_config_data_type_string),

   /**
    * Boolean
    */
   Boolean(2, R.string.enum_config_data_type_boolean),

   /**
    * Integer
    */
   Integer(3, R.string.enum_config_data_type_integer),

   /**
    * Long
    */
   Long(4, R.string.enum_config_data_type_long),

   /**
    * Double
    */
   Double(5, R.string.enum_config_data_type_double),

   /**
    * Float
    */
   Float(6, R.string.enum_config_data_type_float);

   /* Private fields */
   private final int _EnumCode;
   private final int _EnumTranslationId;

   /* Constructors */
   private ConfigDataType(int enumCode, int enumTranslationId) {

      _EnumCode = enumCode;
      _EnumTranslationId = enumTranslationId;
   }

   /**
    * Get int representation of the value (eg. for DB)
    *
    * @return Int representation of enum value
    */
   public int getEnumCode() {

      return _EnumCode;
   }

   /**
    * Get translation id for the enum value
    *
    * @return Translation key for further translation
    */
   public int getTranslationId() {

      return _EnumTranslationId;
   }

   /**
    * Get translated value of the enum value
    *
    * @param context App context
    * @return Translated enum value
    */
   public String getTranslatedValue(Context context) {

      return context.getString(_EnumTranslationId);
   }

   /**
    * Get Enum value by given enum code
    *
    * @param enumCode Enum code (eg. from data base)
    * @return Resolved enum value or 'NotSet' if no match
    */
   public static ConfigDataType getConfigDataTypeByCode(int enumCode) {

      switch (enumCode) {
         case 1:
            return String;

         case 2:
            return Boolean;

         case 3:
            return Integer;

         case 4:
            return Long;

         case 5:
            return Double;

         case 6:
            return Float;

         default:
            return NotSet;
      }
   }

   @Override
   public ITranslatableEnum getByEnumCode(int enumCode) {

      return getConfigDataTypeByCode(enumCode);
   }
}
