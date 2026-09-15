package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("OptionTypeCode")
public enum OptionTypeCode {

	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	@RosettaEnumValue(value = "PUTO") 
	PUTO("PUTO", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, OptionTypeCode> values;
	static {
        Map<String, OptionTypeCode> map = new ConcurrentHashMap<>();
		for (OptionTypeCode instance : OptionTypeCode.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionTypeCode(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionTypeCode fromDisplayName(String name) {
		OptionTypeCode value = values.get(name);
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
