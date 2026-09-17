package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the regulatory regimes.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * name "Regime"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2018 ISDA 2018 Credit Support Annex For Initial Margin  
 * paragraph "13 General Principles" * name "Regime"
 *
 * Provision 
 *
 */
@RosettaEnum("RegulatoryRegimeEnum")
public enum RegulatoryRegimeEnum {

	/**
	 * Australian Prudential Standard CPS 226 Margining and risk mitigation for non-centrally cleared derivatives.
	 */
	@RosettaEnumValue(value = "AustraliaMarginRules", displayName = "Australia") 
	AUSTRALIA_MARGIN_RULES("AustraliaMarginRules", "Australia"),
	
	/**
	 * Guideline E-22, Margin Requirements for Non-Centrally Cleared Derivatives issued by the Canadian Office of the Superintendent of Financial Institutions in February 2016.
	 */
	@RosettaEnumValue(value = "CanadaMarginRules", displayName = "Canada") 
	CANADA_MARGIN_RULES("CanadaMarginRules", "Canada"),
	
	/**
	 * Margin requirements adopted by the U.S. Commodity Futures Trading Commission pursuant to CEA  4s(e).
	 */
	@RosettaEnumValue(value = "CFTC_MarginRules", displayName = "CFTC") 
	CFTC_MARGIN_RULES("CFTC_MarginRules", "CFTC"),
	
	/**
	 * Regulation (EU) No 648/2012 of the European Parliament and of the Council of 4 July 2012 on OTC derivatives, central counterparties and trade repositories (including the EMIR RTS, which means the published regulatory technical standards on risk-mitigation techniques for OTC-derivative contracts not cleared by a CCP under Article 11(15) of EMIR).
	 */
	@RosettaEnumValue(value = "EMIR_MarginRules", displayName = "EMIR") 
	EMIR_MARGIN_RULES("EMIR_MarginRules", "EMIR"),
	
	/**
	 * Chapter CR-G-14 &#39;Non-centrally Cleared OTC Derivatives Transactions  Margin and Other Risk Mitigation Standards&#39; in the Banking Supervisory Policy Manual issued by the Hong Kong Monetary Authority.
	 */
	@RosettaEnumValue(value = "HongKongMarginRules", displayName = "Hong Kong") 
	HONG_KONG_MARGIN_RULES("HongKongMarginRules", "Hong Kong"),
	
	/**
	 * Margin rules adopted by the Financial Services Agency of Japan pursuant to Article 40, Item 2 of the Financial Instruments and Exchange Act (kinyuu shouhin torihiki hou) (Act No. 25 of 1948) and by the Ministry of Agriculture, Forestry and Fisheries and the Ministry of Economy, Trade and Industry pursuant to the Commodity Derivatives Act (shouhin sakimono torihiki hou) (Act No. 239 of 1950) (including their subordinated regulations and the related supervisory guidelines).
	 */
	@RosettaEnumValue(value = "JapanMarginRules", displayName = "Japan") 
	JAPAN_MARGIN_RULES("JapanMarginRules", "Japan"),
	
	/**
	 * Margin requirements adopted by a &#39;prudential regulator&#39; (as defined in CEA  1a(39)) pursuant to CEA  4s(e) and Exchange Act  15F(e).
	 */
	@RosettaEnumValue(value = "US_PrudentialMarginRules", displayName = "Prudential") 
	US_PRUDENTIAL_MARGIN_RULES("US_PrudentialMarginRules", "Prudential"),
	
	/**
	 * Margin requirements adopted by the U.S. Securities and Exchange Commission pursuant to Exchange Act  15F(e).
	 */
	@RosettaEnumValue(value = "SEC_MarginRules", displayName = "SEC") 
	SEC_MARGIN_RULES("SEC_MarginRules", "SEC"),
	
	/**
	 * Guidelines on Margin Requirements for Non-centrally Cleared OTC Derivatives Contracts issued by the Monetary Authority of Singapore (MAS) pursuant to section 321 of the Securities and Futures Act, Chapter 289 of Singapore.
	 */
	@RosettaEnumValue(value = "SingaporeMarginRules", displayName = "Singapore") 
	SINGAPORE_MARGIN_RULES("SingaporeMarginRules", "Singapore"),
	
	/**
	 * Margin rules adopted by the Swiss Federal Council pursuant to Article 110-111 of the Financial Market Infrastructure Act as well as Articles 100 to 107 and Annexes 3 to 5 of the Financial Market Infrastructure Ordinance.
	 */
	@RosettaEnumValue(value = "SwitzerlandMarginRules", displayName = "Switzerland") 
	SWITZERLAND_MARGIN_RULES("SwitzerlandMarginRules", "Switzerland"),
	
	/**
	 * The Central Bank of Brazil margin requirements adopted pursuant to Resolution no. 4,662, of 25 May 2018, enacted by the National Monetary Council.
	 */
	@RosettaEnumValue(value = "BrazilMarginRules", displayName = "Brazil") 
	BRAZIL_MARGIN_RULES("BrazilMarginRules", "Brazil"),
	
	/**
	 * EMIR (including, for the avoidance of doubt, the EMIR RTS) as it forms part of UK domestic law by virtue of section 3 of the European Union (Withdrawal) Act 2018 (as amended) (the EUWA) (including any amendments made to such legislation when it is brought into UK domestic law pursuant to section 8 of the EUWA or any regulations made thereunder), and which, for the avoidance of doubt, shall be subject to the interpretation provision in Paragraph [11(g)].3.
	 */
	@RosettaEnumValue(value = "UnitedKingdomMarginRules", displayName = "United Kingdom") 
	UNITED_KINGDOM_MARGIN_RULES("UnitedKingdomMarginRules", "United Kingdom"),
	
	/**
	 * the requirements contained in Joint Standard 2 of 2020 made in terms of the South African Financial Sector Regulation Act, 2017.
	 */
	@RosettaEnumValue(value = "SouthAfricaMarginRules", displayName = "South Africa") 
	SOUTH_AFRICA_MARGIN_RULES("SouthAfricaMarginRules", "South Africa"),
	
	/**
	 * Margin requirements adopted by the Korean Financial Services Commission and Financial Supervisory Service pursuant to the Guidelines on Margin Requirements for Non-Centrally Cleared OTC Derivatives Transactions, which are expected to be incorporated into the Financial Investment Services and Capital Markets Act.
	 */
	@RosettaEnumValue(value = "SouthKoreaMarginRules", displayName = "South Korea") 
	SOUTH_KOREA_MARGIN_RULES("SouthKoreaMarginRules", "South Korea"),
	
	/**
	 * Part III of Schedule 10 to Code of Conduct for Persons Licensed by or Registered with the Securities and Futures Commission of Hong Kong.
	 */
	@RosettaEnumValue(value = "HongKongSFCMarginRules", displayName = "Hong Kong SFC") 
	HONG_KONG_SFC_MARGIN_RULES("HongKongSFCMarginRules", "Hong Kong SFC")
;
	private static Map<String, RegulatoryRegimeEnum> values;
	static {
        Map<String, RegulatoryRegimeEnum> map = new ConcurrentHashMap<>();
		for (RegulatoryRegimeEnum instance : RegulatoryRegimeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RegulatoryRegimeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RegulatoryRegimeEnum fromDisplayName(String name) {
		RegulatoryRegimeEnum value = values.get(name);
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
