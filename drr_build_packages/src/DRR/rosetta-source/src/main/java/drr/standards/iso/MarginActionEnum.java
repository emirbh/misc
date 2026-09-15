package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("MarginActionEnum")
public enum MarginActionEnum {

	@RosettaEnumValue(value = "MARU") 
	MARU("MARU", null),
	
	@RosettaEnumValue(value = "CORR") 
	CORR("CORR", null)
;
	private static Map<String, MarginActionEnum> values;
	static {
        Map<String, MarginActionEnum> map = new ConcurrentHashMap<>();
		for (MarginActionEnum instance : MarginActionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MarginActionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MarginActionEnum fromDisplayName(String name) {
		MarginActionEnum value = values.get(name);
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
