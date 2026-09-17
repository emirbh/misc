/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.23.0
 */
  package BrokerConfirmationTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type of Broker Confirm that the FpML trade represents.
   */
  
  const (
  /**
   * Broker Confirmation Type representing ABX index trades.
   */
  ABX BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Asia Corporate.
   */
  ASIA_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Asia Sovereign.
   */
  ASIA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Australia Corporate.
   */
  AUSTRALIA_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Australia Sovereign.
   */
  AUSTRALIA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for use with Credit Derivative Transactions on Leveraged Loans.
   */
  CD_SON_LEVERAGED_LOANS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
   */
  CD_SON_MBS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for CDX Emerging Markets Untranched Transactions.
   */
  CDX_EMERGING_MARKETS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for CDX Emerging Markets Diversified Untranched Transactions.
   */
  CDX_EMERGING_MARKETS_DIVERSIFIED BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for CDX Swaption Transactions.
   */
  CDX_SWAPTION BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Dow Jones CDX Tranche Transactions.
   */
  CDX_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type representing CMBX index trades.
   */
  CMBX BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.EM index series.
   */
  DJ_CDX_EM_ BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.NA.IG and Dow Jones CDX.NA.HY index series.
   */
  DJ_CDX_NA BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Emerging European and Middle Eastern Sovereign.
   */
  EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE.
   */
  EMERGING_EUROPEAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE LPN.
   */
  EMERGING_EUROPEAN_CORPORATE_LPN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Single Name European CMBS Transactions.
   */
  EUROPEAN_CMBS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of European Corporate.
   */
  EUROPEAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Single Name European RMBS Transactions.
   */
  EUROPEAN_RMBS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Japan Corporate.
   */
  JAPAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Japan Sovereign.
   */
  JAPAN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Latin America Corporate.
   */
  LATIN_AMERICA_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for LATIN AMERICA CORPORATE B.
   */
  LATIN_AMERICA_CORPORATE_BOND BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for LATIN AMERICA CORPORATE BL.
   */
  LATIN_AMERICA_CORPORATE_BOND_OR_LOAN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Latin America Sovereign.
   */
  LATIN_AMERICA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for MBX Transactions.
   */
  MBX BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Municipal CDX Untranched Transactions.
   */
  MCDX BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of New Zealand Corporate.
   */
  NEW_ZEALAND_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of New Zealand Sovereign.
   */
  NEW_ZEALAND_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker ConfirmationType of North American Corporate.
   */
  NORTH_AMERICAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for PO Index Transactions.
   */
  PO BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Singapore Corporate.
   */
  SINGAPORE_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Singapore Sovereign.
   */
  SINGAPORE_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD ASIA CORPORATE.
   */
  STANDARD_ASIA_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD ASIA SOVEREIGN.
   */
  STANDARD_ASIA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD AUSTRALIA CORPORATE.
   */
  STANDARD_AUSTRALIA_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD AUSTRALIA SOVEREIGN.
   */
  STANDARD_AUSTRALIA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Standard CDX Tranche Transactions.
   */
  STANDARD_CDX_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
   */
  STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE.
   */
  STANDARD_EMERGING_EUROPEAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
   */
  STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for STANDARD EUROPEAN CORPORATE.
   */
  STANDARD_EUROPEAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD JAPAN CORPORATE.
   */
  STANDARD_JAPAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD JAPAN SOVEREIGN.
   */
  STANDARD_JAPAN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Standard Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
   */
  STANDARD_LCDS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
   */
  STANDARD_LCDS_BULLET BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
   */
  STANDARD_LCDX_BULLET BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
   */
  STANDARD_LCDX_BULLET_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE B.
   */
  STANDARD_LATIN_AMERICA_CORPORATE_BOND BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE BL.
   */
  STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD LATIN AMERICA SOVEREIGN.
   */
  STANDARD_LATIN_AMERICA_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD NEW ZEALAND CORPORATE.
   */
  STANDARD_NEW_ZEALAND_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD NEW ZEALAND SOVEREIGN.
   */
  STANDARD_NEW_ZEALAND_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for STANDARD NORTH AMERICAN CORPORATE.
   */
  STANDARD_NORTH_AMERICAN_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD SINGAPORE CORPORATE.
   */
  STANDARD_SINGAPORE_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of STANDARD SINGAPORE SOVEREIGN.
   */
  STANDARD_SINGAPORE_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
   */
  STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for STANDARD WESTERN EUROPEAN SOVEREIGN.
   */
  STANDARD_WESTERN_EUROPEAN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for Standard iTraxx Europe Tranched Transactions.
   */
  STANDARDI_TRAXX_EUROPE_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Subordinated European Insurance Corporate.
   */
  SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of SUKUK CORPORATE.
   */
  SUKUK_CORPORATE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of SUKUK SOVEREIGN.
   */
  SUKUK_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
   */
  SYNDICATED_SECURED_LOAN_CDS BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for TRX Transactions.
   */
  TRX BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for TRX.II Transactions.
   */
  TRX_II BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for U.S. MUNICIPAL FULL FAITH AND CREDIT.
   */
  US_MUNICIPAL_FULL_FAITH_AND_CREDIT BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for U.S. MUNICIPAL GENERAL FUND.
   */
  US_MUNICIPAL_GENERAL_FUND BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for U.S. MUNICIPAL REVENUE.
   */
  US_MUNICIPAL_REVENUE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type of Western European Sovereign.
   */
  WESTERN_EUROPEAN_SOVEREIGN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Asia Excluding Japan.
   */
  I_TRAXX_ASIA_EX_JAPAN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Asia Ex-Japan Swaption Transactions.
   */
  I_TRAXX_ASIA_EX_JAPAN_SWAPTION BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Asia Excluding Japan Tranched Transactions.
   */
  I_TRAXX_ASIA_EX_JAPAN_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Australia.
   */
  I_TRAXX_AUSTRALIA BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Australia Swaption Transactions.
   */
  I_TRAXX_AUSTRALIA_SWAPTION BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Australia Tranched Transactions.
   */
  I_TRAXX_AUSTRALIA_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx CJ.
   */
  I_TRAXX_CJ BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx CJ Tranched Transactions.
   */
  I_TRAXX_CJ_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Europe Transactions
   */
  I_TRAXX_EUROPE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Europe Swaption Transactions.
   */
  I_TRAXX_EUROPE_SWAPTION BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Europe Tranched Transactions.
   */
  I_TRAXX_EUROPE_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Japan.
   */
  I_TRAXX_JAPAN BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Japan Swaption Transactions.
   */
  I_TRAXX_JAPAN_SWAPTION BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx Japan Tranched Transactions.
   */
  I_TRAXX_JAPAN_TRANCHE BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx LevX.
   */
  I_TRAXX_LEV_X BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx SDI 75 Transactions.
   */
  I_TRAXX_SDI_75 BrokerConfirmationTypeEnum = iota + 1
  /**
   * Broker Confirmation Type for iTraxx SovX.
   */
  I_TRAXX_SOV_X BrokerConfirmationTypeEnum = iota + 1
  )    
