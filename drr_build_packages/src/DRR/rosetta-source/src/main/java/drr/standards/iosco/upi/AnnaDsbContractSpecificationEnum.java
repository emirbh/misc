package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbContractSpecificationEnum")
public enum AnnaDsbContractSpecificationEnum {

	/**
	 * Matrix Transaction Type of ASIA CORPORATE.
	 */
	@RosettaEnumValue(value = "AsiaCorporate", displayName = "AsiaCorporate") 
	ASIA_CORPORATE("AsiaCorporate", "AsiaCorporate"),
	
	/**
	 * Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "AsiaFinancialCorporate", displayName = "AsiaFinancialCorporate") 
	ASIA_FINANCIAL_CORPORATE("AsiaFinancialCorporate", "AsiaFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of ASIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "AsiaSovereign", displayName = "AsiaSovereign") 
	ASIA_SOVEREIGN("AsiaSovereign", "AsiaSovereign"),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA CORPORATE.
	 */
	@RosettaEnumValue(value = "AustraliaCorporate", displayName = "AustraliaCorporate") 
	AUSTRALIA_CORPORATE("AustraliaCorporate", "AustraliaCorporate"),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "AustraliaFinancialCorporate", displayName = "AustraliaFinancialCorporate") 
	AUSTRALIA_FINANCIAL_CORPORATE("AustraliaFinancialCorporate", "AustraliaFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "AustraliaSovereign", displayName = "AustraliaSovereign") 
	AUSTRALIA_SOVEREIGN("AustraliaSovereign", "AustraliaSovereign"),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanAndMiddleEasternSovereign", displayName = "EmergingEuropeanAndMiddleEasternSovereign") 
	EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("EmergingEuropeanAndMiddleEasternSovereign", "EmergingEuropeanAndMiddleEasternSovereign"),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporate", displayName = "EmergingEuropeanCorporate") 
	EMERGING_EUROPEAN_CORPORATE("EmergingEuropeanCorporate", "EmergingEuropeanCorporate"),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporateLPN", displayName = "EmergingEuropeanCorporateLPN") 
	EMERGING_EUROPEAN_CORPORATE_LPN("EmergingEuropeanCorporateLPN", "EmergingEuropeanCorporateLPN"),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanFinancialCorporate", displayName = "EmergingEuropeanFinancialCorporate") 
	EMERGING_EUROPEAN_FINANCIAL_CORPORATE("EmergingEuropeanFinancialCorporate", "EmergingEuropeanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanFinancialCorporateLPN", displayName = "EmergingEuropeanFinancialCorporateLPN") 
	EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN("EmergingEuropeanFinancialCorporateLPN", "EmergingEuropeanFinancialCorporateLPN"),
	
	/**
	 * Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanCoCoFinancialCorporate", displayName = "EuropeanCoCoFinancialCorporate") 
	EUROPEAN_CO_CO_FINANCIAL_CORPORATE("EuropeanCoCoFinancialCorporate", "EuropeanCoCoFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanCorporate", displayName = "EuropeanCorporate") 
	EUROPEAN_CORPORATE("EuropeanCorporate", "EuropeanCorporate"),
	
	/**
	 * Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanFinancialCorporate", displayName = "EuropeanFinancialCorporate") 
	EUROPEAN_FINANCIAL_CORPORATE("EuropeanFinancialCorporate", "EuropeanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of EUROPEAN LIMITED RECOURSE CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanLimitedRecourseCorporate", displayName = "EuropeanLimitedRecourseCorporate") 
	EUROPEAN_LIMITED_RECOURSE_CORPORATE("EuropeanLimitedRecourseCorporate", "EuropeanLimitedRecourseCorporate"),
	
	/**
	 * Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanSeniorNonPreferredFinancialCorporate", displayName = "EuropeanSeniorNonPreferredFinancialCorporate") 
	EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE("EuropeanSeniorNonPreferredFinancialCorporate", "EuropeanSeniorNonPreferredFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of JAPAN CORPORATE.
	 */
	@RosettaEnumValue(value = "JapanCorporate", displayName = "JapanCorporate") 
	JAPAN_CORPORATE("JapanCorporate", "JapanCorporate"),
	
	/**
	 * Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "JapanFinancialCorporate", displayName = "JapanFinancialCorporate") 
	JAPAN_FINANCIAL_CORPORATE("JapanFinancialCorporate", "JapanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of JAPAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "JapanSovereign", displayName = "JapanSovereign") 
	JAPAN_SOVEREIGN("JapanSovereign", "JapanSovereign"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporate", displayName = "LatinAmericaCorporate") 
	LATIN_AMERICA_CORPORATE("LatinAmericaCorporate", "LatinAmericaCorporate"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBond", displayName = "LatinAmericaCorporateBond") 
	LATIN_AMERICA_CORPORATE_BOND("LatinAmericaCorporateBond", "LatinAmericaCorporateBond"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBondOrLoan", displayName = "LatinAmericaCorporateBondOrLoan") 
	LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("LatinAmericaCorporateBondOrLoan", "LatinAmericaCorporateBondOrLoan"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
	 */
	@RosettaEnumValue(value = "LatinAmericaFinancialCorporateBond", displayName = "LatinAmericaFinancialCorporateBond") 
	LATIN_AMERICA_FINANCIAL_CORPORATE_BOND("LatinAmericaFinancialCorporateBond", "LatinAmericaFinancialCorporateBond"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
	 */
	@RosettaEnumValue(value = "LatinAmericaFinancialCorporateBondOrLoan", displayName = "LatinAmericaFinancialCorporateBondOrLoan") 
	LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN("LatinAmericaFinancialCorporateBondOrLoan", "LatinAmericaFinancialCorporateBondOrLoan"),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "LatinAmericaSovereign", displayName = "LatinAmericaSovereign") 
	LATIN_AMERICA_SOVEREIGN("LatinAmericaSovereign", "LatinAmericaSovereign"),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND CORPORATE.
	 */
	@RosettaEnumValue(value = "NewZealandCorporate", displayName = "NewZealandCorporate") 
	NEW_ZEALAND_CORPORATE("NewZealandCorporate", "NewZealandCorporate"),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "NewZealandFinancialCorporate", displayName = "NewZealandFinancialCorporate") 
	NEW_ZEALAND_FINANCIAL_CORPORATE("NewZealandFinancialCorporate", "NewZealandFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
	 */
	@RosettaEnumValue(value = "NewZealandSovereign", displayName = "NewZealandSovereign") 
	NEW_ZEALAND_SOVEREIGN("NewZealandSovereign", "NewZealandSovereign"),
	
	/**
	 * Matrix Transaction Type of NORTH AMERICAN CORPORATE.
	 */
	@RosettaEnumValue(value = "NorthAmericanCorporate", displayName = "NorthAmericanCorporate") 
	NORTH_AMERICAN_CORPORATE("NorthAmericanCorporate", "NorthAmericanCorporate"),
	
	/**
	 * Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "NorthAmericanFinancialCorporate", displayName = "NorthAmericanFinancialCorporate") 
	NORTH_AMERICAN_FINANCIAL_CORPORATE("NorthAmericanFinancialCorporate", "NorthAmericanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of SINGAPORE CORPORATE.
	 */
	@RosettaEnumValue(value = "SingaporeCorporate", displayName = "SingaporeCorporate") 
	SINGAPORE_CORPORATE("SingaporeCorporate", "SingaporeCorporate"),
	
	/**
	 * Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "SingaporeFinancialCorporate", displayName = "SingaporeFinancialCorporate") 
	SINGAPORE_FINANCIAL_CORPORATE("SingaporeFinancialCorporate", "SingaporeFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of SINGAPORE SOVEREIGN.
	 */
	@RosettaEnumValue(value = "SingaporeSovereign", displayName = "SingaporeSovereign") 
	SINGAPORE_SOVEREIGN("SingaporeSovereign", "SingaporeSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAsiaCorporate", displayName = "StandardAsiaCorporate") 
	STANDARD_ASIA_CORPORATE("StandardAsiaCorporate", "StandardAsiaCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAsiaFinancialCorporate", displayName = "StandardAsiaFinancialCorporate") 
	STANDARD_ASIA_FINANCIAL_CORPORATE("StandardAsiaFinancialCorporate", "StandardAsiaFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAsiaSovereign", displayName = "StandardAsiaSovereign") 
	STANDARD_ASIA_SOVEREIGN("StandardAsiaSovereign", "StandardAsiaSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAustraliaCorporate", displayName = "StandardAustraliaCorporate") 
	STANDARD_AUSTRALIA_CORPORATE("StandardAustraliaCorporate", "StandardAustraliaCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAustraliaFinancialCorporate", displayName = "StandardAustraliaFinancialCorporate") 
	STANDARD_AUSTRALIA_FINANCIAL_CORPORATE("StandardAustraliaFinancialCorporate", "StandardAustraliaFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAustraliaSovereign", displayName = "StandardAustraliaSovereign") 
	STANDARD_AUSTRALIA_SOVEREIGN("StandardAustraliaSovereign", "StandardAustraliaSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanAndMiddleEasternSovereign", displayName = "StandardEmergingEuropeanAndMiddleEasternSovereign") 
	STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("StandardEmergingEuropeanAndMiddleEasternSovereign", "StandardEmergingEuropeanAndMiddleEasternSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporate", displayName = "StandardEmergingEuropeanCorporate") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE("StandardEmergingEuropeanCorporate", "StandardEmergingEuropeanCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporateLPN", displayName = "StandardEmergingEuropeanCorporateLPN") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN("StandardEmergingEuropeanCorporateLPN", "StandardEmergingEuropeanCorporateLPN"),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanFinancialCorporate", displayName = "StandardEmergingEuropeanFinancialCorporate") 
	STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE("StandardEmergingEuropeanFinancialCorporate", "StandardEmergingEuropeanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanFinancialCorporateLPN", displayName = "StandardEmergingEuropeanFinancialCorporateLPN") 
	STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN("StandardEmergingEuropeanFinancialCorporateLPN", "StandardEmergingEuropeanFinancialCorporateLPN"),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanCoCoFinancialCorporate", displayName = "StandardEuropeanCoCoFinancialCorporate") 
	STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE("StandardEuropeanCoCoFinancialCorporate", "StandardEuropeanCoCoFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanCorporate", displayName = "StandardEuropeanCorporate") 
	STANDARD_EUROPEAN_CORPORATE("StandardEuropeanCorporate", "StandardEuropeanCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanFinancialCorporate", displayName = "StandardEuropeanFinancialCorporate") 
	STANDARD_EUROPEAN_FINANCIAL_CORPORATE("StandardEuropeanFinancialCorporate", "StandardEuropeanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN LIMITED RECOURSE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanLimitedRecourseCorporate", displayName = "StandardEuropeanLimitedRecourseCorporate") 
	STANDARD_EUROPEAN_LIMITED_RECOURSE_CORPORATE("StandardEuropeanLimitedRecourseCorporate", "StandardEuropeanLimitedRecourseCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanSeniorNonPreferredFinancialCorporate", displayName = "StandardEuropeanSeniorNonPreferredFinancialCorporate") 
	STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE("StandardEuropeanSeniorNonPreferredFinancialCorporate", "StandardEuropeanSeniorNonPreferredFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardJapanCorporate", displayName = "StandardJapanCorporate") 
	STANDARD_JAPAN_CORPORATE("StandardJapanCorporate", "StandardJapanCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardJapanFinancialCorporate", displayName = "StandardJapanFinancialCorporate") 
	STANDARD_JAPAN_FINANCIAL_CORPORATE("StandardJapanFinancialCorporate", "StandardJapanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardJapanSovereign", displayName = "StandardJapanSovereign") 
	STANDARD_JAPAN_SOVEREIGN("StandardJapanSovereign", "StandardJapanSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBond", displayName = "StandardLatinAmericaCorporateBond") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND("StandardLatinAmericaCorporateBond", "StandardLatinAmericaCorporateBond"),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBondOrLoan", displayName = "StandardLatinAmericaCorporateBondOrLoan") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("StandardLatinAmericaCorporateBondOrLoan", "StandardLatinAmericaCorporateBondOrLoan"),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaFinancialCorporateBond", displayName = "StandardLatinAmericaFinancialCorporateBond") 
	STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND("StandardLatinAmericaFinancialCorporateBond", "StandardLatinAmericaFinancialCorporateBond"),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaFinancialCorporateBondOrLoan", displayName = "StandardLatinAmericaFinancialCorporateBondOrLoan") 
	STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN("StandardLatinAmericaFinancialCorporateBondOrLoan", "StandardLatinAmericaFinancialCorporateBondOrLoan"),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaSovereign", displayName = "StandardLatinAmericaSovereign") 
	STANDARD_LATIN_AMERICA_SOVEREIGN("StandardLatinAmericaSovereign", "StandardLatinAmericaSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNewZealandCorporate", displayName = "StandardNewZealandCorporate") 
	STANDARD_NEW_ZEALAND_CORPORATE("StandardNewZealandCorporate", "StandardNewZealandCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNewZealandFinancialCorporate", displayName = "StandardNewZealandFinancialCorporate") 
	STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE("StandardNewZealandFinancialCorporate", "StandardNewZealandFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardNewZealandSovereign", displayName = "StandardNewZealandSovereign") 
	STANDARD_NEW_ZEALAND_SOVEREIGN("StandardNewZealandSovereign", "StandardNewZealandSovereign"),
	
	/**
	 * Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNorthAmericanCorporate", displayName = "StandardNorthAmericanCorporate") 
	STANDARD_NORTH_AMERICAN_CORPORATE("StandardNorthAmericanCorporate", "StandardNorthAmericanCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNorthAmericanFinancialCorporate", displayName = "StandardNorthAmericanFinancialCorporate") 
	STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE("StandardNorthAmericanFinancialCorporate", "StandardNorthAmericanFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSingaporeCorporate", displayName = "StandardSingaporeCorporate") 
	STANDARD_SINGAPORE_CORPORATE("StandardSingaporeCorporate", "StandardSingaporeCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSingaporeFinancialCorporate", displayName = "StandardSingaporeFinancialCorporate") 
	STANDARD_SINGAPORE_FINANCIAL_CORPORATE("StandardSingaporeFinancialCorporate", "StandardSingaporeFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardSingaporeSovereign", displayName = "StandardSingaporeSovereign") 
	STANDARD_SINGAPORE_SOVEREIGN("StandardSingaporeSovereign", "StandardSingaporeSovereign"),
	
	/**
	 * Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSubordinatedEuropeanInsuranceCorporate", displayName = "StandardSubordinatedEuropeanInsuranceCorporate") 
	STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("StandardSubordinatedEuropeanInsuranceCorporate", "StandardSubordinatedEuropeanInsuranceCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSukukFinancialCorporate", displayName = "StandardSukukFinancialCorporate") 
	STANDARD_SUKUK_FINANCIAL_CORPORATE("StandardSukukFinancialCorporate", "StandardSukukFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalFullFaithAndCredit", displayName = "StandardUSMunicipalFullFaithAndCredit") 
	STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT("StandardUSMunicipalFullFaithAndCredit", "StandardUSMunicipalFullFaithAndCredit"),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalGeneralFund", displayName = "StandardUSMunicipalGeneralFund") 
	STANDARD_US_MUNICIPAL_GENERAL_FUND("StandardUSMunicipalGeneralFund", "StandardUSMunicipalGeneralFund"),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalRevenue", displayName = "StandardUSMunicipalRevenue") 
	STANDARD_US_MUNICIPAL_REVENUE("StandardUSMunicipalRevenue", "StandardUSMunicipalRevenue"),
	
	/**
	 * Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardWesternEuropeanSovereign", displayName = "StandardWesternEuropeanSovereign") 
	STANDARD_WESTERN_EUROPEAN_SOVEREIGN("StandardWesternEuropeanSovereign", "StandardWesternEuropeanSovereign"),
	
	/**
	 * Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	@RosettaEnumValue(value = "SubordinatedEuropeanInsuranceCorporate", displayName = "SubordinatedEuropeanInsuranceCorporate") 
	SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("SubordinatedEuropeanInsuranceCorporate", "SubordinatedEuropeanInsuranceCorporate"),
	
	/**
	 * Matrix Transaction Type of SUKUK CORPORATE.
	 */
	@RosettaEnumValue(value = "SukukCorporate", displayName = "SukukCorporate") 
	SUKUK_CORPORATE("SukukCorporate", "SukukCorporate"),
	
	/**
	 * Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "SukukFinancialCorporate", displayName = "SukukFinancialCorporate") 
	SUKUK_FINANCIAL_CORPORATE("SukukFinancialCorporate", "SukukFinancialCorporate"),
	
	/**
	 * Matrix Transaction Type of SUKUK SOVEREIGN.
	 */
	@RosettaEnumValue(value = "SukukSovereign", displayName = "SukukSovereign") 
	SUKUK_SOVEREIGN("SukukSovereign", "SukukSovereign"),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	@RosettaEnumValue(value = "USMunicipalFullFaithAndCredit", displayName = "USMunicipalFullFaithAndCredit") 
	US_MUNICIPAL_FULL_FAITH_AND_CREDIT("USMunicipalFullFaithAndCredit", "USMunicipalFullFaithAndCredit"),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
	 */
	@RosettaEnumValue(value = "USMunicipalGeneralFund", displayName = "USMunicipalGeneralFund") 
	US_MUNICIPAL_GENERAL_FUND("USMunicipalGeneralFund", "USMunicipalGeneralFund"),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
	 */
	@RosettaEnumValue(value = "USMunicipalRevenue", displayName = "USMunicipalRevenue") 
	US_MUNICIPAL_REVENUE("USMunicipalRevenue", "USMunicipalRevenue"),
	
	/**
	 * Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "WesternEuropeanSovereign", displayName = "WesternEuropeanSovereign") 
	WESTERN_EUROPEAN_SOVEREIGN("WesternEuropeanSovereign", "WesternEuropeanSovereign")
;
	private static Map<String, AnnaDsbContractSpecificationEnum> values;
	static {
        Map<String, AnnaDsbContractSpecificationEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbContractSpecificationEnum instance : AnnaDsbContractSpecificationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbContractSpecificationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbContractSpecificationEnum fromDisplayName(String name) {
		AnnaDsbContractSpecificationEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
