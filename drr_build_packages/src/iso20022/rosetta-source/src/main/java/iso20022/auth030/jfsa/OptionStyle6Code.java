package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("OptionStyle6Code")
public enum OptionStyle6Code {

	@RosettaEnumValue(value = "EURO") 
	EURO("EURO", null),
	
	@RosettaEnumValue(value = "BERM") 
	BERM("BERM", null),
	
	@RosettaEnumValue(value = "ASIA") 
	ASIA("ASIA", null),
	
	@RosettaEnumValue(value = "AMER") 
	AMER("AMER", null)
;
	private static Map<String, OptionStyle6Code> values;
	static {
        Map<String, OptionStyle6Code> map = new ConcurrentHashMap<>();
		for (OptionStyle6Code instance : OptionStyle6Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionStyle6Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionStyle6Code fromDisplayName(String name) {
		OptionStyle6Code value = values.get(name);
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
