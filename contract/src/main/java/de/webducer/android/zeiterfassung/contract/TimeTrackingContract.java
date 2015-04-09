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

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Contract for the content provider of the app
 *
 * @author WebDucer - IT & Internet Service
 * @version 0.4
 * @since 2015-02-23
 */
public final class TimeTrackingContract {
   /* Private fields */
   // Base package name
   private final static String _BASE_PATH = "de.webducer.android.zeiterfassung";
   private final static String _ACTION_BASE_PATH = _BASE_PATH + ".action.";

	/* Public fields */
   /**
    * Authority of the content provider
    */
   public final static String AUTHORITY = _BASE_PATH + ".provider";
   /**
    * Base URI of the content provider
    */
   public final static Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
   /**
    * ID for not found entry
    */
   public final static long NO_ID = -1;
   /**
    * ID for ALL (used only in own merged cursors, not in DB)
    */
   public final static long ALL_ID = -1000l;
   /**
    * ID for NOT ASSIGNED (NULL - used only in own merged cursors, not in DB)
    */
   public final static long NULL_ID = -500l;
   /**
    * True value of boolean columns
    */
   public final static int BOOL_TRUE = 1;
   /**
    * True value of boolean columns as String
    */
   public final static String BOOL_TRUE_AS_STRING = "1";
   /**
    * False value of boolean columns
    */
   public final static int BOOL_FALSE = 0;
   /**
    * False value of boolean columns as String
    */
   public final static String BOOL_FALSE_AS_STRING = "0";

   /* Constructors */
   private TimeTrackingContract() {

   }

   /**
    * Concatenate string array with a collection of Strings
    *
    * @param first  array to be placed as first
    * @param params collection of Strings to be add to new array
    * @return new array with all element together
    */
   public final static String[] concatArrays(String[] first, String... params) {

      if (first == null || first.length == 0) {
         return params;
      }

      if (params == null || params.length == 0 || (params.length == 1 && params[0] == null)) {
         return first;
      }

      String[] returnValue = new String[first.length + params.length];
      System.arraycopy(first, 0, returnValue, 0, first.length);
      System.arraycopy(params, 0, returnValue, first.length, params.length);

      return returnValue;
   }

	/* Permissions */

   public static interface Values {
      /**
       * ID for not found entry
       */
      public final static long NO_ID = -1;

      /**
       * ID for ALL (used only in own merged cursors, not in DB)
       */
      public final static long ALL_ID = -1000l;

      /**
       * ID for NOT ASSIGNED (NULL - used only in own merged cursors, not in DB)
       */
      public final static long NULL_ID = -500l;

      /**
       * True value of boolean columns
       */
      public final static int BOOL_TRUE = 1;
      /**
       * True value of boolean columns as String
       */
      public final static String BOOL_TRUE_AS_STRING = "1";
      /**
       * False value of boolean columns
       */
      public final static int BOOL_FALSE = 0;
      /**
       * False value of boolean columns as String
       */
      public final static String BOOL_FALSE_AS_STRING = "0";
   }

   /**
    * Permissions to access data from content provider
    */
   public static interface Permissions {

      /**
       * Required permission to read configuration data from database
       * <ul>
       * <li>configuration</li>
       * </ul>
       */
      public final static String PERMISSION_READ_CONFIGURATION = _BASE_PATH + ".PERMISSION_READ_CONFIGURATION";

      /**
       * Required permission to write configuration data to database
       * <ul>
       * <li>configuration</li>
       * </ul>
       */
      public final static String PERMISSION_WRITE_CONFIGURATION = _BASE_PATH + ".PERMISSION_WRITE_CONFIGURATION";

      /**
       * Required permission to read time records
       * <ul>
       * <li>time_record</li>
       * <li>pause</li>
       * </ul>
       */
      public final static String PERMISSION_READ_RECORD = _BASE_PATH + ".PERMISSION_READ_RECORD";

      /**
       * Required permission to write time records
       * <ul>
       * <li>time_record</li>
       * <li>pause</li>
       * </ul>
       */
      public final static String PERMISSION_WRITE_RECORD = _BASE_PATH + ".PERMISSION_WRITE_RECORD";

      /**
       * Required permission to read master data
       * <ul>
       * <li>time_type</li>
       * <li>project</li>
       * <li>address</li>
       * <li>project_time_type</li>
       * </ul>
       */
      public final static String PERMISSION_READ_MASTER_DATA = _BASE_PATH + ".PERMISSION_READ_MASTER_DATA";

      /**
       * Required permission to write master data
       * <ul>
       * <li>time_type</li>
       * <li>project</li>
       * <li>address</li>
       * <li>project_time_type</li>
       * </ul>
       */
      public final static String PERMISSION_WRITE_MASTER_DATA = _BASE_PATH + ".PERMISSION_WRITE_MASTER_DATA";

      /**
       * Required permission to read stored reports
       * <ul>
       * <li>report</li>
       * </ul>
       */
      public final static String PERMISSION_READ_REPORT = _BASE_PATH + ".PERMISSION_READ_REPORT";

      /**
       * Required permission to write stored reports
       * <ul>
       * <li>report</li>
       * </ul>
       */
      public final static String PERMISSION_WRITE_REPORT = _BASE_PATH + ".PERMISSION_WRITE_REPORT";

   }

   /**
    * Actions fired by the core app
    */
   public static interface Actions {

      /**
       * Fired from content provider after insert, update or delete of the record or record pause
       */
      public final static String ACTION_RECORD_DATA_CHANGED = _BASE_PATH + ".ACTION_RECORD_CHANGED";

      /**
       * Fired from content provider after insert, update or delete of the project, address, time type or project time type data
       */
      public final static String ACTION_MASTER_DATA_CHANGED = _BASE_PATH + ".ACTION_MASTER_DATA_CHANGED";

      /**
       * Fired from content provider after insert, update or delete of the configuration data
       */
      public final static String ACTION_CONFIG_DATA_CHANGED = _BASE_PATH + ".ACTION_CONFIG_DATA_CHANGED";
   }

   /**
    * Converter for date and time fields
    */
   public final static class Converter {

      private final static String _DB_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm";
      private final static String _DB_DATE_PATTERN = "yyyy-MM-dd";
      private final static String _DB_TIME_PATTERN = "HH:mm";
      /**
       * Formatter for data base date time fields
       */
      public final static DateFormat DB_DATE_TIME_FORMATTER = new SimpleDateFormat(_DB_DATE_TIME_PATTERN, Locale.GERMANY);
      /**
       * Formatter for data base date fields
       */
      public final static DateFormat DB_DATE_FORMATTER = new SimpleDateFormat(_DB_DATE_PATTERN, Locale.GERMANY);
      /**
       * Formatter for data base time fields
       */
      public final static DateFormat DB_TIME_FORMATTER = new SimpleDateFormat(_DB_TIME_PATTERN, Locale.GERMANY);
   }

   /**
    * Contract data for all configuration tables
    */
   public final static class ConfigurationData {

      /* Private fields */
      // base path for all configuration data
      private final static String _CATEGORY_DIRECTORY = "config_data";

		/* Data classes */

      /**
       * Contract for the configuration table
       */
      public final static class Configuration {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "configuration";

			/* Public fields */
         /**
          * Configuration data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Configuration data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Configuration data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Configuration key column [String, Required, Unique]
             */
            public final static String KEY = "cfg_key";

            /**
             * Configuration value data type column [INTEGER => ConfigDataType(Enumeration), Required]
             *
             * @see de.webducer.android.zeiterfassung.contract.enums.ConfigDataType
             * <dl>
             * <dt>0</dt>
             * <dd>Not Set</dd>
             * <dt>1</dt>
             * <dd>String</dd>
             * <dt>2</dt>
             * <dd>Boolean</dd>
             * <dt>3</dt>
             * <dd>Integer</dd>
             * <dt>4</dt>
             * <dd>Long</dd>
             * <dt>5</dt>
             * <dd>Double</dd>
             * <dt>6</dt>
             * <dd>Float</dd>
             * </dl>
             */
            public final static String TYPE = "cfg_type";

            /**
             * Configuration value column [String]
             */
            public final static String VALUE = "cfg_value";

            /**
             * Configuration active column [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String ACTIVE = "cfg_active";

            /**
             * Configuration visibility column [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String VISIBLE = "cfg_visible";

            /**
             * All configuration data available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, KEY, TYPE, VALUE, ACTIVE, VISIBLE};
         }

         /**
          * Configuration data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }
   }

   /**
    * Contract data for all master data tables
    */
   public final static class MasterData {

      /* Private fields */
      // base path for all master data
      private final static String _CATEGORY_DIRECTORY = "master_data";

      /**
       * Contract for the address table
       */
      public final static class Address {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "address";

			/* Public fields */
         /**
          * Address data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Address data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Address data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /**
          * Unique: NAME + STREET + CITY + COUNTRY
          */
         public static interface Columns extends BaseColumns {

            /**
             * Name for the address [String, Required, Unique: {NAME, STREET, CITY, COUNTRY}]
             */
            public final static String NAME = "ad_name";

            /**
             * Street name for the address [String, Unique: {NAME, STREET, CITY, COUNTRY}]
             */
            public final static String STREET = "ad_street";

            /**
             * Postal code for the address [String]
             */
            public final static String POSTAL_CODE = "ad_postal_code";

            /**
             * City of the address [String, Unique: {NAME, STREET, CITY, COUNTRY}]
             */
            public final static String CITY = "ad_city";

            /**
             * Country of the address [String, Unique: {NAME, STREET, CITY, COUNTRY}]
             */
            public final static String COUNTRY = "ad_country";

            /**
             * Address is selectable on the UI [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1 on insert]
             */
            public final static String ACTIVE = "ad_active";

            /**
             * All address available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, NAME, STREET, POSTAL_CODE, CITY, COUNTRY, ACTIVE};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Count of the assigned projects
             */
            public final static String PROJECT_COUNT = "ad_pj_count";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, PROJECT_COUNT);
         }

         /**
          * Address data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);





			/* Column Interfaces */


      }

      /**
       * Contract for the time type table
       */
      public final static class TimeType {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "time_type";

			/* Public fields */
         /**
          * Time type data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Time type data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Time type data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Kind of the time type [INTEGER => TimeKind(Enumeration), Required, Default 1]
             *
             * @see de.webducer.android.zeiterfassung.contract.enums.TimeKind
             * <dl>
             * <dt>1</dt>
             * <dd>WorkingTime</dd>
             * <dt>2</dt>
             * <dd>Overtime</dd>
             * <dt>3</dt>
             * <dd>Holiday</dd>
             * </dl>
             */
            public final static String KIND = "tt_kind";

            /**
             * Name for the time type [String, Required, Unique]
             */
            public final static String NAME = "tt_name";

            /**
             * Description for the time type [String]
             */
            public final static String DESCRIPTION = "tt_desc";

            /**
             * Hourly fee for the time type [Real, Required, Default 0]
             */
            public final static String FEE = "tt_fee";

            /**
             * Time calculation factor for the time type [Real, Required, Default 1]
             */
            public final static String TIME_FACTOR = "tt_time_factor";

            /**
             * Time type is selectable on the UI [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String ACTIVE = "tt_active";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, KIND, NAME, DESCRIPTION, FEE, TIME_FACTOR, ACTIVE};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Count of the assigned time records
             */
            public final static String TIME_RECORD_COUNT = "tt_record_count";

            /**
             * Count of the assigned projects
             */
            public final static String PROJECT_COUNT = "tt_project_count";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, TIME_RECORD_COUNT, PROJECT_COUNT);
         }

         /**
          * Time type data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the project table
       */
      public final static class Project {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "project";

			/* Public fields */
         /**
          * Project data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Project data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Project data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the assigned address [INTEGER]
             */
            public final static String ADDRESS_ID = "ad_id";

            /**
             * Name for the project [String, Required, Unique]
             */
            public final static String NAME = "pj_name";

            /**
             * Description for the project [String]
             */
            public final static String DESCRIPTION = "pj_desc";

            /**
             * Project is selectable on the UI [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String ACTIVE = "pj_active";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, ADDRESS_ID, NAME, DESCRIPTION, ACTIVE};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Name of the assigned address
             */
            public final static String ADDRESS_NAME = "ad_name";

            /**
             * Street of the assigned address
             */
            public final static String ADDRESS_STREET = "ad_street";

            /**
             * Postal code of the assigned address
             */
            public final static String ADDRESS_POSTAL_CODE = "ad_postal_code";

            /**
             * City of the assigned address
             */
            public final static String ADDRESS_CITY = "ad_city";

            /**
             * Country of the assigned address
             */
            public final static String ADDRESS_COUNTRY = "ad_country";

            /**
             * Active flag of the assigned address [Default set on false on query]
             */
            public final static String ADDRESS_ACTIVE = "ad_active";

            /**
             * Count of the time records of the project
             */
            public final static String TIME_RECORD_COUNT = "pj_tr_count";

            public final static String TIME_TYPE_COUNT = "pj_tt_count";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, ADDRESS_NAME, ADDRESS_STREET, ADDRESS_POSTAL_CODE, ADDRESS_CITY, ADDRESS_CITY, ADDRESS_COUNTRY, ADDRESS_ACTIVE, TIME_RECORD_COUNT, TIME_TYPE_COUNT);
         }

         /**
          * Project data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the project table
       */
      public final static class ProjectTimeType {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "project_time_type";

			/* Public fields */
         /**
          * Project time type data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Project time type data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Project time type data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the assigned project [INTEGER, Required]
             */
            public final static String PROJECT_ID = "pj_id";

            /**
             * ID of the assigned time type [INTEGER, Required]
             */
            public final static String TIME_TYPE_ID = "tt_id";

            /**
             * Discount in per cent for this assignmnent [REAL, Required, Default: 0]
             */
            public final static String DISCOUNT = "ptt_discount";

            /**
             * Default time type for the project (can be only one per project) [BOOLEAN, TRUE = 1, FALSE = 0]
             */
            public final static String DEFAULT = "ptt_default";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, PROJECT_ID, TIME_TYPE_ID, DISCOUNT, DEFAULT};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Diasplay Name ('Project Name : Time Type Name')
             */
            public final static String DISPALY_NAME = "ptt_display_name";

            /**
             * Name of the assigned project
             */
            public final static String PROJECT_NAME = "pj_name";

            /**
             * Description of the assigned project
             */
            public final static String PROJECT_DESCRIPTION = "pj_desc";

            /**
             * Active flag of the assigned project
             */
            public final static String PROJECT_ACTIVE = "pj_active";

            /**
             * Kind of the assigned time type [INTEGER => TimeKind(Enumeration)]
             * <dl>
             * <dt>1</dt>
             * <dd>WorkingTime</dd>
             * <dt>2</dt>
             * <dd>Overtime</dd>
             * <dt>3</dt>
             * <dd>Holiday</dd>
             * </dl>
             */
            public final static String TIME_TYPE_KIND = "tt_kind";

            /**
             * Name of the assigned time type [String]
             */
            public final static String TIME_TYPE_NAME = "tt_name";

            /**
             * Description of the assigned time type [String]
             */
            public final static String TIME_TYPE_DESCRIPTION = "tt_desc";

            /**
             * Active flag of the assigned time type [INTEGER => BOOL (0: FALSE, 1: TRUE)]
             */
            public final static String TIME_TYPE_ACTIVE = "tt_active";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, DISPALY_NAME, PROJECT_NAME, PROJECT_DESCRIPTION, PROJECT_ACTIVE, TIME_TYPE_KIND, TIME_TYPE_NAME, TIME_TYPE_DESCRIPTION, TIME_TYPE_ACTIVE);
         }

         /**
          * Project time type data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the pause definition table
       */
      public final static class PauseDefinition {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "pause_definition";

			/* Public fields */
         /**
          * Pause definition data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Pause definition data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Pause definition data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Pause type [INTEGER => PauseType(Enumeration), Required, Default 1]
             * <dl>
             * <dt>1</dt>
             * <dd>TimeBased: Based on time of the day (e.g.: pause between 11:00 and 11:30)</dd>
             * <dt>2</dt>
             * <dd>DurationBased: Based on the tracked time duration (e.g.: tracked time duration is 8 hours => 30 min pause)</dd>
             * </dl>
             */
            public final static String PAUSE_TYPE = "pd_pause_type";

            /**
             * Start time of the time based pause [String, ISO-8601, eg. '18:15']
             */
            public final static String START_TIME = "pd_start_time";

            /**
             * End time of the time based pause [String, ISO-8601, eg. '18:15']
             */
            public final static String END_TIME = "pd_end_time";

            /**
             * Tracked time of the duration based pause in minutes
             */
            public final static String TRACKED_TIME = "pd_working_time";

            /**
             * Pause duration in minutes
             */
            public final static String PAUSE_DURATION = "pd_pause_duration";

            /**
             * Comment for the pause
             */
            public final static String COMMENT = "pd_comment";

            /**
             * Project is selectable on the UI [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String ACTIVE = "pd_active";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, PAUSE_TYPE, START_TIME, END_TIME, TRACKED_TIME, PAUSE_DURATION, COMMENT, ACTIVE};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Assigned Project Time Types
             */
            public final static String ASSIGNMENTS = "pd_count";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, ASSIGNMENTS);
         }

         /**
          * Pause definition data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the project table
       */
      public final static class ProjectTimeTypePauseDefinition {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "project_time_type_pause_definition";

			/* Public fields */
         /**
          * Project time type pause defintion data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Project time type pause defintion data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Project time type pause defintion data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the assigned project time type [INTEGER, Required]
             */
            public final static String PROJECT_TIME_TYPE_ID = "ptt_id";

            /**
             * ID of the assigned puase definition [INTEGER, Required]
             */
            public final static String PAUSE_DEFINITION_ID = "pd_id";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, PROJECT_TIME_TYPE_ID, PAUSE_DEFINITION_ID};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Display Name ('Project Name : Time Type Name')
             */
            public final static String DISPLAY_NAME = "pttpd_display_name";

            /**
             * ID of the assigned project
             */
            public final static String PROJECT_ID = "pj_id";
            /**
             * Name of the assigned project
             */
            public final static String PROJECT_NAME = "pj_name";

            /**
             * Description of the assigned project
             */
            public final static String PROJECT_DESCRIPTION = "pj_desc";

            /**
             * Active flag of the assigned project
             */
            public final static String PROJECT_ACTIVE = "pj_active";

            /**
             * ID of the assigned time type
             */
            public final static String TIME_TYPE_ID = "tt_id";

            /**
             * Kind of the assigned time type [INTEGER => TimeKind(Enumeration)]
             * <dl>
             * <dt>1</dt>
             * <dd>WorkingTime</dd>
             * <dt>2</dt>
             * <dd>Overtime</dd>
             * <dt>3</dt>
             * <dd>Holiday</dd>
             * </dl>
             */
            public final static String TIME_TYPE_KIND = "tt_kind";

            /**
             * Name of the assigned time type [String]
             */
            public final static String TIME_TYPE_NAME = "tt_name";

            /**
             * Description of the assigned time type [String]
             */
            public final static String TIME_TYPE_DESCRIPTION = "tt_desc";

            /**
             * Active flag of the assigned time type [INTEGER => BOOL (0: FALSE, 1: TRUE)]
             */
            public final static String TIME_TYPE_ACTIVE = "tt_active";

            /**
             * Pause type [INTEGER => PauseType(Enumeration), Required, Default 1]
             * <dl>
             * <dt>1</dt>
             * <dd>TimeBased: Based on time of the day (e.g.: pause between 11:00 and 11:30)</dd>
             * <dt>2</dt>
             * <dd>DurationBased: Based on the tracked time duration (e.g.: tracked time duration is 8 hours => 30 min pause)</dd>
             * </dl>
             */
            public final static String PAUSE_TYPE = "pd_pause_type";

            /**
             * Start time of the time based pause [String, ISO-8601, eg. '18:15']
             */
            public final static String PAUSE_START_TIME = "pd_start_time";

            /**
             * End time of the time based pause [String, ISO-8601, eg. '18:15']
             */
            public final static String PAUSE_END_TIME = "pd_end_time";

            /**
             * Tracked time of the duration based pause in minutes
             */
            public final static String TRACKED_TIME = "pd_working_time";

            /**
             * Pause duration in minutes
             */
            public final static String PAUSE_DURATION = "pd_pause_duration";

            /**
             * Comment for the pause
             */
            public final static String PAUSE_COMMENT = "pd_comment";

            /**
             * Project is selectable on the UI [INTEGER => BOOL (0: FALSE, 1: TRUE), Required, Default 1]
             */
            public final static String PAUSE_ACTIVE = "pd_active";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, DISPLAY_NAME, PROJECT_ID, PROJECT_NAME, PROJECT_DESCRIPTION, PROJECT_ACTIVE, TIME_TYPE_ID, TIME_TYPE_KIND, TIME_TYPE_NAME, TIME_TYPE_DESCRIPTION, TIME_TYPE_ACTIVE, PAUSE_TYPE, PAUSE_START_TIME, PAUSE_END_TIME, TRACKED_TIME, PAUSE_DURATION, PAUSE_COMMENT, PAUSE_ACTIVE);
         }

         /**
          * Project time type pause defintion data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

   }

   public final static class RecordData {

      /* Private fields */
      // base path for all record data
      private final static String _CATEGORY_DIRECTORY = "record_data";

      /**
       * Contract for the time record table
       */
      public final static class TimeRecord {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "time_record";

			/* Public fields */
         /**
          * Time Record data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Time Record data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Time Record data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         public static interface Actions {

            /**
             * Action fired by changing a record (new, update and delete)
             */
            public final static String ACTION_TIME_RECORD_CHANGED = _ACTION_BASE_PATH + "TIME_RECORD_CHANGED";
         }

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the assigned project time type [INTEGER, Required]
             */
            public final static String PROJECT_TIME_TYPE_ID = "ptt_id";

            /**
             * Start time for the time record [String, Required, ISO-8601, eg. '2013-11-27T18:15']
             */
            public final static String START_TIME = "tr_start_time";

            /**
             * End time for the time record [String, ISO-8601, eg. '2013-11-27T23:30']
             */
            public final static String END_TIME = "tr_end_time";

            /**
             * Comment for time record [String]
             */
            public final static String COMMENT = "tr_comment";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, PROJECT_TIME_TYPE_ID, START_TIME, END_TIME, COMMENT};
         }

         /**
          * Time Record data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);

         public static interface QueryColumns extends Columns {

            /**
             * Total sum of the time in minutes
             */
            public final static String TIME_SUM = "tr_time_sum";

            /**
             * Total sum of all pause time in minutes
             */
            public final static String PAUSE_SUM = "tr_pause_sum";

            /**
             * Total count of all pauses for the record
             */
            public final static String PAUSE_COUNT = "tr_pause_count";

            /**
             * ID of the assigned project
             */
            public final static String PROJECT_ID = "pj_id";

            /**
             * Name of the assigned project
             */
            public final static String PROJECT_NAME = "pj_name";

            /**
             * Description of the assigned project
             */
            public final static String PROJECT_DESCRIPTION = "pj_desc";

            /**
             * Active flag for the assigned project
             */
            public final static String PROJECT_ACTIVE = "pj_active";

            /**
             * ID of the assigned address
             */
            public final static String ADDRESS_ID = "ad_id";

            /**
             * Name of the assigned address
             */
            public final static String ADDRESS_NAME = "ad_name";

            /**
             * Active flag for the assigned address
             */
            public final static String ADDRESS_ACTIVE = "ad_active";

            /**
             * ID of the assigned time type
             */
            public final static String TIME_TYPE_ID = "tt_id";

            /**
             * Kind of the assigned time type
             */
            public final static String TIME_TYPE_KIND = "tt_kind";

            /**
             * Name of the assigned time type
             */
            public final static String TIME_TYPE_NAME = "tt_name";

            /**
             * Description of the assigned time type
             */
            public final static String TIME_TYPE_DESCRIPTION = "tt_desc";

            /**
             * Active flag of the assigned time type
             */
            public final static String TIME_TYPE_ACTIVE = "tt_active";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, TIME_SUM, PAUSE_SUM, PAUSE_COUNT, PROJECT_ID, PROJECT_NAME, PROJECT_DESCRIPTION, PROJECT_ACTIVE, ADDRESS_ID, ADDRESS_NAME, ADDRESS_ACTIVE, TIME_TYPE_ID, TIME_TYPE_KIND, TIME_TYPE_NAME, TIME_TYPE_DESCRIPTION, TIME_TYPE_ACTIVE);
         }


      }

      /**
       * Contract for the record pause table
       */
      public final static class RecordPause {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "record_pause";

			/* Public fields */
         /**
          * Record pause data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Record pause data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Record pause data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the assigned time record [INTEGER, Required]
             */
            public final static String TIME_RECORD_ID = "tr_id";

            /**
             * Start time for the record pause [String, Required, ISO-8601, eg. '2013-11-27T18:15']
             */
            public final static String START_TIME = "rp_start_time";

            /**
             * End time for the record pause [String, Required, ISO-8601 eg. '2013-11-27T23:30']
             */
            public final static String END_TIME = "rp_end_time";

            /**
             * Comment for record pause [String]
             */
            public final static String COMMENT = "rp_comment";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, TIME_RECORD_ID, START_TIME, END_TIME, COMMENT};
         }

         public static interface QueryColumns extends Columns {

            /**
             * Start time of the assigned time record
             */
            public final static String RECORD_START_TIME = "tr_start_time";

            /**
             * End time of the assigned time record
             */
            public final static String RECORD_END_TIME = "tr_end_time";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, RECORD_START_TIME, RECORD_END_TIME);
         }

         /**
          * Record pause data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }
   }

   public final static class ReportData {

      /* Private fields */
      // base path for all report data
      private final static String _CATEGORY_DIRECTORY = "report_data";

      /**
       * Contract for the report table
       */
      public final static class Report {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "report";

			/* Public fields */
         /**
          * Report data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Report data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Report data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Type of the report [INTEGER => ReportType(Enumeration), Default 2]
             * <dl>
             * <dt>SingleValue(1)</dt>
             * <dd>Report that returns only one value (such as sum, average, count of something)</dd>
             * <dt>Listing(2)</dt>
             * <dd>Report that returns a list as result</dd>
             * </dl>
             */
            public final static String TYPE = "rp_type";

            /**
             * Name of the report [String, Required, Unique]
             */
            public final static String NAME = "rp_name";

            /**
             * Description of the report
             */
            public final static String DESCRIPTION = "rp_desc";

            /**
             * Resource for the report generation (an existing view or SQL) [String, Required, Default 'view_report_base']
             */
            public final static String FROM = "rp_from";

            /**
             * Column names for the report to show [String] with needed aggregations, comma separated
             */
            public final static String PROJECTION = "rp_projection";

            /**
             * Base selection conditions (without the filter)
             */
            public final static String SELECTION = "rp_selection";

            /**
             * Parameter for condition, comma separated
             */
            public final static String SELECTION_ARGS = "rp_selection_args";

            /**
             * Group report by this columns, comma separated
             */
            public final static String GROUP_BY = "rp_group_by";

            /**
             * Sort report by this columns, comma separated
             */
            public final static String SORT_ORDER = "rp_sort_order";

            /**
             * Generated SQL for the report
             */
            public final static String SQL = "rp_sql";

            /**
             * Available filters for the report (will be added to the base condition). Parsable Filters are (will be saved in app configuration for the current report
             * <dl>
             * <dt>ADDRESS</dt>
             * <dd>Filter by address selected by user in filter box</dd>
             * <dt>PROJECT</dt>
             * <dd>Filter by project selected by user in filter box</dd>
             * <dt>TIMETYPE</dt>
             * <dd>Filter by time type selected by user in filter box</dd>
             * <dt>TIMEKIND</dt>
             * <dd>Filter by time kind selected by user in filter box</dd>
             * <dt>TIMERANGE</dt>
             * <dd>Filter by date range selected by user in filter box</dd>
             * </dl>
             */
            public final static String AVAILABLE_FILTER = "rp_available_filter";

            /**
             * Active flag for the report [INTEGER => BOOLEAN (0: FALSE, 1: TRUE), Default 1]
             */
            public final static String ACTIVE = "rp_active";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, TYPE, NAME, DESCRIPTION, FROM, PROJECTION, SELECTION, SELECTION_ARGS, GROUP_BY, SORT_ORDER, SQL, AVAILABLE_FILTER, ACTIVE};
         }

         /**
          * Report data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the report data (read only)
       */
      public final static class Data {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "data";

			/* Public fields */
         /**
          * Report data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Report data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Date of the report entry
             */
            public final static String DATE = "vbr_start_date";

            /**
             * Year of the report entry
             */
            public final static String YEAR = "vbr_start_year";

            /**
             * Month of the report entry
             */
            public final static String MONTH = "vbr_start_month";

            /**
             * Day of month of the report entry
             */
            public final static String DAY_OF_MONTH = "vbr_start_day";

            /**
             * Day of the year of the report entry
             */
            public final static String DAY_OF_YEAR = "vbr_start_day_of_year";

            /**
             * Day of week of the report entry
             */
            public final static String WEEKDAY = "vbr_start_day_of_week";

            /**
             * Week number of the report entry
             */
            public final static String WEEK_NUMBER = "vbr_iso_week_number";

            /**
             * Week year oth re report entry
             */
            public final static String WEEK_YEAR = "vbr_week_year";

            /**
             * Time sum for the report entry
             */
            public final static String TIME_SUM = "vbr_time_sum";

            /**
             * Pause sum for the report entry
             */
            public final static String PUASE_SUM = "vbr_pause_sum";

            /**
             * Overall sum for the report entry
             */
            public final static String OVERALL_SUM = "vbr_overall_sum";

            /**
             * Address ID
             */
            public final static String ADDRESS_ID = "ad_id";

            /**
             * Project ID
             */
            public final static String PROJECT_ID = "pj_id";

            /**
             * Time Type ID
             */
            public final static String TIME_TYPE_ID = "tt_id";

            /**
             * Time Kind
             */
            public final static String TIME_KIND = "tt_kind";
         }

         /**
          * Report data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the report data (read only)
       */
      public final static class Statistic {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "statistic";

			/* Public fields */
         /**
          * Report statistic directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Report ststistic list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Report statistic item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * ID of the issigned report [INTEGER, Required, only single value reports are allowed, exception on other types]
             */
            public final static String REPORT_ID = "rp_id";

            /**
             * Caption of the statistic
             */
            public final static String CAPTION = "st_caption";

            /**
             * Format of the duration [INTEGER => DurationFormat(Enumeration), Required, Default 1]
             * <dl>
             * <dt>1</dt>
             * <dd>Hours and minutes: HH:mm (e.g.: 02:15 or 40:30)</dd>
             * <dt>2</dt>
             * <dd>Days hours and minutes: d HH:mm (e.g: 20:20 or 5 17:30)</dd>
             * <dt>3</dt>
             * <dd>Minutes: mm (e.g: 245 or 5.318)</dd>
             * </dl>
             */
            public final static String DURATION_FORMAT = "st_duration_format";

            /**
             * Filter definition (WHERE clause)
             */
            public final static String FILTER = "st_filter";

            /**
             * Filter arguments (Parameters)
             */
            public final static String FILTER_ARGS = "st_filter_args";

            /**
             * Order of the statistic
             */
            public final static String ORDER = "st_order";

            /**
             * All time type available columns as array
             */
            public final static String[] ALL_COLUMNS = {_ID, REPORT_ID, CAPTION, DURATION_FORMAT, FILTER, FILTER_ARGS, ORDER};
         }

         public static interface QueryColumns extends Columns {

            /**
             * ID of the assigned report
             */
            public final static String REPORT_ID = "rp_id";

            /**
             * Projection of the report
             */
            public final static String REPORT_PROJECTION = Report.Columns.PROJECTION;

            /**
             * From of the report
             */
            public final static String REPORT_FROM = Report.Columns.FROM;

            /**
             * Group by of the report
             */
            public final static String REPORT_GROUP_BY = Report.Columns.GROUP_BY;

            /**
             * Selection of the report
             */
            public final static String REPORT_SELECTION = Report.Columns.SELECTION;

            /**
             * Selection args of the report
             */
            public final static String REPORT_SELECTION_ARGS = Report.Columns.SELECTION_ARGS;

            /**
             * All available columns for the query
             */
            public final static String[] ALL_QUERY_COLUMNS = concatArrays(ALL_COLUMNS, REPORT_ID, REPORT_PROJECTION, REPORT_FROM, REPORT_GROUP_BY, REPORT_SELECTION, REPORT_SELECTION_ARGS);
         }

         /**
          * Report statistic URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

      /**
       * Contract for the report statistic data (read only)
       */
      public final static class StatisticData {

         /* Private fields */
         private final static String _DATA_DIRECTORY = "statistic_data";

			/* Public fields */
         /**
          * Report statistic data directory
          */
         public final static String CONTENT_DIRECTORY = _CATEGORY_DIRECTORY + "/" + _DATA_DIRECTORY;
         /**
          * Report statistic data list type
          */
         public final static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + _DATA_DIRECTORY;
         /**
          * Report statistic data item type
          */
         public final static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + _DATA_DIRECTORY;

         /* Column Interfaces */
         public static interface Columns extends BaseColumns {

            /**
             * Caption of the statistic
             */
            public final static String CAPTION = "st_caption";

            /**
             * Order of the statistic
             */
            public final static String ORDER = "st_order";

            /**
             * Format of the duration [INTEGER => DurationFormat(Enumeration), Required, Default 1]
             * <dl>
             * <dt>1</dt>
             * <dd>Hours and minutes: HH:mm (e.g.: 02:15 or 40:30)</dd>
             * <dt>2</dt>
             * <dd>Days hours and minutes: d HH:mm (e.g: 20:20 or 5 17:30)</dd>
             * <dt>3</dt>
             * <dd>Minutes: mm (e.g: 245 or 5.318)</dd>
             * </dl>
             */
            public final static String DURATION_FORMAT = "st_duration_format";

            /**
             * Value of the statistic
             */
            public final static String VALUE = "st_value";

            /**
             * All available columns for the query
             */
            public final static String[] ALL_COLUMNS = {_ID, CAPTION, DURATION_FORMAT, ORDER, VALUE};
         }

         /**
          * Report statistic data URI
          */
         public final static Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);


      }

   }

}
