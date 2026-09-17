/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package ThresholdZeroEventEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values for defining the relevant trigger(s) for the threshold to fall to zero.
   */
  
  const (
  /**
   * An Additional Termination Event (ATE).
   */
  ADDITIONAL_TERMINATION_EVENT ThresholdZeroEventEnum = iota + 1
  /**
   * An Event of Default.
   */
  EVENT_OF_DEFAULT ThresholdZeroEventEnum = iota + 1
  /**
   * Utilised where the clause data structure is not able to capture a material aspect of the clause.
   */
  OTHER ThresholdZeroEventEnum = iota + 1
  /**
   * A Potential Event of Default.
   */
  POTENTIAL_EVENT_OF_DEFAULT ThresholdZeroEventEnum = iota + 1
  /**
   * A Termination Event.
   */
  TERMINATION_EVENT ThresholdZeroEventEnum = iota + 1
  /**
   * A Termination Event in respect of which all Transactions are Affected Transactions.
   */
  TERMINATION_EVENT_ALL_AFFECTED_TRANSACTIONS ThresholdZeroEventEnum = iota + 1
  )    
