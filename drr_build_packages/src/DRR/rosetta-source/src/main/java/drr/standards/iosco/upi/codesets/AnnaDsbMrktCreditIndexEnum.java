package drr.standards.iosco.upi.codesets;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbMrktCreditIndexEnum")
public enum AnnaDsbMrktCreditIndexEnum {

	/**
	 * ABX.HE.A
	 */
	@RosettaEnumValue(value = "ABX_HE_A", displayName = "ABX.HE.A") 
	ABX_HE_A("ABX_HE_A", "ABX.HE.A"),
	
	/**
	 * ABX.HE.AA
	 */
	@RosettaEnumValue(value = "ABX_HE_AA", displayName = "ABX.HE.AA") 
	ABX_HE_AA("ABX_HE_AA", "ABX.HE.AA"),
	
	/**
	 * ABX.HE.AAA
	 */
	@RosettaEnumValue(value = "ABX_HE_AAA", displayName = "ABX.HE.AAA") 
	ABX_HE_AAA("ABX_HE_AAA", "ABX.HE.AAA"),
	
	/**
	 * ABX.HE.BBB
	 */
	@RosettaEnumValue(value = "ABX_HE_BBB", displayName = "ABX.HE.BBB") 
	ABX_HE_BBB("ABX_HE_BBB", "ABX.HE.BBB"),
	
	/**
	 * ABX.HE.BBB-
	 */
	@RosettaEnumValue(value = "ABX_HE_BBB_", displayName = "ABX.HE.BBB-") 
	ABX_HE_BBB_("ABX_HE_BBB_", "ABX.HE.BBB-"),
	
	/**
	 * ABX.HE.PENAAA
	 */
	@RosettaEnumValue(value = "ABX_HE_PENAAA", displayName = "ABX.HE.PENAAA") 
	ABX_HE_PENAAA("ABX_HE_PENAAA", "ABX.HE.PENAAA"),
	
	/**
	 * CDX.EM
	 */
	@RosettaEnumValue(value = "CDX_EM", displayName = "CDX.EM") 
	CDX_EM("CDX_EM", "CDX.EM"),
	
	/**
	 * CDX.EM.DIVERSIFIED
	 */
	@RosettaEnumValue(value = "CDX_EM_DIVERSIFIED", displayName = "CDX.EM.DIVERSIFIED") 
	CDX_EM_DIVERSIFIED("CDX_EM_DIVERSIFIED", "CDX.EM.DIVERSIFIED"),
	
	/**
	 * CDX.EM.ex-EU
	 */
	@RosettaEnumValue(value = "CDX_EM_ex_EU", displayName = "CDX.EM.ex-EU") 
	CDX_EM_EX_EU("CDX_EM_ex_EU", "CDX.EM.ex-EU"),
	
	/**
	 * CDX.LATAM.CORP
	 */
	@RosettaEnumValue(value = "CDX_LATAM_CORP", displayName = "CDX.LATAM.CORP") 
	CDX_LATAM_CORP("CDX_LATAM_CORP", "CDX.LATAM.CORP"),
	
	/**
	 * CDX.NA.HY
	 */
	@RosettaEnumValue(value = "CDX_NA_HY", displayName = "CDX.NA.HY") 
	CDX_NA_HY("CDX_NA_HY", "CDX.NA.HY"),
	
	/**
	 * CDX.NA.HY.B
	 */
	@RosettaEnumValue(value = "CDX_NA_HY_B", displayName = "CDX.NA.HY.B") 
	CDX_NA_HY_B("CDX_NA_HY_B", "CDX.NA.HY.B"),
	
	/**
	 * CDX.NA.HY.BB
	 */
	@RosettaEnumValue(value = "CDX_NA_HY_BB", displayName = "CDX.NA.HY.BB") 
	CDX_NA_HY_BB("CDX_NA_HY_BB", "CDX.NA.HY.BB"),
	
	/**
	 * CDX.NA.HY.Ex-BB
	 */
	@RosettaEnumValue(value = "CDX_NA_HY_Ex_BB", displayName = "CDX.NA.HY.Ex-BB") 
	CDX_NA_HY_EX_BB("CDX_NA_HY_Ex_BB", "CDX.NA.HY.Ex-BB"),
	
	/**
	 * CDX.NA.HY.HB
	 */
	@RosettaEnumValue(value = "CDX_NA_HY_HB", displayName = "CDX.NA.HY.HB") 
	CDX_NA_HY_HB("CDX_NA_HY_HB", "CDX.NA.HY.HB"),
	
	/**
	 * CDX.NA.IG
	 */
	@RosettaEnumValue(value = "CDX_NA_IG", displayName = "CDX.NA.IG") 
	CDX_NA_IG("CDX_NA_IG", "CDX.NA.IG"),
	
	/**
	 * CDX.NA.IG.BBB
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_BBB", displayName = "CDX.NA.IG.BBB") 
	CDX_NA_IG_BBB("CDX_NA_IG_BBB", "CDX.NA.IG.BBB"),
	
	/**
	 * CDX.NA.IG.CONS
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_CONS", displayName = "CDX.NA.IG.CONS") 
	CDX_NA_IG_CONS("CDX_NA_IG_CONS", "CDX.NA.IG.CONS"),
	
	/**
	 * CDX.NA.IG.ENRG
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_ENRG", displayName = "CDX.NA.IG.ENRG") 
	CDX_NA_IG_ENRG("CDX_NA_IG_ENRG", "CDX.NA.IG.ENRG"),
	
	/**
	 * CDX.NA.IG.FIN
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_FIN", displayName = "CDX.NA.IG.FIN") 
	CDX_NA_IG_FIN("CDX_NA_IG_FIN", "CDX.NA.IG.FIN"),
	
	/**
	 * CDX.NA.IG.HVOL
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_HVOL", displayName = "CDX.NA.IG.HVOL") 
	CDX_NA_IG_HVOL("CDX_NA_IG_HVOL", "CDX.NA.IG.HVOL"),
	
	/**
	 * CDX.NA.IG.INDU
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_INDU", displayName = "CDX.NA.IG.INDU") 
	CDX_NA_IG_INDU("CDX_NA_IG_INDU", "CDX.NA.IG.INDU"),
	
	/**
	 * CDX.NA.IG.TMT
	 */
	@RosettaEnumValue(value = "CDX_NA_IG_TMT", displayName = "CDX.NA.IG.TMT") 
	CDX_NA_IG_TMT("CDX_NA_IG_TMT", "CDX.NA.IG.TMT"),
	
	/**
	 * CDX.NA.XO
	 */
	@RosettaEnumValue(value = "CDX_NA_XO", displayName = "CDX.NA.XO") 
	CDX_NA_XO("CDX_NA_XO", "CDX.NA.XO"),
	
	/**
	 * CMBX.NA.A
	 */
	@RosettaEnumValue(value = "CMBX_NA_A", displayName = "CMBX.NA.A") 
	CMBX_NA_A("CMBX_NA_A", "CMBX.NA.A"),
	
	/**
	 * CMBX.NA.AA
	 */
	@RosettaEnumValue(value = "CMBX_NA_AA", displayName = "CMBX.NA.AA") 
	CMBX_NA_AA("CMBX_NA_AA", "CMBX.NA.AA"),
	
	/**
	 * CMBX.NA.AAA
	 */
	@RosettaEnumValue(value = "CMBX_NA_AAA", displayName = "CMBX.NA.AAA") 
	CMBX_NA_AAA("CMBX_NA_AAA", "CMBX.NA.AAA"),
	
	/**
	 * CMBX.NA.AJ
	 */
	@RosettaEnumValue(value = "CMBX_NA_AJ", displayName = "CMBX.NA.AJ") 
	CMBX_NA_AJ("CMBX_NA_AJ", "CMBX.NA.AJ"),
	
	/**
	 * CMBX.NA.AM
	 */
	@RosettaEnumValue(value = "CMBX_NA_AM", displayName = "CMBX.NA.AM") 
	CMBX_NA_AM("CMBX_NA_AM", "CMBX.NA.AM"),
	
	/**
	 * CMBX.NA.AS
	 */
	@RosettaEnumValue(value = "CMBX_NA_AS", displayName = "CMBX.NA.AS") 
	CMBX_NA_AS("CMBX_NA_AS", "CMBX.NA.AS"),
	
	/**
	 * CMBX.NA.BB
	 */
	@RosettaEnumValue(value = "CMBX_NA_BB", displayName = "CMBX.NA.BB") 
	CMBX_NA_BB("CMBX_NA_BB", "CMBX.NA.BB"),
	
	/**
	 * CMBX.NA.BBB
	 */
	@RosettaEnumValue(value = "CMBX_NA_BBB", displayName = "CMBX.NA.BBB") 
	CMBX_NA_BBB("CMBX_NA_BBB", "CMBX.NA.BBB"),
	
	/**
	 * CMBX.NA.BBB-
	 */
	@RosettaEnumValue(value = "CMBX_NA_BBB_", displayName = "CMBX.NA.BBB-") 
	CMBX_NA_BBB_("CMBX_NA_BBB_", "CMBX.NA.BBB-"),
	
	/**
	 * iBoxx EUR CoCo
	 */
	@RosettaEnumValue(value = "iBoxx_EUR_CoCo", displayName = "iBoxx EUR CoCo") 
	I_BOXX_EUR_CO_CO("iBoxx_EUR_CoCo", "iBoxx EUR CoCo"),
	
	/**
	 * iBoxx EUR CoCo Liquid Developed Market AT1
	 */
	@RosettaEnumValue(value = "iBoxx_EUR_CoCo_Liquid_Developed_Market_AT1", displayName = "iBoxx EUR CoCo Liquid Developed Market AT1") 
	I_BOXX_EUR_CO_CO_LIQUID_DEVELOPED_MARKET_AT_1("iBoxx_EUR_CoCo_Liquid_Developed_Market_AT1", "iBoxx EUR CoCo Liquid Developed Market AT1"),
	
	/**
	 * IBOXX EUR CORPORATES
	 */
	@RosettaEnumValue(value = "IBOXX_EUR_CORPORATES", displayName = "IBOXX EUR CORPORATES") 
	IBOXX_EUR_CORPORATES("IBOXX_EUR_CORPORATES", "IBOXX EUR CORPORATES"),
	
	/**
	 * IBOXX EUR LIQUID HIGH YIELD INDEX
	 */
	@RosettaEnumValue(value = "IBOXX_EUR_LIQUID_HIGH_YIELD_INDEX", displayName = "IBOXX EUR LIQUID HIGH YIELD INDEX") 
	IBOXX_EUR_LIQUID_HIGH_YIELD_INDEX("IBOXX_EUR_LIQUID_HIGH_YIELD_INDEX", "IBOXX EUR LIQUID HIGH YIELD INDEX"),
	
	/**
	 * IBOXX GBP CORPORATES
	 */
	@RosettaEnumValue(value = "IBOXX_GBP_CORPORATES", displayName = "IBOXX GBP CORPORATES") 
	IBOXX_GBP_CORPORATES("IBOXX_GBP_CORPORATES", "IBOXX GBP CORPORATES"),
	
	/**
	 * IBOXX TREPP CMBS LIQUID
	 */
	@RosettaEnumValue(value = "IBOXX_TREPP_CMBS_LIQUID", displayName = "IBOXX TREPP CMBS LIQUID") 
	IBOXX_TREPP_CMBS_LIQUID("IBOXX_TREPP_CMBS_LIQUID", "IBOXX TREPP CMBS LIQUID"),
	
	/**
	 * IBOXX TREPP CMBS OVERALL
	 */
	@RosettaEnumValue(value = "IBOXX_TREPP_CMBS_OVERALL", displayName = "IBOXX TREPP CMBS OVERALL") 
	IBOXX_TREPP_CMBS_OVERALL("IBOXX_TREPP_CMBS_OVERALL", "IBOXX TREPP CMBS OVERALL"),
	
	/**
	 * iBoxx USD CoCo
	 */
	@RosettaEnumValue(value = "iBoxx_USD_CoCo", displayName = "iBoxx USD CoCo") 
	I_BOXX_USD_CO_CO("iBoxx_USD_CoCo", "iBoxx USD CoCo"),
	
	/**
	 * iBoxx USD CoCo Liquid Developed Market
	 */
	@RosettaEnumValue(value = "iBoxx_USD_CoCo_Liquid_Developed_Market", displayName = "iBoxx USD CoCo Liquid Developed Market") 
	I_BOXX_USD_CO_CO_LIQUID_DEVELOPED_MARKET("iBoxx_USD_CoCo_Liquid_Developed_Market", "iBoxx USD CoCo Liquid Developed Market"),
	
	/**
	 * iBoxx USD CoCo Liquid Developed Market AT1
	 */
	@RosettaEnumValue(value = "iBoxx_USD_CoCo_Liquid_Developed_Market_AT1", displayName = "iBoxx USD CoCo Liquid Developed Market AT1") 
	I_BOXX_USD_CO_CO_LIQUID_DEVELOPED_MARKET_AT_1("iBoxx_USD_CoCo_Liquid_Developed_Market_AT1", "iBoxx USD CoCo Liquid Developed Market AT1"),
	
	/**
	 * IBOXX USD DOMESTIC CORPORATES
	 */
	@RosettaEnumValue(value = "IBOXX_USD_DOMESTIC_CORPORATES", displayName = "IBOXX USD DOMESTIC CORPORATES") 
	IBOXX_USD_DOMESTIC_CORPORATES("IBOXX_USD_DOMESTIC_CORPORATES", "IBOXX USD DOMESTIC CORPORATES"),
	
	/**
	 * IBOXX USD LIQUID HIGH YIELD INDEX
	 */
	@RosettaEnumValue(value = "IBOXX_USD_LIQUID_HIGH_YIELD_INDEX", displayName = "IBOXX USD LIQUID HIGH YIELD INDEX") 
	IBOXX_USD_LIQUID_HIGH_YIELD_INDEX("IBOXX_USD_LIQUID_HIGH_YIELD_INDEX", "IBOXX USD LIQUID HIGH YIELD INDEX"),
	
	/**
	 * iBoxx USD Liquid High Yield Oil &amp; Gas (5/25/50 Issuer Cap)
	 */
	@RosettaEnumValue(value = "iBoxx_USD_Liquid_High_Yield_Oil_Gas_5_25_50_Issuer_Cap_", displayName = "iBoxx USD Liquid High Yield Oil & Gas (5/25/50 Issuer Cap)") 
	I_BOXX_USD_LIQUID_HIGH_YIELD_OIL_GAS_5_25_50_ISSUER_CAP("iBoxx_USD_Liquid_High_Yield_Oil_Gas_5_25_50_Issuer_Cap_", "iBoxx USD Liquid High Yield Oil & Gas (5/25/50 Issuer Cap)"),
	
	/**
	 * IBOXX USD LIQUID IG
	 */
	@RosettaEnumValue(value = "IBOXX_USD_LIQUID_IG", displayName = "IBOXX USD LIQUID IG") 
	IBOXX_USD_LIQUID_IG("IBOXX_USD_LIQUID_IG", "IBOXX USD LIQUID IG"),
	
	/**
	 * IBOXX USD LIQUID LEVERAGED LOANS INDEX
	 */
	@RosettaEnumValue(value = "IBOXX_USD_LIQUID_LEVERAGED_LOANS_INDEX", displayName = "IBOXX USD LIQUID LEVERAGED LOANS INDEX") 
	IBOXX_USD_LIQUID_LEVERAGED_LOANS_INDEX("IBOXX_USD_LIQUID_LEVERAGED_LOANS_INDEX", "IBOXX USD LIQUID LEVERAGED LOANS INDEX"),
	
	/**
	 * IOS.FN30.300
	 */
	@RosettaEnumValue(value = "IOS_FN30_300", displayName = "IOS.FN30.300") 
	IOS_FN30_300("IOS_FN30_300", "IOS.FN30.300"),
	
	/**
	 * IOS.FN30.350
	 */
	@RosettaEnumValue(value = "IOS_FN30_350", displayName = "IOS.FN30.350") 
	IOS_FN30_350("IOS_FN30_350", "IOS.FN30.350"),
	
	/**
	 * IOS.FN30.400
	 */
	@RosettaEnumValue(value = "IOS_FN30_400", displayName = "IOS.FN30.400") 
	IOS_FN30_400("IOS_FN30_400", "IOS.FN30.400"),
	
	/**
	 * IOS.FN30.450
	 */
	@RosettaEnumValue(value = "IOS_FN30_450", displayName = "IOS.FN30.450") 
	IOS_FN30_450("IOS_FN30_450", "IOS.FN30.450"),
	
	/**
	 * IOS.FN30.500
	 */
	@RosettaEnumValue(value = "IOS_FN30_500", displayName = "IOS.FN30.500") 
	IOS_FN30_500("IOS_FN30_500", "IOS.FN30.500"),
	
	/**
	 * IOS.FN30.550
	 */
	@RosettaEnumValue(value = "IOS_FN30_550", displayName = "IOS.FN30.550") 
	IOS_FN30_550("IOS_FN30_550", "IOS.FN30.550"),
	
	/**
	 * IOS.FN30.600
	 */
	@RosettaEnumValue(value = "IOS_FN30_600", displayName = "IOS.FN30.600") 
	IOS_FN30_600("IOS_FN30_600", "IOS.FN30.600"),
	
	/**
	 * IOS.FN30.650
	 */
	@RosettaEnumValue(value = "IOS_FN30_650", displayName = "IOS.FN30.650") 
	IOS_FN30_650("IOS_FN30_650", "IOS.FN30.650"),
	
	/**
	 * IOS.GII30.400
	 */
	@RosettaEnumValue(value = "IOS_GII30_400", displayName = "IOS.GII30.400") 
	IOS_GII30_400("IOS_GII30_400", "IOS.GII30.400"),
	
	/**
	 * IOS.GII30.450
	 */
	@RosettaEnumValue(value = "IOS_GII30_450", displayName = "IOS.GII30.450") 
	IOS_GII30_450("IOS_GII30_450", "IOS.GII30.450"),
	
	/**
	 * IOS.GII30.500
	 */
	@RosettaEnumValue(value = "IOS_GII30_500", displayName = "IOS.GII30.500") 
	IOS_GII30_500("IOS_GII30_500", "IOS.GII30.500"),
	
	/**
	 * ITRAXX ASIA EX-JAPAN IG
	 */
	@RosettaEnumValue(value = "ITRAXX_ASIA_EX_JAPAN_IG", displayName = "ITRAXX ASIA EX-JAPAN IG") 
	ITRAXX_ASIA_EX_JAPAN_IG("ITRAXX_ASIA_EX_JAPAN_IG", "ITRAXX ASIA EX-JAPAN IG"),
	
	/**
	 * Itraxx Asia ex-Japan IG (Restricted)
	 */
	@RosettaEnumValue(value = "Itraxx_Asia_ex_Japan_IG_Restricted_", displayName = "Itraxx Asia ex-Japan IG (Restricted)") 
	ITRAXX_ASIA_EX_JAPAN_IG_RESTRICTED("Itraxx_Asia_ex_Japan_IG_Restricted_", "Itraxx Asia ex-Japan IG (Restricted)"),
	
	/**
	 * ITRAXX AUSTRALIA
	 */
	@RosettaEnumValue(value = "ITRAXX_AUSTRALIA", displayName = "ITRAXX AUSTRALIA") 
	ITRAXX_AUSTRALIA("ITRAXX_AUSTRALIA", "ITRAXX AUSTRALIA"),
	
	/**
	 * ITRAXX CEEMEA
	 */
	@RosettaEnumValue(value = "ITRAXX_CEEMEA", displayName = "ITRAXX CEEMEA") 
	ITRAXX_CEEMEA("ITRAXX_CEEMEA", "ITRAXX CEEMEA"),
	
	/**
	 * ITRAXX EUROPE
	 */
	@RosettaEnumValue(value = "ITRAXX_EUROPE", displayName = "ITRAXX EUROPE") 
	ITRAXX_EUROPE("ITRAXX_EUROPE", "ITRAXX EUROPE"),
	
	/**
	 * ITRAXX EUROPE CROSSOVER
	 */
	@RosettaEnumValue(value = "ITRAXX_EUROPE_CROSSOVER", displayName = "ITRAXX EUROPE CROSSOVER") 
	ITRAXX_EUROPE_CROSSOVER("ITRAXX_EUROPE_CROSSOVER", "ITRAXX EUROPE CROSSOVER"),
	
	/**
	 * ITRAXX EUROPE HIVOL
	 */
	@RosettaEnumValue(value = "ITRAXX_EUROPE_HIVOL", displayName = "ITRAXX EUROPE HIVOL") 
	ITRAXX_EUROPE_HIVOL("ITRAXX_EUROPE_HIVOL", "ITRAXX EUROPE HIVOL"),
	
	/**
	 * iTraxx Europe Non-Financial
	 */
	@RosettaEnumValue(value = "iTraxx_Europe_Non_Financial", displayName = "iTraxx Europe Non-Financial") 
	I_TRAXX_EUROPE_NON_FINANCIAL("iTraxx_Europe_Non_Financial", "iTraxx Europe Non-Financial"),
	
	/**
	 * ITRAXX EUROPE SENIOR FINANCIALS
	 */
	@RosettaEnumValue(value = "ITRAXX_EUROPE_SENIOR_FINANCIALS", displayName = "ITRAXX EUROPE SENIOR FINANCIALS") 
	ITRAXX_EUROPE_SENIOR_FINANCIALS("ITRAXX_EUROPE_SENIOR_FINANCIALS", "ITRAXX EUROPE SENIOR FINANCIALS"),
	
	/**
	 * ITRAXX EUROPE SUB FINANCIALS
	 */
	@RosettaEnumValue(value = "ITRAXX_EUROPE_SUB_FINANCIALS", displayName = "ITRAXX EUROPE SUB FINANCIALS") 
	ITRAXX_EUROPE_SUB_FINANCIALS("ITRAXX_EUROPE_SUB_FINANCIALS", "ITRAXX EUROPE SUB FINANCIALS"),
	
	/**
	 * ITRAXX JAPAN
	 */
	@RosettaEnumValue(value = "ITRAXX_JAPAN", displayName = "ITRAXX JAPAN") 
	ITRAXX_JAPAN("ITRAXX_JAPAN", "ITRAXX JAPAN"),
	
	/**
	 * iTraxx MSCI ESG Screened Europe Index
	 */
	@RosettaEnumValue(value = "iTraxx_MSCI_ESG_Screened_Europe_Index", displayName = "iTraxx MSCI ESG Screened Europe Index") 
	I_TRAXX_MSCI_ESG_SCREENED_EUROPE_INDEX("iTraxx_MSCI_ESG_Screened_Europe_Index", "iTraxx MSCI ESG Screened Europe Index"),
	
	/**
	 * ITRAXX SOVX ASIA PACIFIC
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_ASIA_PACIFIC", displayName = "ITRAXX SOVX ASIA PACIFIC") 
	ITRAXX_SOVX_ASIA_PACIFIC("ITRAXX_SOVX_ASIA_PACIFIC", "ITRAXX SOVX ASIA PACIFIC"),
	
	/**
	 * ITRAXX SOVX BRIC
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_BRIC", displayName = "ITRAXX SOVX BRIC") 
	ITRAXX_SOVX_BRIC("ITRAXX_SOVX_BRIC", "ITRAXX SOVX BRIC"),
	
	/**
	 * ITRAXX SOVX CEEMEA
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_CEEMEA", displayName = "ITRAXX SOVX CEEMEA") 
	ITRAXX_SOVX_CEEMEA("ITRAXX_SOVX_CEEMEA", "ITRAXX SOVX CEEMEA"),
	
	/**
	 * ITRAXX SOVX CEEMEA EX-EU
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_CEEMEA_EX_EU", displayName = "ITRAXX SOVX CEEMEA EX-EU") 
	ITRAXX_SOVX_CEEMEA_EX_EU("ITRAXX_SOVX_CEEMEA_EX_EU", "ITRAXX SOVX CEEMEA EX-EU"),
	
	/**
	 * ITRAXX SOVX G7
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_G7", displayName = "ITRAXX SOVX G7") 
	ITRAXX_SOVX_G7("ITRAXX_SOVX_G7", "ITRAXX SOVX G7"),
	
	/**
	 * ITRAXX SOVX GLOBAL LIQUID INVESTMENT GRADE
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_GLOBAL_LIQUID_INVESTMENT_GRADE", displayName = "ITRAXX SOVX GLOBAL LIQUID INVESTMENT GRADE") 
	ITRAXX_SOVX_GLOBAL_LIQUID_INVESTMENT_GRADE("ITRAXX_SOVX_GLOBAL_LIQUID_INVESTMENT_GRADE", "ITRAXX SOVX GLOBAL LIQUID INVESTMENT GRADE"),
	
	/**
	 * ITRAXX SOVX LATIN AMERICA
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_LATIN_AMERICA", displayName = "ITRAXX SOVX LATIN AMERICA") 
	ITRAXX_SOVX_LATIN_AMERICA("ITRAXX_SOVX_LATIN_AMERICA", "ITRAXX SOVX LATIN AMERICA"),
	
	/**
	 * ITRAXX SOVX WESTERN EUROPE
	 */
	@RosettaEnumValue(value = "ITRAXX_SOVX_WESTERN_EUROPE", displayName = "ITRAXX SOVX WESTERN EUROPE") 
	ITRAXX_SOVX_WESTERN_EUROPE("ITRAXX_SOVX_WESTERN_EUROPE", "ITRAXX SOVX WESTERN EUROPE"),
	
	/**
	 * LCDX.NA
	 */
	@RosettaEnumValue(value = "LCDX_NA", displayName = "LCDX.NA") 
	LCDX_NA("LCDX_NA", "LCDX.NA"),
	
	/**
	 * Markit iBoxx Trepp CMBS Original AAA Rolling Index
	 */
	@RosettaEnumValue(value = "Markit_iBoxx_Trepp_CMBS_Original_AAA_Rolling_Index", displayName = "Markit iBoxx Trepp CMBS Original AAA Rolling Index") 
	MARKIT_I_BOXX_TREPP_CMBS_ORIGINAL_AAA_ROLLING_INDEX("Markit_iBoxx_Trepp_CMBS_Original_AAA_Rolling_Index", "Markit iBoxx Trepp CMBS Original AAA Rolling Index"),
	
	/**
	 * MBX.FN30.300
	 */
	@RosettaEnumValue(value = "MBX_FN30_300", displayName = "MBX.FN30.300") 
	MBX_FN30_300("MBX_FN30_300", "MBX.FN30.300"),
	
	/**
	 * MBX.FN30.350
	 */
	@RosettaEnumValue(value = "MBX_FN30_350", displayName = "MBX.FN30.350") 
	MBX_FN30_350("MBX_FN30_350", "MBX.FN30.350"),
	
	/**
	 * MBX.FN30.400
	 */
	@RosettaEnumValue(value = "MBX_FN30_400", displayName = "MBX.FN30.400") 
	MBX_FN30_400("MBX_FN30_400", "MBX.FN30.400"),
	
	/**
	 * MBX.FN30.450
	 */
	@RosettaEnumValue(value = "MBX_FN30_450", displayName = "MBX.FN30.450") 
	MBX_FN30_450("MBX_FN30_450", "MBX.FN30.450"),
	
	/**
	 * MBX.FN30.500
	 */
	@RosettaEnumValue(value = "MBX_FN30_500", displayName = "MBX.FN30.500") 
	MBX_FN30_500("MBX_FN30_500", "MBX.FN30.500"),
	
	/**
	 * MBX.FN30.550
	 */
	@RosettaEnumValue(value = "MBX_FN30_550", displayName = "MBX.FN30.550") 
	MBX_FN30_550("MBX_FN30_550", "MBX.FN30.550"),
	
	/**
	 * MBX.FN30.600
	 */
	@RosettaEnumValue(value = "MBX_FN30_600", displayName = "MBX.FN30.600") 
	MBX_FN30_600("MBX_FN30_600", "MBX.FN30.600"),
	
	/**
	 * MBX.FN30.650
	 */
	@RosettaEnumValue(value = "MBX_FN30_650", displayName = "MBX.FN30.650") 
	MBX_FN30_650("MBX_FN30_650", "MBX.FN30.650"),
	
	/**
	 * MBX.GII30.400
	 */
	@RosettaEnumValue(value = "MBX_GII30_400", displayName = "MBX.GII30.400") 
	MBX_GII30_400("MBX_GII30_400", "MBX.GII30.400"),
	
	/**
	 * MBX.GII30.450
	 */
	@RosettaEnumValue(value = "MBX_GII30_450", displayName = "MBX.GII30.450") 
	MBX_GII30_450("MBX_GII30_450", "MBX.GII30.450"),
	
	/**
	 * MBX.GII30.500
	 */
	@RosettaEnumValue(value = "MBX_GII30_500", displayName = "MBX.GII30.500") 
	MBX_GII30_500("MBX_GII30_500", "MBX.GII30.500"),
	
	/**
	 * MCDX.NA
	 */
	@RosettaEnumValue(value = "MCDX_NA", displayName = "MCDX.NA") 
	MCDX_NA("MCDX_NA", "MCDX.NA"),
	
	/**
	 * PO.FN30.300
	 */
	@RosettaEnumValue(value = "PO_FN30_300", displayName = "PO.FN30.300") 
	PO_FN30_300("PO_FN30_300", "PO.FN30.300"),
	
	/**
	 * PO.FN30.350
	 */
	@RosettaEnumValue(value = "PO_FN30_350", displayName = "PO.FN30.350") 
	PO_FN30_350("PO_FN30_350", "PO.FN30.350"),
	
	/**
	 * PO.FN30.400
	 */
	@RosettaEnumValue(value = "PO_FN30_400", displayName = "PO.FN30.400") 
	PO_FN30_400("PO_FN30_400", "PO.FN30.400"),
	
	/**
	 * PO.FN30.450
	 */
	@RosettaEnumValue(value = "PO_FN30_450", displayName = "PO.FN30.450") 
	PO_FN30_450("PO_FN30_450", "PO.FN30.450"),
	
	/**
	 * PO.FN30.500
	 */
	@RosettaEnumValue(value = "PO_FN30_500", displayName = "PO.FN30.500") 
	PO_FN30_500("PO_FN30_500", "PO.FN30.500"),
	
	/**
	 * PO.FN30.550
	 */
	@RosettaEnumValue(value = "PO_FN30_550", displayName = "PO.FN30.550") 
	PO_FN30_550("PO_FN30_550", "PO.FN30.550"),
	
	/**
	 * PO.FN30.600
	 */
	@RosettaEnumValue(value = "PO_FN30_600", displayName = "PO.FN30.600") 
	PO_FN30_600("PO_FN30_600", "PO.FN30.600"),
	
	/**
	 * PO.FN30.650
	 */
	@RosettaEnumValue(value = "PO_FN30_650", displayName = "PO.FN30.650") 
	PO_FN30_650("PO_FN30_650", "PO.FN30.650"),
	
	/**
	 * PO.GII30.400
	 */
	@RosettaEnumValue(value = "PO_GII30_400", displayName = "PO.GII30.400") 
	PO_GII30_400("PO_GII30_400", "PO.GII30.400"),
	
	/**
	 * PO.GII30.450
	 */
	@RosettaEnumValue(value = "PO_GII30_450", displayName = "PO.GII30.450") 
	PO_GII30_450("PO_GII30_450", "PO.GII30.450"),
	
	/**
	 * PO.GII30.500
	 */
	@RosettaEnumValue(value = "PO_GII30_500", displayName = "PO.GII30.500") 
	PO_GII30_500("PO_GII30_500", "PO.GII30.500"),
	
	/**
	 * PRIMEX.ARM
	 */
	@RosettaEnumValue(value = "PRIMEX_ARM", displayName = "PRIMEX.ARM") 
	PRIMEX_ARM("PRIMEX_ARM", "PRIMEX.ARM"),
	
	/**
	 * PRIMEX.FRM
	 */
	@RosettaEnumValue(value = "PRIMEX_FRM", displayName = "PRIMEX.FRM") 
	PRIMEX_FRM("PRIMEX_FRM", "PRIMEX.FRM"),
	
	/**
	 * TABX.HE.BBB
	 */
	@RosettaEnumValue(value = "TABX_HE_BBB", displayName = "TABX.HE.BBB") 
	TABX_HE_BBB("TABX_HE_BBB", "TABX.HE.BBB"),
	
	/**
	 * TABX.HE.BBB-
	 */
	@RosettaEnumValue(value = "TABX_HE_BBB_", displayName = "TABX.HE.BBB-") 
	TABX_HE_BBB_("TABX_HE_BBB_", "TABX.HE.BBB-")
;
	private static Map<String, AnnaDsbMrktCreditIndexEnum> values;
	static {
        Map<String, AnnaDsbMrktCreditIndexEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbMrktCreditIndexEnum instance : AnnaDsbMrktCreditIndexEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbMrktCreditIndexEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbMrktCreditIndexEnum fromDisplayName(String name) {
		AnnaDsbMrktCreditIndexEnum value = values.get(name);
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
