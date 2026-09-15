package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("Direction2Enum")
public enum Direction2Enum {

	@RosettaEnumValue(value = "MAKE") 
	MAKE("MAKE", null),
	
	@RosettaEnumValue(value = "TAKE") 
	TAKE("TAKE", null)
;
	private static Map<String, Direction2Enum> values;
	static {
        Map<String, Direction2Enum> map = new ConcurrentHashMap<>();
		for (Direction2Enum instance : Direction2Enum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Direction2Enum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Direction2Enum fromDisplayName(String name) {
		Direction2Enum value = values.get(name);
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
