/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package SimmExceptionApplicableEnum
  import . "org_isda_cdm"
  /**
   * Values to specify the SIMM normalized exception approaches.
   */
  
  const (
  /**
   * The ISDA Standard Initial Margin Model exception is applicable as a Fallback to Mandatory Method.
   */
  FALL_BACK_TO_MANDATORY_METHOD SimmExceptionApplicableEnum = iota + 1
  /**
   * The ISDA Standard Initial Margin Model exception is applicable as a Mandatory Method.
   */
  MANDATORY_METHOD SimmExceptionApplicableEnum = iota + 1
  /**
   * An alternative approach is described in the document.
   */
  OTHER_METHOD SimmExceptionApplicableEnum = iota + 1
  )    
