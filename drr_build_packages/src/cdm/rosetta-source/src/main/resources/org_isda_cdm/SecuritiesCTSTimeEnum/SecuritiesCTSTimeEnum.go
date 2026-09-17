/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package SecuritiesCTSTimeEnum
  import . "org_isda_cdm"
  /**
   * Details the day on which securities collateral is required to be transferred relative to the Notification Time.
   */
  
  const (
  /**
   * The securities collateral should be transferred on the first local business day.
   */
  FIRST_DAY SecuritiesCTSTimeEnum = iota + 1
  /**
   * The securities collateral should be transferred on the next day.
   */
  NEXT SecuritiesCTSTimeEnum = iota + 1
  /**
   * Exception value.
   */
  OTHER SecuritiesCTSTimeEnum = iota + 1
  /**
   * The securities collateral should be transferred on the same day.
   */
  SAME SecuritiesCTSTimeEnum = iota + 1
  /**
   * The securities collateral should be transferred on the second local business day.
   */
  SECOND_DAY SecuritiesCTSTimeEnum = iota + 1
  /**
   * The securities collateral should be transferred on the third local business day.
   */
  THIRD_DAY SecuritiesCTSTimeEnum = iota + 1
  )    
