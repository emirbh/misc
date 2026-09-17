/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ValuationDateDayEnum
  import . "org_isda_cdm"
  /**
   * Defines the conditions for the day for a Valuation Date.
   */
  
  const (
  /**
   * The Date can be a given day on the regular calendar.
   */
  CALENDAR_DAY ValuationDateDayEnum = iota + 1
  /**
   * Friday
   */
  FRI ValuationDateDayEnum = iota + 1
  /**
   * The Date must be a day on which commercial banks are open for general business in the local market.
   */
  LOCAL_BUSINESS_DAY ValuationDateDayEnum = iota + 1
  /**
   * Monday
   */
  MON ValuationDateDayEnum = iota + 1
  /**
   * The Date must be a New York Banking Day, that is a day, other than a Saturday or Sunday, on which banks are open for general commercial business in New York, USA.
   */
  NEW_YORK_BANKING_DAY ValuationDateDayEnum = iota + 1
  /**
   * Saturday
   */
  SAT ValuationDateDayEnum = iota + 1
  /**
   * Sunday
   */
  SUN ValuationDateDayEnum = iota + 1
  /**
   * Thursday
   */
  THU ValuationDateDayEnum = iota + 1
  /**
   * Tuesday
   */
  TUE ValuationDateDayEnum = iota + 1
  /**
   * Wednesday
   */
  WED ValuationDateDayEnum = iota + 1
  )    
