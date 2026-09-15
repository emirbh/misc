package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("ClearingObligationEnum")
public enum ClearingObligationEnum {

	@RosettaEnumValue(value = "TRUE") 
	TRUE("TRUE", null),
	
	@RosettaEnumValue(value = "FLSE") 
	FLSE("FLSE", null),
	
	@RosettaEnumValue(value = "UKWN") 
	UKWN("UKWN", null)
;
	private static Map<String, ClearingObligationEnum> values;
	static {
        Map<String, ClearingObligationEnum> map = new ConcurrentHashMap<>();
		for (ClearingObligationEnum instance : ClearingObligationEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingObligationEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingObligationEnum fromDisplayName(String name) {
		ClearingObligationEnum value = values.get(name);
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
