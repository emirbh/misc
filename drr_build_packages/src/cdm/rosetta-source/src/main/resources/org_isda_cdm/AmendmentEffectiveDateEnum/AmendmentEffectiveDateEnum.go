/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package AmendmentEffectiveDateEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the effective date of the Amendment to Termination Currency when specified as a specific date (e.g. the annex date).
   */
  
  const (
  /**
   * The effective date corresponds to the Agreement date.
   */
  AGREEMENT_DATE AmendmentEffectiveDateEnum = iota + 1
  /**
   * The effective date corresponds to the Amendment Effective Date (IM).
   */
  AMENDMENT_EFFECTIVE_DATE AmendmentEffectiveDateEnum = iota + 1
  /**
   * The effective date corresponds to the Annex date.
   */
  ANNEX_DATE AmendmentEffectiveDateEnum = iota + 1
  /**
   * The effective date corresponds to the Deed date.
   */
  DEED_DATE AmendmentEffectiveDateEnum = iota + 1
  )    
