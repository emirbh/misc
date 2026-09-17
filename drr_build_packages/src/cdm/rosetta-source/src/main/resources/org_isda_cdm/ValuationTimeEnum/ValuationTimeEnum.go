/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ValuationTimeEnum
  import . "org_isda_cdm"
  /**
   * The type of time specified for the Valuation Time.
   */
  
  const (
  /**
   * The valuation time should be as selected.
   */
  AS_SELECTED ValuationTimeEnum = iota + 1
  /**
   * The valuation time should be at close of business.
   */
  CLOSE_OF_BUSINESS ValuationTimeEnum = iota + 1
  /**
   * The valuation time should be at a specific time.
   */
  SPECIFIC_TIME ValuationTimeEnum = iota + 1
  )    
