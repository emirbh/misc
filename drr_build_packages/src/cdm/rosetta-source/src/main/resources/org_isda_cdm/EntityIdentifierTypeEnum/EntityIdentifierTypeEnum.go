/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package EntityIdentifierTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumeration values associated with legal entity identifier sources.
   */
  
  const (
  /**
   * The Bank Identifier Code.
   */
  BIC EntityIdentifierTypeEnum = iota + 1
  /**
   * The ISO 3166 Country Code.
   */
  COUNTRY_CODE EntityIdentifierTypeEnum = iota + 1
  /**
   * The ISO 17442:2012 Legal Entity Identifier.
   */
  LEI EntityIdentifierTypeEnum = iota + 1
  /**
   * The ISO 10383 Market Identifier Code (MIC).
   */
  MIC EntityIdentifierTypeEnum = iota + 1
  /**
   * Used when the identifier type is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
   */
  OTHER EntityIdentifierTypeEnum = iota + 1
  /**
   * The Reference Entity Database identifier.
   */
  REDID EntityIdentifierTypeEnum = iota + 1
  )    
