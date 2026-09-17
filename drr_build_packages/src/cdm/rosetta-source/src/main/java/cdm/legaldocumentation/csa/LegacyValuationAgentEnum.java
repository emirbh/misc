package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies how the Valuation Agent is determined.
 * @version 6.23.0
 */
@RosettaEnum("LegacyValuationAgentEnum")
public enum LegacyValuationAgentEnum {

	/**
	 * There is only a Sole Valuation Agent.
	 */
	@RosettaEnumValue(value = "SoleValuationAgent") 
	SOLE_VALUATION_AGENT("SoleValuationAgent", null),
	
	/**
	 * Switch of Valuation Agent can occur upon Default.
	 */
	@RosettaEnumValue(value = "SwitchUponDefault") 
	SWITCH_UPON_DEFAULT("SwitchUponDefault", null),
	
	/**
	 * Switch of Valuation Agent can occur upon failure to perform.
	 */
	@RosettaEnumValue(value = "SwitchUponFailureToPerform") 
	SWITCH_UPON_FAILURE_TO_PERFORM("SwitchUponFailureToPerform", null),
	
	/**
	 * There is a fixed party for disputes.
	 */
	@RosettaEnumValue(value = "FixedPartyForDisputes") 
	FIXED_PARTY_FOR_DISPUTES("FixedPartyForDisputes", null)
;
	private static Map<String, LegacyValuationAgentEnum> values;
	static {
        Map<String, LegacyValuationAgentEnum> map = new ConcurrentHashMap<>();
		for (LegacyValuationAgentEnum instance : LegacyValuationAgentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegacyValuationAgentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegacyValuationAgentEnum fromDisplayName(String name) {
		LegacyValuationAgentEnum value = values.get(name);
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
