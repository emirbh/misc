package cdm.legaldocumentation.csa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Details of the alternative dispute resolution procedure (if any).
 * @version 6.23.0
 */
@RosettaEnum("LegacyResolutionAlternativeEnum")
public enum LegacyResolutionAlternativeEnum {

	/**
	 * No Alternative dispute resolution procedure is defined.
	 */
	@RosettaEnumValue(value = "NoAlternative") 
	NO_ALTERNATIVE("NoAlternative", null),
	
	/**
	 * A split the difference resolution procedure applies.
	 */
	@RosettaEnumValue(value = "SplitDifference") 
	SPLIT_DIFFERENCE("SplitDifference", null),
	
	/**
	 * Additional Conditions are defined.
	 */
	@RosettaEnumValue(value = "AdditionalConditions") 
	ADDITIONAL_CONDITIONS("AdditionalConditions", null)
;
	private static Map<String, LegacyResolutionAlternativeEnum> values;
	static {
        Map<String, LegacyResolutionAlternativeEnum> map = new ConcurrentHashMap<>();
		for (LegacyResolutionAlternativeEnum instance : LegacyResolutionAlternativeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegacyResolutionAlternativeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegacyResolutionAlternativeEnum fromDisplayName(String name) {
		LegacyResolutionAlternativeEnum value = values.get(name);
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
