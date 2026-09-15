package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration of the supervisory body that may be supervising this transaction.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/supervisory-body"
 *
 * Provision 
 *
 */
@RosettaEnum("SupervisoryBodyEnum")
public enum SupervisoryBodyEnum {

	/**
	 * Australian Securities and Investments Commission
	 */
	@RosettaEnumValue(value = "ASIC") 
	ASIC("ASIC", null),
	
	/**
	 * Central Bank of the Russian Federation
	 */
	@RosettaEnumValue(value = "BankOfRussia") 
	BANK_OF_RUSSIA("BankOfRussia", null),
	
	/**
	 * Alberta Securities Commission
	 */
	@RosettaEnumValue(value = "CA_AB_ASC", displayName = "CA.AB.ASC") 
	CA_AB_ASC("CA_AB_ASC", "CA.AB.ASC"),
	
	/**
	 * British Columbia Securities Commission
	 */
	@RosettaEnumValue(value = "CA_BC_BCSC", displayName = "CA.BC.BCSC") 
	CA_BC_BCSC("CA_BC_BCSC", "CA.BC.BCSC"),
	
	/**
	 * The Manitoba Securities Commission
	 */
	@RosettaEnumValue(value = "CA_MB_MSC", displayName = "CA.MB.MSC") 
	CA_MB_MSC("CA_MB_MSC", "CA.MB.MSC"),
	
	/**
	 * Financial and Consumer Services Commission
	 */
	@RosettaEnumValue(value = "CA_NB_FCSC", displayName = "CA.NB.FCSC") 
	CA_NB_FCSC("CA_NB_FCSC", "CA.NB.FCSC"),
	
	/**
	 * Deputy Superintendent of Securities, Service Newfoundland and Labrador
	 */
	@RosettaEnumValue(value = "CA_NL_DSS", displayName = "CA.NL.DSS") 
	CA_NL_DSS("CA_NL_DSS", "CA.NL.DSS"),
	
	/**
	 * Nova Scotia Securities Commission
	 */
	@RosettaEnumValue(value = "CA_NS_NSSC", displayName = "CA.NS.NSSC") 
	CA_NS_NSSC("CA_NS_NSSC", "CA.NS.NSSC"),
	
	/**
	 * Northwest Territories Securities Office
	 */
	@RosettaEnumValue(value = "CA_NT_NTSO", displayName = "CA.NT.NTSO") 
	CA_NT_NTSO("CA_NT_NTSO", "CA.NT.NTSO"),
	
	/**
	 * Nunavut Securities Office, Government of Nunavut
	 */
	@RosettaEnumValue(value = "CA_NU_NSO", displayName = "CA.NU.NSO") 
	CA_NU_NSO("CA_NU_NSO", "CA.NU.NSO"),
	
	/**
	 * Ontario Securities Commission
	 */
	@RosettaEnumValue(value = "CA_ON_OSC", displayName = "CA.ON.OSC") 
	CA_ON_OSC("CA_ON_OSC", "CA.ON.OSC"),
	
	/**
	 * Office of the Superintendent of Securities
	 */
	@RosettaEnumValue(value = "CA_PEI_OSS", displayName = "CA.PEI.OSS") 
	CA_PEI_OSS("CA_PEI_OSS", "CA.PEI.OSS"),
	
	/**
	 * Autorite des marches financiers
	 */
	@RosettaEnumValue(value = "CA_QC_AMF", displayName = "CA.QC.AMF") 
	CA_QC_AMF("CA_QC_AMF", "CA.QC.AMF"),
	
	/**
	 * Financial and Consumer Affairs Authority of Saskatchewan
	 */
	@RosettaEnumValue(value = "CA_SK_FCAA", displayName = "CA.SK.FCAA") 
	CA_SK_FCAA("CA_SK_FCAA", "CA.SK.FCAA"),
	
	/**
	 * Office of the Superintendent of Securities
	 */
	@RosettaEnumValue(value = "CA_YT_OSS", displayName = "CA.YT.OSS") 
	CA_YT_OSS("CA_YT_OSS", "CA.YT.OSS"),
	
	/**
	 * Commodity Futures Trading Commission (US)
	 */
	@RosettaEnumValue(value = "CFTC") 
	CFTC("CFTC", null),
	
	/**
	 * European Securities and Markets Authority (European Union)
	 */
	@RosettaEnumValue(value = "ESMA") 
	ESMA("ESMA", null),
	
	/**
	 * Financial Conduct Authority (UK)
	 */
	@RosettaEnumValue(value = "FCA") 
	FCA("FCA", null),
	
	/**
	 * Federal Reserve (US)
	 */
	@RosettaEnumValue(value = "Fed") 
	FED("Fed", null),
	
	/**
	 * Hong Kong Monetary Authority (China)
	 */
	@RosettaEnumValue(value = "HKMA") 
	HKMA("HKMA", null),
	
	/**
	 * Japan Financial Services Authority (Japan)
	 */
	@RosettaEnumValue(value = "JFSA") 
	JFSA("JFSA", null),
	
	/**
	 * The Monetary Authority of Singapore
	 */
	@RosettaEnumValue(value = "MAS") 
	MAS("MAS", null),
	
	/**
	 * OTC Derivatives Regulators Forum
	 */
	@RosettaEnumValue(value = "ODRF") 
	ODRF("ODRF", null),
	
	/**
	 * Securities and Exchange Commission (US)
	 */
	@RosettaEnumValue(value = "SEC") 
	SEC("SEC", null),
	
	/**
	 * Deprecated usage: FCA replaces UKFSA
	 */
	@RosettaEnumValue(value = "UKFSA") 
	UKFSA("UKFSA", null)
;
	private static Map<String, SupervisoryBodyEnum> values;
	static {
        Map<String, SupervisoryBodyEnum> map = new ConcurrentHashMap<>();
		for (SupervisoryBodyEnum instance : SupervisoryBodyEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SupervisoryBodyEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SupervisoryBodyEnum fromDisplayName(String name) {
		SupervisoryBodyEnum value = values.get(name);
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
