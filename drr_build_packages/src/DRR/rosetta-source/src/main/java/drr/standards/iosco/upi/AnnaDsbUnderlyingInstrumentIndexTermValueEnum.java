package drr.standards.iosco.upi;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("AnnaDsbUnderlyingInstrumentIndexTermValueEnum")
public enum AnnaDsbUnderlyingInstrumentIndexTermValueEnum {

	@RosettaEnumValue(value = "_0", displayName = "0") 
	_0("_0", "0")
;
	private static Map<String, AnnaDsbUnderlyingInstrumentIndexTermValueEnum> values;
	static {
        Map<String, AnnaDsbUnderlyingInstrumentIndexTermValueEnum> map = new ConcurrentHashMap<>();
		for (AnnaDsbUnderlyingInstrumentIndexTermValueEnum instance : AnnaDsbUnderlyingInstrumentIndexTermValueEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AnnaDsbUnderlyingInstrumentIndexTermValueEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AnnaDsbUnderlyingInstrumentIndexTermValueEnum fromDisplayName(String name) {
		AnnaDsbUnderlyingInstrumentIndexTermValueEnum value = values.get(name);
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
