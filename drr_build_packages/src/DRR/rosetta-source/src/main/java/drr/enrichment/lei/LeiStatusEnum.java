package drr.enrichment.lei;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("LeiStatusEnum")
public enum LeiStatusEnum {

	@RosettaEnumValue(value = "Active") 
	ACTIVE("Active", null),
	
	@RosettaEnumValue(value = "Inactive") 
	INACTIVE("Inactive", null),
	
	@RosettaEnumValue(value = "Null") 
	NULL("Null", null)
;
	private static Map<String, LeiStatusEnum> values;
	static {
        Map<String, LeiStatusEnum> map = new ConcurrentHashMap<>();
		for (LeiStatusEnum instance : LeiStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LeiStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LeiStatusEnum fromDisplayName(String name) {
		LeiStatusEnum value = values.get(name);
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
