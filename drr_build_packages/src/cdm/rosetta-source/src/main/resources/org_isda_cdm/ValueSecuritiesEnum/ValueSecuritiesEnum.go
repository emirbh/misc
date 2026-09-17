/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ValueSecuritiesEnum
  import . "org_isda_cdm"
  /**
   * Details of how securities collateral is valued when resolving disputes.
   */
  
  const (
  /**
   * Securities collateral is valued using the bid price multiplied by the valuation percentage.
   */
  BID_PRICE_PERCENTAGE ValueSecuritiesEnum = iota + 1
  /**
   * Securities collateral is valued using the bid price multiplied by the valuation percentage less the FX haircut.
   */
  BID_PRICE_PERCENTAGE_LESS_HAIRCUT ValueSecuritiesEnum = iota + 1
  /**
   * Securities collateral is valued using the mid price multiplied by the valuation percentage.
   */
  MID_PRICE_PERCENTAGE ValueSecuritiesEnum = iota + 1
  /**
   * Securities collateral is valued using the mid price multiplied by the valuation percentage less the FX haircut.
   */
  MID_PRICE_PERCENTAGE_LESS_HAIRCUT ValueSecuritiesEnum = iota + 1
  /**
   * Exception value.
   */
  OTHER ValueSecuritiesEnum = iota + 1
  )    
