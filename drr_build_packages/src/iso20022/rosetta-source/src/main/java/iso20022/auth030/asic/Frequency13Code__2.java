package iso20022.auth030.asic;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("Frequency13Code__2")
public enum Frequency13Code__2 {

	@RosettaEnumValue(value = "DAIL") 
	DAIL("DAIL", null),
	
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null)
;
	private static Map<String, Frequency13Code__2> values;
	static {
        Map<String, Frequency13Code__2> map = new ConcurrentHashMap<>();
		for (Frequency13Code__2 instance : Frequency13Code__2.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Frequency13Code__2(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Frequency13Code__2 fromDisplayName(String name) {
		Frequency13Code__2 value = values.get(name);
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
