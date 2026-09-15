package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbLevelEnum")
public enum AnnaDsbLevelEnum {

	@RosettaEnumValue(value = "UPI") 
	UPI("UPI", null)
;
	private static Map<String, AnnaDsbLevelEnum> values;
	static {
        Map<String, AnnaDsbLevelEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbLevelEnum instance : AnnaDsbLevelEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbLevelEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbLevelEnum fromDisplayName(String name) {
		AnnaDsbLevelEnum value = values.get(name);
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
