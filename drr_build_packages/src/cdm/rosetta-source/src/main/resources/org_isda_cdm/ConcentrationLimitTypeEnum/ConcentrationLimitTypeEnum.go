/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ConcentrationLimitTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumerated values to identify where a concentration limit is applied in the eligible collateral schedule.
   */
  
  const (
  /**
   * Specifies a limit on a single asset in the eligible collateral schedule
   */
  ASSET ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on all cash valued in the base currency of the eligible collateral schedule.
   */
  BASE_CURRENCY_EQUIVALENT ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single industry sector in the eligible collateral schedule.
   */
  INDUSTRY_SECTOR ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
   */
  ISSUE_OUTSTANDING_AMOUNT ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single issuer in the eligible collateral schedule.
   */
  ISSUER ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
   */
  MARKET_CAPITALISATION ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single exchange in the eligible collateral schedule.
   */
  PRIMARY_EXCHANGE ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single issuer in the eligible collateral schedule at the ultimate parent institution level.
   */
  ULTIMATE_PARENT_INSTITUTION ConcentrationLimitTypeEnum = iota + 1
  )    
