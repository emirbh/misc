/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ValueCashEnum
  import . "org_isda_cdm"
  /**
   * Details of how cash collateral is valued when resolving disputes.
   */
  
  const (
  /**
   * Cash - Amount thereof.
   */
  CASH_AMOUNT ValueCashEnum = iota + 1
  /**
   * Cash - amount thereof multiplied by Valuation Percentage.
   */
  CASH_PERCENTAGE ValueCashEnum = iota + 1
  /**
   * Cash - Amount Thereof multiplied by (Valuation Percentage - FX Haircut).
   */
  CASH_PERCENTAGE_LESS_HAIRCUT ValueCashEnum = iota + 1
  /**
   * Exception value.
   */
  OTHER ValueCashEnum = iota + 1
  )    
