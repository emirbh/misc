/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package CashCTSTimeEnum
  import . "org_isda_cdm"
  /**
   * Details the day on which cash collateral is required to be transferred relative to the Notification Time.
   */
  
  const (
  /**
   * The cash collateral should be transferred on the first local business day.
   */
  FIRST_LBD CashCTSTimeEnum = iota + 1
  /**
   * The cash collateral should be transferred on the next day.
   */
  NEXT CashCTSTimeEnum = iota + 1
  /**
   * Exception value.
   */
  OTHER CashCTSTimeEnum = iota + 1
  /**
   * The cash collateral should be transferred on the same day.
   */
  SAME CashCTSTimeEnum = iota + 1
  /**
   * The cash collateral should be transferred on the second local business day.
   */
  SECOND_LBD CashCTSTimeEnum = iota + 1
  )    
