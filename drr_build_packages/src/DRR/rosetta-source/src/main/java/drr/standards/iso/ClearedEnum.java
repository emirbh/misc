package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ClearedEnum")
public enum ClearedEnum {

	@RosettaEnumValue(value = "Y") 
	Y("Y", null),
	
	@RosettaEnumValue(value = "N") 
	N("N", null),
	
	@RosettaEnumValue(value = "I") 
	I("I", null)
;
	private static Map<String, ClearedEnum> values;
	static {
        Map<String, ClearedEnum> map = new ConcurrentHashMap<>();
		for (ClearedEnum instance : ClearedEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearedEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearedEnum fromDisplayName(String name) {
		ClearedEnum value = values.get(name);
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
