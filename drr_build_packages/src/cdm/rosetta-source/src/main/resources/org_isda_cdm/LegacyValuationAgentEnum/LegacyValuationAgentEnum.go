/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package LegacyValuationAgentEnum
  import . "org_isda_cdm"
  /**
   * Specifies how the Valuation Agent is determined.
   */
  
  const (
  /**
   * There is a fixed party for disputes.
   */
  FIXED_PARTY_FOR_DISPUTES LegacyValuationAgentEnum = iota + 1
  /**
   * There is only a Sole Valuation Agent.
   */
  SOLE_VALUATION_AGENT LegacyValuationAgentEnum = iota + 1
  /**
   * Switch of Valuation Agent can occur upon Default.
   */
  SWITCH_UPON_DEFAULT LegacyValuationAgentEnum = iota + 1
  /**
   * Switch of Valuation Agent can occur upon failure to perform.
   */
  SWITCH_UPON_FAILURE_TO_PERFORM LegacyValuationAgentEnum = iota + 1
  )    
