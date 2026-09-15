package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration of the regulation used for regulatory reporting, for example CFTC_PART43, CFTC_PART45, CSA_2013, etc..
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/reporting-regime"
 *
 * Provision 
 *
 */
@RosettaEnum("RegimeNameEnum")
public enum RegimeNameEnum {

	/**
	 * Australian Securities and Investments Commission
	 */
	@RosettaEnumValue(value = "ASIC") 
	ASIC("ASIC", null),
	
	/**
	 * Canadian Securities Administrators
	 */
	@RosettaEnumValue(value = "CSA") 
	CSA("CSA", null),
	
	/**
	 * Dodd-Frank Act (US)
	 */
	@RosettaEnumValue(value = "DoddFrankAct") 
	DODD_FRANK_ACT("DoddFrankAct", null),
	
	/**
	 * European Markets Infrastructure Regulation
	 */
	@RosettaEnumValue(value = "EMIR") 
	EMIR("EMIR", null),
	
	/**
	 * Hong Kong Monetary Authority
	 */
	@RosettaEnumValue(value = "HKMA") 
	HKMA("HKMA", null),
	
	/**
	 * Japan Financial Services Authority
	 */
	@RosettaEnumValue(value = "JFSA") 
	JFSA("JFSA", null),
	
	/**
	 * The Monetary Authority of Singapore
	 */
	@RosettaEnumValue(value = "MAS") 
	MAS("MAS", null),
	
	/**
	 * Markets in Financial Instruments Directive
	 */
	@RosettaEnumValue(value = "MiFID") 
	MI_FID("MiFID", null),
	
	/**
	 * Markets in Financial Instruments Directive II
	 */
	@RosettaEnumValue(value = "MiFIDII") 
	MI_FIDII("MiFIDII", null),
	
	/**
	 * Markets in Financial Instruments Regulation
	 */
	@RosettaEnumValue(value = "MiFIR") 
	MI_FIR("MiFIR", null),
	
	/**
	 * OTC Derivatives Regulators Forum
	 */
	@RosettaEnumValue(value = "ODRF") 
	ODRF("ODRF", null),
	
	/**
	 * Russian regulatory reporting
	 */
	@RosettaEnumValue(value = "RussianFederation") 
	RUSSIAN_FEDERATION("RussianFederation", null),
	
	/**
	 * Securities Financing Transactions Regulation
	 */
	@RosettaEnumValue(value = "SFTR") 
	SFTR("SFTR", null),
	
	/**
	 * United Kingdom European Markets Infrastructure Regulation
	 */
	@RosettaEnumValue(value = "UKEMIR") 
	UKEMIR("UKEMIR", null)
;
	private static Map<String, RegimeNameEnum> values;
	static {
        Map<String, RegimeNameEnum> map = new ConcurrentHashMap<>();
		for (RegimeNameEnum instance : RegimeNameEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RegimeNameEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RegimeNameEnum fromDisplayName(String name) {
		RegimeNameEnum value = values.get(name);
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
