package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definition CollateralAssetDefinitions_2003 2003 ISDA Collateral Asset Definitions  
 *
 * Provision 
 *
 */
@RosettaEnum("CollateralAssetDefinitionsEnum")
public enum CollateralAssetDefinitionsEnum {

	/**
	 * Australian Dollar (AUD) Cash.
	 */
	@RosettaEnumValue(value = "AU_CASH") 
	AU_CASH("AU_CASH", null),
	
	/**
	 * Australian Government Securities Capital-Indexed Bonds.
	 */
	@RosettaEnumValue(value = "AU_CIB", displayName = "AU-CIB") 
	AU_CIB("AU_CIB", "AU-CIB"),
	
	/**
	 * Australian Semi-Government Securities Fixed Interest Bonds.
	 */
	@RosettaEnumValue(value = "AU_FIB", displayName = "AU-FIB") 
	AU_FIB("AU_FIB", "AU-FIB"),
	
	/**
	 * Australian Government Securities Fixed Rate Bonds.
	 */
	@RosettaEnumValue(value = "AU_FRB", displayName = "AU-FRB") 
	AU_FRB("AU_FRB", "AU-FRB"),
	
	/**
	 * Australian Semi-Government Securities Index Linked Bonds.
	 */
	@RosettaEnumValue(value = "AU_ILB", displayName = "AU-ILB") 
	AU_ILB("AU_ILB", "AU-ILB"),
	
	/**
	 * Australian Government Securities Treasury Notes.
	 */
	@RosettaEnumValue(value = "AU_NOTE", displayName = "AU-NOTE") 
	AU_NOTE("AU_NOTE", "AU-NOTE"),
	
	/**
	 * Australian Semi-Government Securities Treasury Notes.
	 */
	@RosettaEnumValue(value = "AU_STATENOTE", displayName = "AU-STATENOTE") 
	AU_STATENOTE("AU_STATENOTE", "AU-STATENOTE"),
	
	/**
	 * Australian Government Securities Treasury Adjustable Rate Bonds.
	 */
	@RosettaEnumValue(value = "AU_TAB", displayName = "AU-TAB") 
	AU_TAB("AU_TAB", "AU-TAB"),
	
	/**
	 * BEL20 Equity Securities.
	 */
	@RosettaEnumValue(value = "BE_BEL20", displayName = "BE-BEL20") 
	BE_BEL20("BE_BEL20", "BE-BEL20"),
	
	/**
	 * Belgian Treasury Certificates.
	 */
	@RosettaEnumValue(value = "BE_CERT", displayName = "BE-CERT") 
	BE_CERT("BE_CERT", "BE-CERT"),
	
	/**
	 * Belgian Linear Obligations.
	 */
	@RosettaEnumValue(value = "BE_LINEAR", displayName = "BE-LINEAR") 
	BE_LINEAR("BE_LINEAR", "BE-LINEAR"),
	
	/**
	 * Belgian Treasury notes.
	 */
	@RosettaEnumValue(value = "BE_NOTE", displayName = "BE-NOTE") 
	BE_NOTE("BE_NOTE", "BE-NOTE"),
	
	/**
	 * Public sector issues guaranteed by Regional Authorities.
	 */
	@RosettaEnumValue(value = "BE_REGIONGT", displayName = "BE-REGIONGT") 
	BE_REGIONGT("BE_REGIONGT", "BE-REGIONGT"),
	
	/**
	 * Public sector issues guaranteed by the Belgian State.
	 */
	@RosettaEnumValue(value = "BE_STATEGT", displayName = "BE-STATEGT") 
	BE_STATEGT("BE_STATEGT", "BE-STATEGT"),
	
	/**
	 * Belgian State Loans.
	 */
	@RosettaEnumValue(value = "BE_STATELOAN", displayName = "BE-STATELOAN") 
	BE_STATELOAN("BE_STATELOAN", "BE-STATELOAN"),
	
	/**
	 * Canada Bonds.
	 */
	@RosettaEnumValue(value = "CA_BOND", displayName = "CA-BOND") 
	CA_BOND("CA_BOND", "CA-BOND"),
	
	/**
	 * Canadian Dollar (CAD) Cash.
	 */
	@RosettaEnumValue(value = "CA_CASH", displayName = "CA-CASH") 
	CA_CASH("CA_CASH", "CA-CASH"),
	
	/**
	 * Government of Canada Real Return Bonds.
	 */
	@RosettaEnumValue(value = "CA_RRB", displayName = "CA-RRB") 
	CA_RRB("CA_RRB", "CA-RRB"),
	
	/**
	 * Government of Canada Treasury Bills.
	 */
	@RosettaEnumValue(value = "CA_TBILL", displayName = "CA-TBILL") 
	CA_TBILL("CA_TBILL", "CA-TBILL"),
	
	/**
	 * Public Authority Bond.
	 */
	@RosettaEnumValue(value = "CH_CANTON", displayName = "CH-CANTON") 
	CH_CANTON("CH_CANTON", "CH-CANTON"),
	
	/**
	 * Swiss Franc (CHF) Cash.
	 */
	@RosettaEnumValue(value = "CH_CASH", displayName = "CH-CASH") 
	CH_CASH("CH_CASH", "CH-CASH"),
	
	/**
	 * Federal Bond.
	 */
	@RosettaEnumValue(value = "CH_FEDBOND", displayName = "CH-FEDBOND") 
	CH_FEDBOND("CH_FEDBOND", "CH-FEDBOND"),
	
	/**
	 * Unverzinsliche Schatzanweisungen (Bills).
	 */
	@RosettaEnumValue(value = "DE_BILL", displayName = "DE-BILL") 
	DE_BILL("DE_BILL", "DE-BILL"),
	
	/**
	 * Bundesanleihen (Bonds).
	 */
	@RosettaEnumValue(value = "DE_BOND", displayName = "DE-BOND") 
	DE_BOND("DE_BOND", "DE-BOND"),
	
	/**
	 * Negotiable Debt Obligations issued by or taken over and since serviced and managed by the Erblasttilgungsfond (Redemption Fund for Inherited Liabilities) backed by Federal Republic of Germany, including but not limited to former issues of the Treuhandanstalt, the Bundesbahn, the Bundespost, the Economic Recovery Program (ERP), the privatised Federal Railway (Bahn AG), the telecommunications element of the Federal Post Office (Telekom) and the German Unity Fund.
	 */
	@RosettaEnumValue(value = "DE_ERBLAST", displayName = "DE-ERBLAST") 
	DE_ERBLAST("DE_ERBLAST", "DE-ERBLAST"),
	
	/**
	 * Kommunalschuldverschreib	ungen (Municipal Bonds).
	 */
	@RosettaEnumValue(value = "DE_MUNI", displayName = "DE-MUNI") 
	DE_MUNI("DE_MUNI", "DE-MUNI"),
	
	/**
	 * Bundesschatzanweisungen (Notes).
	 */
	@RosettaEnumValue(value = "DE_NOTE2", displayName = "DE-NOTE2") 
	DE_NOTE2("DE_NOTE2", "DE-NOTE2"),
	
	/**
	 * Bundesobligationen (Notes).
	 */
	@RosettaEnumValue(value = "DE_NOTE5_5", displayName = "DE-NOTE5.5") 
	DE_NOTE5_5("DE_NOTE5_5", "DE-NOTE5.5"),
	
	/**
	 * Hypothekenpfandbriefe (Mortgage Bonds).
	 */
	@RosettaEnumValue(value = "DE_PFAND", displayName = "DE-PFAND") 
	DE_PFAND("DE_PFAND", "DE-PFAND"),
	
	/**
	 * Skatkammerbeviser (Treasury Bills).
	 */
	@RosettaEnumValue(value = "DK_BILL", displayName = "DK-BILL") 
	DK_BILL("DK_BILL", "DK-BILL"),
	
	/**
	 * BoligX obligationer.
	 */
	@RosettaEnumValue(value = "DK_BOLIGX", displayName = "DK-BOLIGX") 
	DK_BOLIGX("DK_BOLIGX", "DK-BOLIGX"),
	
	/**
	 * Statsobligationer (Government Bonds).
	 */
	@RosettaEnumValue(value = "DK_BOND", displayName = "DK-BOND") 
	DK_BOND("DK_BOND", "DK-BOND"),
	
	/**
	 * Callable Mortgage Bonds.
	 */
	@RosettaEnumValue(value = "DK_CALLMORT", displayName = "DK-CALLMORT") 
	DK_CALLMORT("DK_CALLMORT", "DK-CALLMORT"),
	
	/**
	 * Danish Krone (DKK) Cash.
	 */
	@RosettaEnumValue(value = "DK_CASH", displayName = "DK-CASH") 
	DK_CASH("DK_CASH", "DK-CASH"),
	
	/**
	 * KFX Equity Securities.
	 */
	@RosettaEnumValue(value = "DK_KFX", displayName = "DK-KFX") 
	DK_KFX("DK_KFX", "DK-KFX"),
	
	/**
	 * Non-callable Mortgage Bonds.
	 */
	@RosettaEnumValue(value = "DK_MORT", displayName = "DK-MORT") 
	DK_MORT("DK_MORT", "DK-MORT"),
	
	/**
	 * Statsgaeldsbeviser (Treasury Notes).
	 */
	@RosettaEnumValue(value = "DK_NOTE", displayName = "DK-NOTE") 
	DK_NOTE("DK_NOTE", "DK-NOTE"),
	
	/**
	 * Treasury Bills - Letras del Tesoro.
	 */
	@RosettaEnumValue(value = "ES_BILL", displayName = "ES-BILL") 
	ES_BILL("ES_BILL", "ES-BILL"),
	
	/**
	 * Public Government Debt.
	 */
	@RosettaEnumValue(value = "ES_BOND", displayName = "ES-BOND") 
	ES_BOND("ES_BOND", "ES-BOND"),
	
	/**
	 * Cedulas.
	 */
	@RosettaEnumValue(value = "ES_CEDULAS", displayName = "ES-CEDULAS") 
	ES_CEDULAS("ES_CEDULAS", "ES-CEDULAS"),
	
	/**
	 * Corporate Bonds.
	 */
	@RosettaEnumValue(value = "ES_CORP", displayName = "ES-CORP") 
	ES_CORP("ES_CORP", "ES-CORP"),
	
	/**
	 * Equity securities issued by a Spanish company, and listed as an IBEX 35 constituent company as reported by the Sociedad de Bolsas, each share representing the minimum unit of participation of a shareholder in the stock capital of the company.
	 */
	@RosettaEnumValue(value = "ES_EQUITY", displayName = "ES-EQUITY") 
	ES_EQUITY("ES_EQUITY", "ES-EQUITY"),
	
	/**
	 * Euro (EUR) Cash.
	 */
	@RosettaEnumValue(value = "EU_CASH", displayName = "EU-CASH") 
	EU_CASH("EU_CASH", "EU-CASH"),
	
	/**
	 * FTSE Euro 100 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "EU_EURO100", displayName = "EU-EURO100") 
	EU_EURO100("EU_EURO100", "EU-EURO100"),
	
	/**
	 * FTSE Eurotop 300 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "EU_EUROTOP300", displayName = "EU-EUROTOP300") 
	EU_EUROTOP300("EU_EUROTOP300", "EU-EUROTOP300"),
	
	/**
	 * EuroSTOXX 50 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "EU_STOXX50", displayName = "EU-STOXX50") 
	EU_STOXX50("EU_STOXX50", "EU-STOXX50"),
	
	/**
	 * STOXX 600 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "EU_STOXX600", displayName = "EU-STOXX600") 
	EU_STOXX600("EU_STOXX600", "EU-STOXX600"),
	
	/**
	 * Treasury bills.
	 */
	@RosettaEnumValue(value = "FI_BILL", displayName = "FI-BILL") 
	FI_BILL("FI_BILL", "FI-BILL"),
	
	/**
	 * Serial bonds (Finnish Government Bond).
	 */
	@RosettaEnumValue(value = "FI_BOND", displayName = "FI-BOND") 
	FI_BOND("FI_BOND", "FI-BOND"),
	
	/**
	 * HEX Equity Securities.
	 */
	@RosettaEnumValue(value = "FI_HEX", displayName = "FI-HEX") 
	FI_HEX("FI_HEX", "FI-HEX"),
	
	/**
	 * Commercial Paper: (Billet de Trsorerie).
	 */
	@RosettaEnumValue(value = "FR_BDT", displayName = "FR-BDT") 
	FR_BDT("FR_BDT", "FR-BDT"),
	
	/**
	 * Treasury Notes: Bons du Trsor  Taux Annuel (BTAN).
	 */
	@RosettaEnumValue(value = "FR_BTAN", displayName = "FR-BTAN") 
	FR_BTAN("FR_BTAN", "FR-BTAN"),
	
	/**
	 * Treasury Bills: Bons du Trsor  Taux Fixe (BTF).
	 */
	@RosettaEnumValue(value = "FR_BTF", displayName = "FR-BTF") 
	FR_BTF("FR_BTF", "FR-BTF"),
	
	/**
	 * Government bonds: Obligations Assimilables du Trsor (OAT).
	 */
	@RosettaEnumValue(value = "FR_OAT", displayName = "FR-OAT") 
	FR_OAT("FR_OAT", "FR-OAT"),
	
	/**
	 * STRIPS.
	 */
	@RosettaEnumValue(value = "FR_STRIP", displayName = "FR-STRIP") 
	FR_STRIP("FR_STRIP", "FR-STRIP"),
	
	/**
	 * Generally Accepted Australian Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_AU_GOV", displayName = "GA-AU-GOV") 
	GA_AU_GOV("GA_AU_GOV", "GA-AU-GOV"),
	
	/**
	 * Generally Accepted Belgian Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_BE_GOV", displayName = "GA-BE-GOV") 
	GA_BE_GOV("GA_BE_GOV", "GA-BE-GOV"),
	
	/**
	 * Generally Accepted Canadian Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_CA_GOV", displayName = "GA-CA-GOV") 
	GA_CA_GOV("GA_CA_GOV", "GA-CA-GOV"),
	
	/**
	 * Generally Accepted Swiss Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_CH_GOV", displayName = "GA-CH-GOV") 
	GA_CH_GOV("GA_CH_GOV", "GA-CH-GOV"),
	
	/**
	 * Generally Accepted German Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_DE_GOV", displayName = "GA-DE-GOV") 
	GA_DE_GOV("GA_DE_GOV", "GA-DE-GOV"),
	
	/**
	 * Generally Accepted Danish Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_DK_GOV", displayName = "GA-DK-GOV") 
	GA_DK_GOV("GA_DK_GOV", "GA-DK-GOV"),
	
	/**
	 * Generally Accepted Spanish Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_ES_GOV", displayName = "GA-ES-GOV") 
	GA_ES_GOV("GA_ES_GOV", "GA-ES-GOV"),
	
	/**
	 * Generally Accepted Euro Zone Government Securities.
	 */
	@RosettaEnumValue(value = "GA_EUROZONE_GOV", displayName = "GA-EUROZONE-GOV") 
	GA_EUROZONE_GOV("GA_EUROZONE_GOV", "GA-EUROZONE-GOV"),
	
	/**
	 * Generally Accepted EU Member State Government Securities.
	 */
	@RosettaEnumValue(value = "GA_EU_GOV", displayName = "GA-EU-GOV") 
	GA_EU_GOV("GA_EU_GOV", "GA-EU-GOV"),
	
	/**
	 * Generally Accepted Finnish Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_FI_GOV", displayName = "GA-FI-GOV") 
	GA_FI_GOV("GA_FI_GOV", "GA-FI-GOV"),
	
	/**
	 * Generally Accepted French Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_FR_GOV", displayName = "GA-FR-GOV") 
	GA_FR_GOV("GA_FR_GOV", "GA-FR-GOV"),
	
	/**
	 * Generally Accepted G5 Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_G5_GOV", displayName = "GA-G5-GOV") 
	GA_G5_GOV("GA_G5_GOV", "GA-G5-GOV"),
	
	/**
	 * Generally Accepted British Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_GB_GOV", displayName = "GA-GB-GOV") 
	GA_GB_GOV("GA_GB_GOV", "GA-GB-GOV"),
	
	/**
	 * Generally Accepted Hong Kong Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_HK_GOV", displayName = "GA-HK-GOV") 
	GA_HK_GOV("GA_HK_GOV", "GA-HK-GOV"),
	
	/**
	 * Generally Accepted Italian Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_IT_GOV", displayName = "GA-IT-GOV") 
	GA_IT_GOV("GA_IT_GOV", "GA-IT-GOV"),
	
	/**
	 * Generally Accepted Japanese Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_JP_GOV", displayName = "GA-JP-GOV") 
	GA_JP_GOV("GA_JP_GOV", "GA-JP-GOV"),
	
	/**
	 * Generally Accepted Korean Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_KR_GOV", displayName = "GA-KR-GOV") 
	GA_KR_GOV("GA_KR_GOV", "GA-KR-GOV"),
	
	/**
	 * Generally Accepted Netherlands Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_NL_GOV", displayName = "GA-NL-GOV") 
	GA_NL_GOV("GA_NL_GOV", "GA-NL-GOV"),
	
	/**
	 * Generally Accepted Norwegian Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_NO_GOV", displayName = "GA-NO-GOV") 
	GA_NO_GOV("GA_NO_GOV", "GA-NO-GOV"),
	
	/**
	 * Generally Accepted New Zealand Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_NZ_GOV", displayName = "GA-NZ-GOV") 
	GA_NZ_GOV("GA_NZ_GOV", "GA-NZ-GOV"),
	
	/**
	 * Generally Accepted Swedish Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_SE_GOV", displayName = "GA-SE-GOV") 
	GA_SE_GOV("GA_SE_GOV", "GA-SE-GOV"),
	
	/**
	 * Generally Accepted Singaporean Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_SG_GOV", displayName = "GA-SG-GOV") 
	GA_SG_GOV("GA_SG_GOV", "GA-SG-GOV"),
	
	/**
	 * Generally Accepted US Agency Obligations.
	 */
	@RosettaEnumValue(value = "GA_US_AGENCY", displayName = "GA-US-AGENCY") 
	GA_US_AGENCY("GA_US_AGENCY", "GA-US-AGENCY"),
	
	/**
	 * Generally Accepted US Government Obligations.
	 */
	@RosettaEnumValue(value = "GA_US_GOV", displayName = "GA-US-GOV") 
	GA_US_GOV("GA_US_GOV", "GA-US-GOV"),
	
	/**
	 * Generally Accepted US Mortgage-Backed Obligations.
	 */
	@RosettaEnumValue(value = "GA_US_MORTGAGES", displayName = "GA-US-MORTGAGES") 
	GA_US_MORTGAGES("GA_US_MORTGAGES", "GA-US-MORTGAGES"),
	
	/**
	 * British Pound Sterling (GBP) Cash.
	 */
	@RosettaEnumValue(value = "GB_CASH", displayName = "GB-CASH") 
	GB_CASH("GB_CASH", "GB-CASH"),
	
	/**
	 * Double-dated Gilts.
	 */
	@RosettaEnumValue(value = "GB_DDGILT", displayName = "GB-DDGILT") 
	GB_DDGILT("GB_DDGILT", "GB-DDGILT"),
	
	/**
	 * FTSE 100 Equity Securities.
	 */
	@RosettaEnumValue(value = "GB_FT100", displayName = "GB-FT100") 
	GB_FT100("GB_FT100", "GB-FT100"),
	
	/**
	 * FTSE 250 Equity Securities.
	 */
	@RosettaEnumValue(value = "GB_FT250", displayName = "GB-FT250") 
	GB_FT250("GB_FT250", "GB-FT250"),
	
	/**
	 * FTSE 350 Equity Securities.
	 */
	@RosettaEnumValue(value = "GB_FT350", displayName = "GB-FT350") 
	GB_FT350("GB_FT350", "GB-FT350"),
	
	/**
	 * Conventional Gilts.
	 */
	@RosettaEnumValue(value = "GB_GILT", displayName = "GB-GILT") 
	GB_GILT("GB_GILT", "GB-GILT"),
	
	/**
	 * Index-Linked Gilts.
	 */
	@RosettaEnumValue(value = "GB_INDEXGILT", displayName = "GB-INDEXGILT") 
	GB_INDEXGILT("GB_INDEXGILT", "GB-INDEXGILT"),
	
	/**
	 * Undated or Perpetual Gilts.
	 */
	@RosettaEnumValue(value = "GB_PERPGILT", displayName = "GB-PERPGILT") 
	GB_PERPGILT("GB_PERPGILT", "GB-PERPGILT"),
	
	/**
	 * Rump Stock.
	 */
	@RosettaEnumValue(value = "GB_RUMPGILT", displayName = "GB-RUMPGILT") 
	GB_RUMPGILT("GB_RUMPGILT", "GB-RUMPGILT"),
	
	/**
	 * Bank of England Euro Bills.
	 */
	@RosettaEnumValue(value = "GB_SUPR1", displayName = "GB-SUPR1") 
	GB_SUPR1("GB_SUPR1", "GB-SUPR1"),
	
	/**
	 * Bank of England Euro Notes.
	 */
	@RosettaEnumValue(value = "GB_SUPR2", displayName = "GB-SUPR2") 
	GB_SUPR2("GB_SUPR2", "GB-SUPR2"),
	
	/**
	 * UK Treasury Bills.
	 */
	@RosettaEnumValue(value = "GB_TBILL", displayName = "GB-TBILL") 
	GB_TBILL("GB_TBILL", "GB-TBILL"),
	
	/**
	 * Gilt Strips or Zero Coupon Gilts.
	 */
	@RosettaEnumValue(value = "GB_ZEROGILT", displayName = "GB-ZEROGILT") 
	GB_ZEROGILT("GB_ZEROGILT", "GB-ZEROGILT"),
	
	/**
	 * Hong Kong Government Exchange Fund Bills.
	 */
	@RosettaEnumValue(value = "HK_BILL", displayName = "HK-BILL") 
	HK_BILL("HK_BILL", "HK-BILL"),
	
	/**
	 * Hong Kong Dollar (HKD) Cash.
	 */
	@RosettaEnumValue(value = "HK_CASH", displayName = "HK-CASH") 
	HK_CASH("HK_CASH", "HK-CASH"),
	
	/**
	 * Hong Kong Government Exchange Fund Notes.
	 */
	@RosettaEnumValue(value = "HK_NOTE", displayName = "HK-NOTE") 
	HK_NOTE("HK_NOTE", "HK-NOTE"),
	
	/**
	 * Botbuoni Ordinari del Tesoro (BOT) zero coupon debt securities issued by the Italian Treasury with maturities up to 365 days.
	 */
	@RosettaEnumValue(value = "IT_BOT", displayName = "IT-BOT") 
	IT_BOT("IT_BOT", "IT-BOT"),
	
	/**
	 * Buoni del Tesoro Poliennali fixed interest semi-annual debt securities issued by the Italian Treasury with original maturities between 3 and 30 years.
	 */
	@RosettaEnumValue(value = "IT_BTP", displayName = "IT-BTP") 
	IT_BTP("IT_BTP", "IT-BTP"),
	
	/**
	 * Certificati di Credito del Tesoro a Cedola Variable (CCT) or floating rate interest bearing debt securities issued by the Italian Treasury.
	 */
	@RosettaEnumValue(value = "IT_CCT", displayName = "IT-CCT") 
	IT_CCT("IT_CCT", "IT-CCT"),
	
	/**
	 * Corporate bonds.
	 */
	@RosettaEnumValue(value = "IT_CORP", displayName = "IT-CORP") 
	IT_CORP("IT_CORP", "IT-CORP"),
	
	/**
	 * Certificati del Tesoro zero coupon debt securities issued by the Italian Treasury with maturities between 18 and 24 months.
	 */
	@RosettaEnumValue(value = "IT_CTZ", displayName = "IT-CTZ") 
	IT_CTZ("IT_CTZ", "IT-CTZ"),
	
	/**
	 * MIB30 Equity Securities.
	 */
	@RosettaEnumValue(value = "IT_MIB30", displayName = "IT-MIB30") 
	IT_MIB30("IT_MIB30", "IT-MIB30"),
	
	/**
	 * Debt securities issued and marketed by the Republic of Italy outside the Italian market, traded as Eurobonds.
	 */
	@RosettaEnumValue(value = "IT_REP", displayName = "IT-REP") 
	IT_REP("IT_REP", "IT-REP"),
	
	/**
	 * Japanese Yen (JPY) Cash.
	 */
	@RosettaEnumValue(value = "JP_CASH", displayName = "JP-CASH") 
	JP_CASH("JP_CASH", "JP-CASH"),
	
	/**
	 * Corporate bonds including straight bonds.
	 */
	@RosettaEnumValue(value = "JP_CORPORATE", displayName = "JP-CORPORATE") 
	JP_CORPORATE("JP_CORPORATE", "JP-CORPORATE"),
	
	/**
	 * Commercial Paper.
	 */
	@RosettaEnumValue(value = "JP_CP", displayName = "JP-CP") 
	JP_CP("JP_CP", "JP-CP"),
	
	/**
	 * Equity securities issued by a Japanese company, each share representing the minimum unit of participation of a partner in the stock capital of the company.
	 */
	@RosettaEnumValue(value = "JP_EQUITY", displayName = "JP-EQUITY") 
	JP_EQUITY("JP_EQUITY", "JP-EQUITY"),
	
	/**
	 * Yen-denominated foreign bonds.
	 */
	@RosettaEnumValue(value = "JP_EUROBOND", displayName = "JP-EUROBOND") 
	JP_EUROBOND("JP_EUROBOND", "JP-EUROBOND"),
	
	/**
	 * Japanese Government Bonds.
	 */
	@RosettaEnumValue(value = "JP_JGB", displayName = "JP-JGB") 
	JP_JGB("JP_JGB", "JP-JGB"),
	
	/**
	 * Korean Treasury Bonds.
	 */
	@RosettaEnumValue(value = "KR_BOND", displayName = "KR-BOND") 
	KR_BOND("KR_BOND", "KR-BOND"),
	
	/**
	 * Korean Won (KRW) Cash.
	 */
	@RosettaEnumValue(value = "KR_CASH", displayName = "KR-CASH") 
	KR_CASH("KR_CASH", "KR-CASH"),
	
	/**
	 * Non Korean Won denominated Export-Import Bank of Korea bonds.
	 */
	@RosettaEnumValue(value = "KR_EXIM", displayName = "KR-EXIM") 
	KR_EXIM("KR_EXIM", "KR-EXIM"),
	
	/**
	 * Korean Development Insurance Corporation Bonds (Korean Won denominated).
	 */
	@RosettaEnumValue(value = "KR_KDICKRW", displayName = "KR-KDICKRW") 
	KR_KDICKRW("KR_KDICKRW", "KR-KDICKRW"),
	
	/**
	 * Non-Korean Won denominated Korea Development Bank bonds (KDBs).
	 */
	@RosettaEnumValue(value = "KR_KDR", displayName = "KR-KDR") 
	KR_KDR("KR_KDR", "KR-KDR"),
	
	/**
	 * KEPCO bonds.
	 */
	@RosettaEnumValue(value = "KR_KEPCO", displayName = "KR-KEPCO") 
	KR_KEPCO("KR_KEPCO", "KR-KEPCO"),
	
	/**
	 * Monetary Stabilisation Bonds.
	 */
	@RosettaEnumValue(value = "KR_MSB", displayName = "KR-MSB") 
	KR_MSB("KR_MSB", "KR-MSB"),
	
	/**
	 * Non Korean Won denominated Korea National Housing Corporation bonds (KNHCs).
	 */
	@RosettaEnumValue(value = "KR_NHC", displayName = "KR-NHC") 
	KR_NHC("KR_NHC", "KR-NHC"),
	
	/**
	 * Non-Korean Won denominated Republic of Korea bonds (ROKs).
	 */
	@RosettaEnumValue(value = "KR_ROK", displayName = "KR-ROK") 
	KR_ROK("KR_ROK", "KR-ROK"),
	
	/**
	 * AEX Equity Securities.
	 */
	@RosettaEnumValue(value = "NL_AEX", displayName = "NL-AEX") 
	NL_AEX("NL_AEX", "NL-AEX"),
	
	/**
	 * Dutch Treasury Certificates.
	 */
	@RosettaEnumValue(value = "NL_BILL", displayName = "NL-BILL") 
	NL_BILL("NL_BILL", "NL-BILL"),
	
	/**
	 * Dutch State Loans.
	 */
	@RosettaEnumValue(value = "NL_BOND", displayName = "NL-BOND") 
	NL_BOND("NL_BOND", "NL-BOND"),
	
	/**
	 * Norwegian Government Bonds.
	 */
	@RosettaEnumValue(value = "NO_BOND", displayName = "NO-BOND") 
	NO_BOND("NO_BOND", "NO-BOND"),
	
	/**
	 * Norwegian Krone (NOK) Cash.
	 */
	@RosettaEnumValue(value = "NO_CASH", displayName = "NO-CASH") 
	NO_CASH("NO_CASH", "NO-CASH"),
	
	/**
	 * OBX Equity Securities.
	 */
	@RosettaEnumValue(value = "NO_OBX", displayName = "NO-OBX") 
	NO_OBX("NO_OBX", "NO-OBX"),
	
	/**
	 * Norwegian T-Bills.
	 */
	@RosettaEnumValue(value = "NO_TBILL", displayName = "NO-TBILL") 
	NO_TBILL("NO_TBILL", "NO-TBILL"),
	
	/**
	 * New Zealand Government Bonds.
	 */
	@RosettaEnumValue(value = "NZ_BOND", displayName = "NZ-BOND") 
	NZ_BOND("NZ_BOND", "NZ-BOND"),
	
	/**
	 * New Zealand Dollar (NZD) Cash.
	 */
	@RosettaEnumValue(value = "NZ_CASH", displayName = "NZ-CASH") 
	NZ_CASH("NZ_CASH", "NZ-CASH"),
	
	/**
	 * New Zealand Government Treasury Bills.
	 */
	@RosettaEnumValue(value = "NZ_TBILL", displayName = "NZ-TBILL") 
	NZ_TBILL("NZ_TBILL", "NZ-TBILL"),
	
	/**
	 * Swedish Krona (SEK) Cash.
	 */
	@RosettaEnumValue(value = "SE_CASH", displayName = "SE-CASH") 
	SE_CASH("SE_CASH", "SE-CASH"),
	
	/**
	 * Swedish Government Bonds (SGB).
	 */
	@RosettaEnumValue(value = "SE_GOVT", displayName = "SE-GOVT") 
	SE_GOVT("SE_GOVT", "SE-GOVT"),
	
	/**
	 * Swedish Index Linked Government bonds.
	 */
	@RosettaEnumValue(value = "SE_ILGOVT", displayName = "SE-ILGOVT") 
	SE_ILGOVT("SE_ILGOVT", "SE-ILGOVT"),
	
	/**
	 * Swedish Mortgage Bonds.
	 */
	@RosettaEnumValue(value = "SE_MORT", displayName = "SE-MORT") 
	SE_MORT("SE_MORT", "SE-MORT"),
	
	/**
	 * OMX Equity Securities.
	 */
	@RosettaEnumValue(value = "SE_OMX", displayName = "SE-OMX") 
	SE_OMX("SE_OMX", "SE-OMX"),
	
	/**
	 * Swedish Treasury Bills (STB).
	 */
	@RosettaEnumValue(value = "SE_TBILL", displayName = "SE-TBILL") 
	SE_TBILL("SE_TBILL", "SE-TBILL"),
	
	/**
	 * Singapore Government (SGS) Bonds.
	 */
	@RosettaEnumValue(value = "SG_BOND", displayName = "SG-BOND") 
	SG_BOND("SG_BOND", "SG-BOND"),
	
	/**
	 * Singapore Dollar (SGD) Cash.
	 */
	@RosettaEnumValue(value = "SG_CASH", displayName = "SG-CASH") 
	SG_CASH("SG_CASH", "SG-CASH"),
	
	/**
	 * Singapore Government T-Bills (T-Bills).
	 */
	@RosettaEnumValue(value = "SG_TBILL", displayName = "SG-TBILL") 
	SG_TBILL("SG_TBILL", "SG-TBILL"),
	
	/**
	 * Inter-American Development Bank Bonds.
	 */
	@RosettaEnumValue(value = "SU_IADB", displayName = "SU-IADB") 
	SU_IADB("SU_IADB", "SU-IADB"),
	
	/**
	 * International Bank for Reconstruction and Development (World Bank) Discount Notes.
	 */
	@RosettaEnumValue(value = "SU_IBRDDN", displayName = "SU-IBRDDN") 
	SU_IBRDDN("SU_IBRDDN", "SU-IBRDDN"),
	
	/**
	 * International Bank for Reconstruction and Development (World Bank or IBRD) Global Benchmark Bonds.
	 */
	@RosettaEnumValue(value = "SU_IBRDGB", displayName = "SU-IBRDGB") 
	SU_IBRDGB("SU_IBRDGB", "SU-IBRDGB"),
	
	/**
	 * Adjustable Rate Mortgage (ARM) Bonds.
	 */
	@RosettaEnumValue(value = "US_ARM", displayName = "US-ARM") 
	US_ARM("US_ARM", "US-ARM"),
	
	/**
	 * United States of America Dollar (USD) Cash.
	 */
	@RosettaEnumValue(value = "US_CASH", displayName = "US-CASH") 
	US_CASH("US_CASH", "US-CASH"),
	
	/**
	 * REMICs, CMOs and other derivative structures.
	 */
	@RosettaEnumValue(value = "US_DERIV", displayName = "US-DERIV") 
	US_DERIV("US_DERIV", "US-DERIV"),
	
	/**
	 * Dow Jones Industrial Average Equity Securities.
	 */
	@RosettaEnumValue(value = "US_DOW", displayName = "US-DOW") 
	US_DOW("US_DOW", "US-DOW"),
	
	/**
	 * Dow Jones Composite Average Equity Securities.
	 */
	@RosettaEnumValue(value = "US_DOW_COMP", displayName = "US-DOW-COMP") 
	US_DOW_COMP("US_DOW_COMP", "US-DOW-COMP"),
	
	/**
	 * Dow Jones Transportation	Average Equity Securities.
	 */
	@RosettaEnumValue(value = "US_DOW_TRAN", displayName = "US-DOW-TRAN") 
	US_DOW_TRAN("US_DOW_TRAN", "US-DOW-TRAN"),
	
	/**
	 * Dow Jones Utilities Average Equity Securities.
	 */
	@RosettaEnumValue(value = "US_DOW_UTIL", displayName = "US-DOW-UTIL") 
	US_DOW_UTIL("US_DOW_UTIL", "US-DOW-UTIL"),
	
	/**
	 * Federal Agricultural Mortgage Corp (Farmer Mac) Bonds.
	 */
	@RosettaEnumValue(value = "US_FAMC", displayName = "US-FAMC") 
	US_FAMC("US_FAMC", "US-FAMC"),
	
	/**
	 * Farm Credit System (FCS) Bonds.
	 */
	@RosettaEnumValue(value = "US_FCS", displayName = "US-FCS") 
	US_FCS("US_FCS", "US-FCS"),
	
	/**
	 * Farm Credit System Financial Assistance Corporation (FCSFAC) Bonds.
	 */
	@RosettaEnumValue(value = "US_FCSFAC", displayName = "US-FCSFAC") 
	US_FCSFAC("US_FCSFAC", "US-FCSFAC"),
	
	/**
	 * Callable Agency Debt  Federal Home Loan Bank (FHLB).
	 */
	@RosettaEnumValue(value = "US_FHLB", displayName = "US-FHLB") 
	US_FHLB("US_FHLB", "US-FHLB"),
	
	/**
	 * Non-Callable Federal Home Loan Bank Debt.
	 */
	@RosettaEnumValue(value = "US_FHLBNC", displayName = "US-FHLBNC") 
	US_FHLBNC("US_FHLBNC", "US-FHLBNC"),
	
	/**
	 * Non-Callable Federal Home Loan Bank Discount Notes.
	 */
	@RosettaEnumValue(value = "US_FHLBNCDN", displayName = "US-FHLBNCDN") 
	US_FHLBNCDN("US_FHLBNCDN", "US-FHLBNCDN"),
	
	/**
	 * Callable Agency Debt  the Federal Home Loan Mortgage Corporation (FHLMC or Freddie Mac).
	 */
	@RosettaEnumValue(value = "US_FHLMC", displayName = "US-FHLMC") 
	US_FHLMC("US_FHLMC", "US-FHLMC"),
	
	/**
	 * Federal Home Loan Mortgage Corporation Certificates  Mortgage Backed Securities.
	 */
	@RosettaEnumValue(value = "US_FHLMCMBS", displayName = "US-FHLMCMBS") 
	US_FHLMCMBS("US_FHLMCMBS", "US-FHLMCMBS"),
	
	/**
	 * Financing Corp (FICO) Bonds.
	 */
	@RosettaEnumValue(value = "US_FICO", displayName = "US-FICO") 
	US_FICO("US_FICO", "US-FICO"),
	
	/**
	 * Callable Agency Debt  Federal National Mortgage Association (FNMA or Fannie Mae).
	 */
	@RosettaEnumValue(value = "US_FNMA", displayName = "US-FNMA") 
	US_FNMA("US_FNMA", "US-FNMA"),
	
	/**
	 * Federal National Mortgage Association Certificates  Mortgage Backed Securities.
	 */
	@RosettaEnumValue(value = "US_FNMAMBS", displayName = "US-FNMAMBS") 
	US_FNMAMBS("US_FNMAMBS", "US-FNMAMBS"),
	
	/**
	 * Callable Agency Debt  Government National Mortgage Association (GNMA).
	 */
	@RosettaEnumValue(value = "US_GNMA", displayName = "US-GNMA") 
	US_GNMA("US_GNMA", "US-GNMA"),
	
	/**
	 * Government National Mortgage Association Certificates  Mortgage Backed Securities (GNMA or Ginnie Mae).
	 */
	@RosettaEnumValue(value = "US_GNMAMBS", displayName = "US-GNMAMBS") 
	US_GNMAMBS("US_GNMAMBS", "US-GNMAMBS"),
	
	/**
	 * Lehman Brothers Credit Bond Index Debt Securities.
	 */
	@RosettaEnumValue(value = "US_LEHM_BOND", displayName = "US-LEHM-BOND") 
	US_LEHM_BOND("US_LEHM_BOND", "US-LEHM-BOND"),
	
	/**
	 * NASDAQ-100 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_NAS_100", displayName = "US-NAS-100") 
	US_NAS_100("US_NAS_100", "US-NAS-100"),
	
	/**
	 * NASDAQ Composite Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_NAS_COMP", displayName = "US-NAS-COMP") 
	US_NAS_COMP("US_NAS_COMP", "US-NAS-COMP"),
	
	/**
	 * Non-Callable Agency Debt  Various Issuers.
	 */
	@RosettaEnumValue(value = "US_NCAD", displayName = "US-NCAD") 
	US_NCAD("US_NCAD", "US-NCAD"),
	
	/**
	 * Non-Callable Agency Discount Notes  Various Issuers.
	 */
	@RosettaEnumValue(value = "US_NCADN", displayName = "US-NCADN") 
	US_NCADN("US_NCADN", "US-NCADN"),
	
	/**
	 * NYSE Composite Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_NYSE_COMP", displayName = "US-NYSE-COMP") 
	US_NYSE_COMP("US_NYSE_COMP", "US-NYSE-COMP"),
	
	/**
	 * Resolution Funding Corp (REFCorp) Bonds.
	 */
	@RosettaEnumValue(value = "US_REFCORP", displayName = "US-REFCORP") 
	US_REFCORP("US_REFCORP", "US-REFCORP"),
	
	/**
	 * Student Loan Marketing Association (Sallie Mae) Bonds.
	 */
	@RosettaEnumValue(value = "US_SLMA", displayName = "US-SLMA") 
	US_SLMA("US_SLMA", "US-SLMA"),
	
	/**
	 * US Treasury Strips.
	 */
	@RosettaEnumValue(value = "US_STRIP", displayName = "US-STRIP") 
	US_STRIP("US_STRIP", "US-STRIP"),
	
	/**
	 * Standard &amp; Poors 100 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_S_P100", displayName = "US-S&P100") 
	US_S_P100("US_S_P100", "US-S&P100"),
	
	/**
	 * Standard &amp; Poors Midcap 400 Equity Securities. corporations that are included within the Standard And Poor&#39;s Midcap 400 Index published by Standard And Poor&#39;s, a division of The McGraw-Hill Companies, Inc.
	 */
	@RosettaEnumValue(value = "US_S_P400", displayName = "US-S&P400") 
	US_S_P400("US_S_P400", "US-S&P400"),
	
	/**
	 * Standard &amp; Poors 500 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_S_P500", displayName = "US-S&P500") 
	US_S_P500("US_S_P500", "US-S&P500"),
	
	/**
	 * Standard &amp; Poors Smallcap 600 Index Equity Securities.
	 */
	@RosettaEnumValue(value = "US_S_P600", displayName = "US-S&P600") 
	US_S_P600("US_S_P600", "US-S&P600"),
	
	/**
	 * US Treasury Bills.
	 */
	@RosettaEnumValue(value = "US_TBILL", displayName = "US-TBILL") 
	US_TBILL("US_TBILL", "US-TBILL"),
	
	/**
	 * US Treasury Bonds.
	 */
	@RosettaEnumValue(value = "US_TBOND", displayName = "US-TBOND") 
	US_TBOND("US_TBOND", "US-TBOND"),
	
	/**
	 * US Treasury Inflation Protected Issues (TIPS).
	 */
	@RosettaEnumValue(value = "US_TIPS", displayName = "US-TIPS") 
	US_TIPS("US_TIPS", "US-TIPS"),
	
	/**
	 * US Treasury Notes.
	 */
	@RosettaEnumValue(value = "US_TNOTE", displayName = "US-TNOTE") 
	US_TNOTE("US_TNOTE", "US-TNOTE"),
	
	/**
	 * Tennessee Valley Authority (TVA) Bonds.
	 */
	@RosettaEnumValue(value = "US_TVA", displayName = "US-TVA") 
	US_TVA("US_TVA", "US-TVA")
;
	private static Map<String, CollateralAssetDefinitionsEnum> values;
	static {
        Map<String, CollateralAssetDefinitionsEnum> map = new ConcurrentHashMap<>();
		for (CollateralAssetDefinitionsEnum instance : CollateralAssetDefinitionsEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralAssetDefinitionsEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralAssetDefinitionsEnum fromDisplayName(String name) {
		CollateralAssetDefinitionsEnum value = values.get(name);
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
