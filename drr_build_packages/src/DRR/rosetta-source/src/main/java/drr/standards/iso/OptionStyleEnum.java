package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("OptionStyleEnum")
public enum OptionStyleEnum {

	@RosettaEnumValue(value = "AMER") 
	AMER("AMER", null),
	
	@RosettaEnumValue(value = "EURO") 
	EURO("EURO", null),
	
	@RosettaEnumValue(value = "BERM") 
	BERM("BERM", null),
	
	@RosettaEnumValue(value = "ASIA") 
	ASIA("ASIA", null)
;
	private static Map<String, OptionStyleEnum> values;
	static {
        Map<String, OptionStyleEnum> map = new ConcurrentHashMap<>();
		for (OptionStyleEnum instance : OptionStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionStyleEnum fromDisplayName(String name) {
		OptionStyleEnum value = values.get(name);
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
