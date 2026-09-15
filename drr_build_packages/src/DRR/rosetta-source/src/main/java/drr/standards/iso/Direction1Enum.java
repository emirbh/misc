package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("Direction1Enum")
public enum Direction1Enum {

	@RosettaEnumValue(value = "BYER") 
	BYER("BYER", null),
	
	@RosettaEnumValue(value = "SLLR") 
	SLLR("SLLR", null)
;
	private static Map<String, Direction1Enum> values;
	static {
        Map<String, Direction1Enum> map = new ConcurrentHashMap<>();
		for (Direction1Enum instance : Direction1Enum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Direction1Enum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Direction1Enum fromDisplayName(String name) {
		Direction1Enum value = values.get(name);
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
