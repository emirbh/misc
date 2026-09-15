package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("EmbeddedOptionTypeEnum")
public enum EmbeddedOptionTypeEnum {

	@RosettaEnumValue(value = "CANC") 
	CANC("CANC", null),
	
	@RosettaEnumValue(value = "EXTD") 
	EXTD("EXTD", null),
	
	@RosettaEnumValue(value = "OPET") 
	OPET("OPET", null),
	
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null),
	
	@RosettaEnumValue(value = "MDET") 
	MDET("MDET", null)
;
	private static Map<String, EmbeddedOptionTypeEnum> values;
	static {
        Map<String, EmbeddedOptionTypeEnum> map = new ConcurrentHashMap<>();
		for (EmbeddedOptionTypeEnum instance : EmbeddedOptionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	EmbeddedOptionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static EmbeddedOptionTypeEnum fromDisplayName(String name) {
		EmbeddedOptionTypeEnum value = values.get(name);
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
