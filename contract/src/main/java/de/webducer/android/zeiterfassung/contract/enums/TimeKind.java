package de.webducer.android.zeiterfassung.contract.enums;

import android.content.Context;

import de.webducer.android.zeiterfassung.contract.R;

/**
 * Enumeration for the time kind
 *
 * @author WebDucer - IT & Internet Service
 * @category Enumeartion, Content Provider, Contracts
 * @version 0.2
 * @since 2015-04-04
 */
public enum TimeKind implements ITranslatableEnum {
   /**
    * Time Kind is not defined
    */
   None(0, R.string.enum_time_kind_none),

   /**
    * Time Kind for working time
    */
   WorkingTime(1, R.string.enum_time_kind_working_time),

   /**
    * Time Kind for overtime
    */
   Overtime(2, R.string.enum_time_kind_overtime),

   /**
    * Time Kind for holiday and vacation
    */
   Holiday(3, R.string.enum_time_kind_holiday);

   /* Private fields */
   private final int _EnumCode;
   private final int _EnumTranslationId;
   private String    _TranslatedValue = null;

   /* Constructors */
   private TimeKind(int enumCode, int enumTranslationId) {

      _EnumCode = enumCode;
      _EnumTranslationId = enumTranslationId;
   }

   @Override
   public int getEnumCode() {

      return _EnumCode;
   }

   @Override
   public int getTranslationId() {

      return _EnumTranslationId;
   }

   @Override
   public String getTranslatedValue(Context context) {

      if (_TranslatedValue == null) {
         _TranslatedValue = context.getString(_EnumTranslationId);
      }

      return _TranslatedValue;
   }

   /**
    * Get Enum value by given enum code
    *
    * @param enumCode Enum code (eg. from data base)
    * @return Resolved enum value or 'None' if no match
    */
   public final static TimeKind getTimeKindByCode(int enumCode) {

      switch (enumCode) {
         case 1:
            return WorkingTime;

         case 2:
            return Overtime;

         case 3:
            return Holiday;

         default:
            return None;
      }
   }

   public final static TimeKind[] getVisibleValues() {

      return new TimeKind[] {WorkingTime, Overtime, Holiday};
   }

   @Override
   public ITranslatableEnum getByEnumCode(int enumCode) {

      return getTimeKindByCode(enumCode);
   }
}
