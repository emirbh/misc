package cdm.legaldocumentation.transaction;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the type of Broker Confirm that the FpML trade represents.
 * @version 6.23.0
 */
@RosettaEnum("BrokerConfirmationTypeEnum")
public enum BrokerConfirmationTypeEnum {

	/**
	 * Broker Confirmation Type representing ABX index trades.
	 */
	@RosettaEnumValue(value = "ABX") 
	ABX("ABX", null),
	
	/**
	 * Broker Confirmation Type of Asia Corporate.
	 */
	@RosettaEnumValue(value = "AsiaCorporate") 
	ASIA_CORPORATE("AsiaCorporate", null),
	
	/**
	 * Broker Confirmation Type of Asia Sovereign.
	 */
	@RosettaEnumValue(value = "AsiaSovereign") 
	ASIA_SOVEREIGN("AsiaSovereign", null),
	
	/**
	 * Broker Confirmation Type of Australia Corporate.
	 */
	@RosettaEnumValue(value = "AustraliaCorporate") 
	AUSTRALIA_CORPORATE("AustraliaCorporate", null),
	
	/**
	 * Broker Confirmation Type of Australia Sovereign.
	 */
	@RosettaEnumValue(value = "AustraliaSovereign") 
	AUSTRALIA_SOVEREIGN("AustraliaSovereign", null),
	
	/**
	 * Broker Confirmation Type for use with Credit Derivative Transactions on Leveraged Loans.
	 */
	@RosettaEnumValue(value = "CDSonLeveragedLoans") 
	CD_SON_LEVERAGED_LOANS("CDSonLeveragedLoans", null),
	
	/**
	 * Broker Confirmation Type for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
	 */
	@RosettaEnumValue(value = "CDSonMBS") 
	CD_SON_MBS("CDSonMBS", null),
	
	/**
	 * Broker Confirmation Type for CDX Emerging Markets Untranched Transactions.
	 */
	@RosettaEnumValue(value = "CDXEmergingMarkets") 
	CDX_EMERGING_MARKETS("CDXEmergingMarkets", null),
	
	/**
	 * Broker Confirmation Type for CDX Emerging Markets Diversified Untranched Transactions.
	 */
	@RosettaEnumValue(value = "CDXEmergingMarketsDiversified") 
	CDX_EMERGING_MARKETS_DIVERSIFIED("CDXEmergingMarketsDiversified", null),
	
	/**
	 * Broker Confirmation Type for CDX Swaption Transactions.
	 */
	@RosettaEnumValue(value = "CDXSwaption") 
	CDX_SWAPTION("CDXSwaption", null),
	
	/**
	 * Broker Confirmation Type for Dow Jones CDX Tranche Transactions.
	 */
	@RosettaEnumValue(value = "CDXTranche") 
	CDX_TRANCHE("CDXTranche", null),
	
	/**
	 * Broker Confirmation Type representing CMBX index trades.
	 */
	@RosettaEnumValue(value = "CMBX") 
	CMBX("CMBX", null),
	
	/**
	 * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.EM index series.
	 */
	@RosettaEnumValue(value = "DJ_CDX_EM_", displayName = "DJ.CDX.EM ") 
	DJ_CDX_EM_("DJ_CDX_EM_", "DJ.CDX.EM "),
	
	/**
	 * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.NA.IG and Dow Jones CDX.NA.HY index series.
	 */
	@RosettaEnumValue(value = "DJ_CDX_NA", displayName = "DJ.CDX.NA") 
	DJ_CDX_NA("DJ_CDX_NA", "DJ.CDX.NA"),
	
	/**
	 * Broker Confirmation Type of Emerging European and Middle Eastern Sovereign.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanAndMiddleEasternSovereign") 
	EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("EmergingEuropeanAndMiddleEasternSovereign", null),
	
	/**
	 * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporate") 
	EMERGING_EUROPEAN_CORPORATE("EmergingEuropeanCorporate", null),
	
	/**
	 * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporateLPN") 
	EMERGING_EUROPEAN_CORPORATE_LPN("EmergingEuropeanCorporateLPN", null),
	
	/**
	 * Broker Confirmation Type for Single Name European CMBS Transactions.
	 */
	@RosettaEnumValue(value = "EuropeanCMBS") 
	EUROPEAN_CMBS("EuropeanCMBS", null),
	
	/**
	 * Broker Confirmation Type of European Corporate.
	 */
	@RosettaEnumValue(value = "EuropeanCorporate") 
	EUROPEAN_CORPORATE("EuropeanCorporate", null),
	
	/**
	 * Broker Confirmation Type for Single Name European RMBS Transactions.
	 */
	@RosettaEnumValue(value = "EuropeanRMBS") 
	EUROPEAN_RMBS("EuropeanRMBS", null),
	
	/**
	 * Broker Confirmation Type of Japan Corporate.
	 */
	@RosettaEnumValue(value = "JapanCorporate") 
	JAPAN_CORPORATE("JapanCorporate", null),
	
	/**
	 * Broker Confirmation Type of Japan Sovereign.
	 */
	@RosettaEnumValue(value = "JapanSovereign") 
	JAPAN_SOVEREIGN("JapanSovereign", null),
	
	/**
	 * Broker Confirmation Type of Latin America Corporate.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporate") 
	LATIN_AMERICA_CORPORATE("LatinAmericaCorporate", null),
	
	/**
	 * Broker Confirmation Type for LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBond") 
	LATIN_AMERICA_CORPORATE_BOND("LatinAmericaCorporateBond", null),
	
	/**
	 * Broker Confirmation Type for LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBondOrLoan") 
	LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("LatinAmericaCorporateBondOrLoan", null),
	
	/**
	 * Broker Confirmation Type of Latin America Sovereign.
	 */
	@RosettaEnumValue(value = "LatinAmericaSovereign") 
	LATIN_AMERICA_SOVEREIGN("LatinAmericaSovereign", null),
	
	/**
	 * Broker Confirmation Type for MBX Transactions.
	 */
	@RosettaEnumValue(value = "MBX") 
	MBX("MBX", null),
	
	/**
	 * Broker Confirmation Type for Municipal CDX Untranched Transactions.
	 */
	@RosettaEnumValue(value = "MCDX") 
	MCDX("MCDX", null),
	
	/**
	 * Broker Confirmation Type of New Zealand Corporate.
	 */
	@RosettaEnumValue(value = "NewZealandCorporate") 
	NEW_ZEALAND_CORPORATE("NewZealandCorporate", null),
	
	/**
	 * Broker Confirmation Type of New Zealand Sovereign.
	 */
	@RosettaEnumValue(value = "NewZealandSovereign") 
	NEW_ZEALAND_SOVEREIGN("NewZealandSovereign", null),
	
	/**
	 * Broker ConfirmationType of North American Corporate.
	 */
	@RosettaEnumValue(value = "NorthAmericanCorporate") 
	NORTH_AMERICAN_CORPORATE("NorthAmericanCorporate", null),
	
	/**
	 * Broker Confirmation Type for PO Index Transactions.
	 */
	@RosettaEnumValue(value = "PO") 
	PO("PO", null),
	
	/**
	 * Broker Confirmation Type of Singapore Corporate.
	 */
	@RosettaEnumValue(value = "SingaporeCorporate") 
	SINGAPORE_CORPORATE("SingaporeCorporate", null),
	
	/**
	 * Broker Confirmation Type of Singapore Sovereign.
	 */
	@RosettaEnumValue(value = "SingaporeSovereign") 
	SINGAPORE_SOVEREIGN("SingaporeSovereign", null),
	
	/**
	 * Broker Confirmation Type of STANDARD ASIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAsiaCorporate") 
	STANDARD_ASIA_CORPORATE("StandardAsiaCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD ASIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAsiaSovereign") 
	STANDARD_ASIA_SOVEREIGN("StandardAsiaSovereign", null),
	
	/**
	 * Broker Confirmation Type of STANDARD AUSTRALIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAustraliaCorporate") 
	STANDARD_AUSTRALIA_CORPORATE("StandardAustraliaCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD AUSTRALIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAustraliaSovereign") 
	STANDARD_AUSTRALIA_SOVEREIGN("StandardAustraliaSovereign", null),
	
	/**
	 * Broker Confirmation Type for Standard CDX Tranche Transactions.
	 */
	@RosettaEnumValue(value = "StandardCDXTranche") 
	STANDARD_CDX_TRANCHE("StandardCDXTranche", null),
	
	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanAndMiddleEasternSovereign") 
	STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("StandardEmergingEuropeanAndMiddleEasternSovereign", null),
	
	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporate") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE("StandardEmergingEuropeanCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporateLPN") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN("StandardEmergingEuropeanCorporateLPN", null),
	
	/**
	 * Broker Confirmation Type for STANDARD EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanCorporate") 
	STANDARD_EUROPEAN_CORPORATE("StandardEuropeanCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD JAPAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardJapanCorporate") 
	STANDARD_JAPAN_CORPORATE("StandardJapanCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD JAPAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardJapanSovereign") 
	STANDARD_JAPAN_SOVEREIGN("StandardJapanSovereign", null),
	
	/**
	 * Standard Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
	 */
	@RosettaEnumValue(value = "StandardLCDS") 
	STANDARD_LCDS("StandardLCDS", null),
	
	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
	 */
	@RosettaEnumValue(value = "StandardLCDSBullet") 
	STANDARD_LCDS_BULLET("StandardLCDSBullet", null),
	
	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
	 */
	@RosettaEnumValue(value = "StandardLCDXBullet") 
	STANDARD_LCDX_BULLET("StandardLCDXBullet", null),
	
	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
	 */
	@RosettaEnumValue(value = "StandardLCDXBulletTranche") 
	STANDARD_LCDX_BULLET_TRANCHE("StandardLCDXBulletTranche", null),
	
	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBond") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND("StandardLatinAmericaCorporateBond", null),
	
	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBondOrLoan") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("StandardLatinAmericaCorporateBondOrLoan", null),
	
	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaSovereign") 
	STANDARD_LATIN_AMERICA_SOVEREIGN("StandardLatinAmericaSovereign", null),
	
	/**
	 * Broker Confirmation Type of STANDARD NEW ZEALAND CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNewZealandCorporate") 
	STANDARD_NEW_ZEALAND_CORPORATE("StandardNewZealandCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD NEW ZEALAND SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardNewZealandSovereign") 
	STANDARD_NEW_ZEALAND_SOVEREIGN("StandardNewZealandSovereign", null),
	
	/**
	 * Broker Confirmation Type for STANDARD NORTH AMERICAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNorthAmericanCorporate") 
	STANDARD_NORTH_AMERICAN_CORPORATE("StandardNorthAmericanCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD SINGAPORE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSingaporeCorporate") 
	STANDARD_SINGAPORE_CORPORATE("StandardSingaporeCorporate", null),
	
	/**
	 * Broker Confirmation Type of STANDARD SINGAPORE SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardSingaporeSovereign") 
	STANDARD_SINGAPORE_SOVEREIGN("StandardSingaporeSovereign", null),
	
	/**
	 * Broker Confirmation Type for STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSubordinatedEuropeanInsuranceCorporate") 
	STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("StandardSubordinatedEuropeanInsuranceCorporate", null),
	
	/**
	 * Broker Confirmation Type for STANDARD WESTERN EUROPEAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardWesternEuropeanSovereign") 
	STANDARD_WESTERN_EUROPEAN_SOVEREIGN("StandardWesternEuropeanSovereign", null),
	
	/**
	 * Broker Confirmation Type for Standard iTraxx Europe Tranched Transactions.
	 */
	@RosettaEnumValue(value = "StandardiTraxxEuropeTranche") 
	STANDARDI_TRAXX_EUROPE_TRANCHE("StandardiTraxxEuropeTranche", null),
	
	/**
	 * Broker Confirmation Type of Subordinated European Insurance Corporate.
	 */
	@RosettaEnumValue(value = "SubordinatedEuropeanInsuranceCorporate") 
	SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("SubordinatedEuropeanInsuranceCorporate", null),
	
	/**
	 * Broker Confirmation Type of SUKUK CORPORATE.
	 */
	@RosettaEnumValue(value = "SukukCorporate") 
	SUKUK_CORPORATE("SukukCorporate", null),
	
	/**
	 * Broker Confirmation Type of SUKUK SOVEREIGN.
	 */
	@RosettaEnumValue(value = "SukukSovereign") 
	SUKUK_SOVEREIGN("SukukSovereign", null),
	
	/**
	 * Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
	 */
	@RosettaEnumValue(value = "SyndicatedSecuredLoanCDS") 
	SYNDICATED_SECURED_LOAN_CDS("SyndicatedSecuredLoanCDS", null),
	
	/**
	 * Broker Confirmation Type for TRX Transactions.
	 */
	@RosettaEnumValue(value = "TRX") 
	TRX("TRX", null),
	
	/**
	 * Broker Confirmation Type for TRX.II Transactions.
	 */
	@RosettaEnumValue(value = "TRX_II", displayName = "TRX.II") 
	TRX_II("TRX_II", "TRX.II"),
	
	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	@RosettaEnumValue(value = "USMunicipalFullFaithAndCredit") 
	US_MUNICIPAL_FULL_FAITH_AND_CREDIT("USMunicipalFullFaithAndCredit", null),
	
	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL GENERAL FUND.
	 */
	@RosettaEnumValue(value = "USMunicipalGeneralFund") 
	US_MUNICIPAL_GENERAL_FUND("USMunicipalGeneralFund", null),
	
	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL REVENUE.
	 */
	@RosettaEnumValue(value = "USMunicipalRevenue") 
	US_MUNICIPAL_REVENUE("USMunicipalRevenue", null),
	
	/**
	 * Broker Confirmation Type of Western European Sovereign.
	 */
	@RosettaEnumValue(value = "WesternEuropeanSovereign") 
	WESTERN_EUROPEAN_SOVEREIGN("WesternEuropeanSovereign", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Asia Excluding Japan.
	 */
	@RosettaEnumValue(value = "iTraxxAsiaExJapan") 
	I_TRAXX_ASIA_EX_JAPAN("iTraxxAsiaExJapan", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Asia Ex-Japan Swaption Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxAsiaExJapanSwaption") 
	I_TRAXX_ASIA_EX_JAPAN_SWAPTION("iTraxxAsiaExJapanSwaption", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Asia Excluding Japan Tranched Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxAsiaExJapanTranche") 
	I_TRAXX_ASIA_EX_JAPAN_TRANCHE("iTraxxAsiaExJapanTranche", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Australia.
	 */
	@RosettaEnumValue(value = "iTraxxAustralia") 
	I_TRAXX_AUSTRALIA("iTraxxAustralia", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Australia Swaption Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxAustraliaSwaption") 
	I_TRAXX_AUSTRALIA_SWAPTION("iTraxxAustraliaSwaption", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Australia Tranched Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxAustraliaTranche") 
	I_TRAXX_AUSTRALIA_TRANCHE("iTraxxAustraliaTranche", null),
	
	/**
	 * Broker Confirmation Type for iTraxx CJ.
	 */
	@RosettaEnumValue(value = "iTraxxCJ") 
	I_TRAXX_CJ("iTraxxCJ", null),
	
	/**
	 * Broker Confirmation Type for iTraxx CJ Tranched Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxCJTranche") 
	I_TRAXX_CJ_TRANCHE("iTraxxCJTranche", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Europe Transactions
	 */
	@RosettaEnumValue(value = "iTraxxEurope") 
	I_TRAXX_EUROPE("iTraxxEurope", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Europe Swaption Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxEuropeSwaption") 
	I_TRAXX_EUROPE_SWAPTION("iTraxxEuropeSwaption", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Europe Tranched Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxEuropeTranche") 
	I_TRAXX_EUROPE_TRANCHE("iTraxxEuropeTranche", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Japan.
	 */
	@RosettaEnumValue(value = "iTraxxJapan") 
	I_TRAXX_JAPAN("iTraxxJapan", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Japan Swaption Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxJapanSwaption") 
	I_TRAXX_JAPAN_SWAPTION("iTraxxJapanSwaption", null),
	
	/**
	 * Broker Confirmation Type for iTraxx Japan Tranched Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxJapanTranche") 
	I_TRAXX_JAPAN_TRANCHE("iTraxxJapanTranche", null),
	
	/**
	 * Broker Confirmation Type for iTraxx LevX.
	 */
	@RosettaEnumValue(value = "iTraxxLevX") 
	I_TRAXX_LEV_X("iTraxxLevX", null),
	
	/**
	 * Broker Confirmation Type for iTraxx SDI 75 Transactions.
	 */
	@RosettaEnumValue(value = "iTraxxSDI75") 
	I_TRAXX_SDI_75("iTraxxSDI75", null),
	
	/**
	 * Broker Confirmation Type for iTraxx SovX.
	 */
	@RosettaEnumValue(value = "iTraxxSovX") 
	I_TRAXX_SOV_X("iTraxxSovX", null)
;
	private static Map<String, BrokerConfirmationTypeEnum> values;
	static {
        Map<String, BrokerConfirmationTypeEnum> map = new ConcurrentHashMap<>();
		for (BrokerConfirmationTypeEnum instance : BrokerConfirmationTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	BrokerConfirmationTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static BrokerConfirmationTypeEnum fromDisplayName(String name) {
		BrokerConfirmationTypeEnum value = values.get(name);
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
