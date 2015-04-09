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

import java.text.NumberFormat;
import java.util.Locale;

import de.webducer.android.zeiterfassung.contract.Constants;
import de.webducer.android.zeiterfassung.contract.R;

public enum DurationFormat implements ITranslatableEnum {
   /**
    * Format not set
    */
   None(0, R.string.enum_duration_format_none),
   /**
    * Hours and minutes (e.g.: 09:15, 45:30)
    */
   HoursMinutes(1, R.string.enum_duration_format_hours_minutes),
   /**
    * Days, hours and minutes (e.g.: 0 07:30, 5 17:22)
    */
   DaysHoursMinutes(2, R.string.enum_duration_format_days_hours_minutes),
   /**
    * Minutes (e.g.: 30, 3.562)
    */
   Minutes(3, R.string.enum_duration_format_minutes);

   /* Private fields */
   private final static String _DURATION_HOUR_MINUTES_FORMAT_STRING = "%s%02d:%02d";
   private final static String _DURATION_DAYS_HOUR_MINUTES_FORMAT_STRING = "%s%01d %02d:%02d";
   private final static String _MINUS = "-";
   
   private final int _enumCode;
   private final int _enumTranslationId;
   private String _translatedValue = null;

   /* Constructors */
   private DurationFormat(int enumCode, int enumTranslationId) {

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
    * Get string representation of duration
    *
    * @param duration in minutes
    * @return String representation
    */
   public String format(int duration) {
      int absMinutes = Math.abs(duration);

      switch (this) {
         case DaysHoursMinutes:
            int days = absMinutes / Constants.MINUTES_IN_A_DAY;
            int hours = (absMinutes % Constants.MINUTES_IN_A_DAY) / Constants.MINUTES_IN_A_HOUR;
            return String.format(Locale.getDefault(), _DURATION_DAYS_HOUR_MINUTES_FORMAT_STRING, duration < 0 ? _MINUS : Constants.EMPTY, days, hours, absMinutes % Constants.MINUTES_IN_A_HOUR);

         case HoursMinutes:
            return String.format(Locale.getDefault(), _DURATION_HOUR_MINUTES_FORMAT_STRING, duration < 0 ? _MINUS : Constants.EMPTY, absMinutes / Constants.MINUTES_IN_A_HOUR, absMinutes % Constants.MINUTES_IN_A_HOUR);

         default:
            return NumberFormat.getInstance().format(duration);
      }
   }

   /**
    * Get Enum value by given enum code
    *
    * @param enumCode Enum code (eg. from data base)
    * @return Resolved enum value or 'None' if no match
    */
   public static DurationFormat getDurationFormatByCode(int enumCode) {

      switch (enumCode) {
         case 1:
            return HoursMinutes;

         case 2:
            return DaysHoursMinutes;

         case 3:
            return Minutes;

         default:
            return None;
      }
   }

   public static DurationFormat[] getVisibleValues() {

      return new DurationFormat[] {DaysHoursMinutes, HoursMinutes, Minutes};
   }

   @Override
   public ITranslatableEnum getByEnumCode(int enumCode) {

      return getDurationFormatByCode(enumCode);
   }
}
