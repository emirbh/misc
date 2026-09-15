package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("OptionTypeEnum")
public enum OptionTypeEnum {

	/**
	 * put
	 */
	@RosettaEnumValue(value = "PUTO") 
	PUTO("PUTO", null),
	
	/**
	 * call
	 */
	@RosettaEnumValue(value = "CALL") 
	CALL("CALL", null),
	
	/**
	 * other
	 */
	@RosettaEnumValue(value = "OTHR") 
	OTHR("OTHR", null)
;
	private static Map<String, OptionTypeEnum> values;
	static {
        Map<String, OptionTypeEnum> map = new ConcurrentHashMap<>();
		for (OptionTypeEnum instance : OptionTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionTypeEnum fromDisplayName(String name) {
		OptionTypeEnum value = values.get(name);
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
