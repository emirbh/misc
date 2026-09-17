package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Values to specify the margin approach specific to Initial Margin agreements.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2018 ISDA 2018 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13"
 *
 * Provision 
 *
 */
@RosettaEnum("MarginApproachEnum")
public enum MarginApproachEnum {

	/**
	 * Distinct Margin Flow (IM) Approach.
	 */
	@RosettaEnumValue(value = "Distinct") 
	DISTINCT("Distinct", null),
	
	/**
	 * Allocated Margin Flow (IM/IA) Approach.
	 */
	@RosettaEnumValue(value = "Allocated") 
	ALLOCATED("Allocated", null),
	
	/**
	 * Greater of Margin Flow (IM/IA) Approach.
	 */
	@RosettaEnumValue(value = "GreaterOf") 
	GREATER_OF("GreaterOf", null)
;
	private static Map<String, MarginApproachEnum> values;
	static {
        Map<String, MarginApproachEnum> map = new ConcurrentHashMap<>();
		for (MarginApproachEnum instance : MarginApproachEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MarginApproachEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MarginApproachEnum fromDisplayName(String name) {
		MarginApproachEnum value = values.get(name);
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
