/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package NumberOfRatingAgenciesEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to define the number of Rating Agencies that must be considered to meet the rating condition.
   */
  
  const (
  /**
   * Ratings for all defined Rating Agencies will be considered.
   */
  ALL NumberOfRatingAgenciesEnum = iota + 1
  /**
   * Ratings for Any 1 stated Rating Agency will be applicable.
   */
  ANY_ONE NumberOfRatingAgenciesEnum = iota + 1
  /**
   * Ratings for Any 2 stated Rating Agencies will be applicable.
   */
  ANY_TWO NumberOfRatingAgenciesEnum = iota + 1
  /**
   * Utilised where the clause data structure is not able to capture a material aspect of the clause.
   */
  OTHER NumberOfRatingAgenciesEnum = iota + 1
  )    
