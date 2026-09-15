package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration of the values specifying clearing exceptions and exemptions.
 * @version 7.7.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/cftc-clearing-exception-and-exemptions"
 *
 * Provision 
 *
 */
@RosettaEnum("ClearingExceptionReasonEnum")
public enum ClearingExceptionReasonEnum {

	/**
	 * Used to indicate a clearing exception where a firm is hedging and using an agent to do doing the hedging on its behalf.
	 */
	@RosettaEnumValue(value = "Agent_Affiliate", displayName = "Agent-Affiliate") 
	AGENT_AFFILIATE("Agent_Affiliate", "Agent-Affiliate"),
	
	/**
	 * Clearing exception for certain swaps entered into by cooperatives. In the US, see Regulation 50.51(a) Definition of Exempt Cooperative.
	 */
	@RosettaEnumValue(value = "Cooperative") 
	COOPERATIVE("Cooperative", null),
	
	/**
	 * In the US, see CFTC Final Rule on End-User Exception to Clearing Requirements for Swaps Fact Sheet.
	 */
	@RosettaEnumValue(value = "End_User", displayName = "End-User") 
	END_USER("End_User", "End-User"),
	
	/**
	 * Used to indicate an exception to a clearing requirement without elaborating on the type of exception.
	 */
	@RosettaEnumValue(value = "Exception") 
	EXCEPTION("Exception", null),
	
	/**
	 * In the US, see CFTC Final Rule - Clearing Exemption for Swaps Between Certain Affiliated Entities.
	 */
	@RosettaEnumValue(value = "Inter_Affiliate", displayName = "Inter-Affiliate") 
	INTER_AFFILIATE("Inter_Affiliate", "Inter-Affiliate"),
	
	/**
	 * No-action letter.
	 */
	@RosettaEnumValue(value = "NoActionLetter") 
	NO_ACTION_LETTER("NoActionLetter", null),
	
	/**
	 * Small bank exemption, as defined in Regulation 50.50(d) in the US.
	 */
	@RosettaEnumValue(value = "SmallBank") 
	SMALL_BANK("SmallBank", null),
	
	/**
	 * In the US, see CFTC No Action Letter 13-22 No Action Relief from the Clearing Requirement for Swaps Entered into by Eligible Treasury Affiliates.
	 */
	@RosettaEnumValue(value = "Treasury_Affiliate", displayName = "Treasury-Affiliate") 
	TREASURY_AFFILIATE("Treasury_Affiliate", "Treasury-Affiliate")
;
	private static Map<String, ClearingExceptionReasonEnum> values;
	static {
        Map<String, ClearingExceptionReasonEnum> map = new ConcurrentHashMap<>();
		for (ClearingExceptionReasonEnum instance : ClearingExceptionReasonEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingExceptionReasonEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingExceptionReasonEnum fromDisplayName(String name) {
		ClearingExceptionReasonEnum value = values.get(name);
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
