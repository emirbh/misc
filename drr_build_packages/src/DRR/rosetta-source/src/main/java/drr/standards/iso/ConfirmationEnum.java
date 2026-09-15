package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ConfirmationEnum")
public enum ConfirmationEnum {

	@RosettaEnumValue(value = "ECNF") 
	ECNF("ECNF", null),
	
	@RosettaEnumValue(value = "YCNF") 
	YCNF("YCNF", null),
	
	@RosettaEnumValue(value = "NCNF") 
	NCNF("NCNF", null)
;
	private static Map<String, ConfirmationEnum> values;
	static {
        Map<String, ConfirmationEnum> map = new ConcurrentHashMap<>();
		for (ConfirmationEnum instance : ConfirmationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ConfirmationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ConfirmationEnum fromDisplayName(String name) {
		ConfirmationEnum value = values.get(name);
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
