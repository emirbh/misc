/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package AdditionalTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions.
   */
  
  const (
  /**
   * Single stock equity option or index option transaction as referred to in the transitional provisions (if any) of the EMIR RTS.
   */
  EQUITY_OPTION_OR_INDEX_OPTION AdditionalTypeEnum = iota + 1
  /**
   * No Additional Type of transaction is applicable to the regulatory regulatory regime.
   */
  NOT_APPLICABLE AdditionalTypeEnum = iota + 1
  OTHER AdditionalTypeEnum = iota + 1
  )    
