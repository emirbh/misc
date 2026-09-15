package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("SeniorityEnum")
public enum SeniorityEnum {

	@RosettaEnumValue(value = "SNDB") 
	SNDB("SNDB", null),
	
	@RosettaEnumValue(value = "SBOD") 
	SBOD("SBOD", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, SeniorityEnum> values;
	static {
        Map<String, SeniorityEnum> map = new ConcurrentHashMap<>();
		for (SeniorityEnum instance : SeniorityEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	SeniorityEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static SeniorityEnum fromDisplayName(String name) {
		SeniorityEnum value = values.get(name);
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
