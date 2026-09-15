package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("Frequency13Code")
public enum Frequency13Code {

	@RosettaEnumValue(value = "DAIL") 
	DAIL("DAIL", null),
	
	@RosettaEnumValue(value = "WEEK") 
	WEEK("WEEK", null),
	
	@RosettaEnumValue(value = "MNTH") 
	MNTH("MNTH", null),
	
	@RosettaEnumValue(value = "YEAR") 
	YEAR("YEAR", null),
	
	@RosettaEnumValue(value = "ADHO") 
	ADHO("ADHO", null),
	
	@RosettaEnumValue(value = "EXPI") 
	EXPI("EXPI", null),
	
	@RosettaEnumValue(value = "MIAN") 
	MIAN("MIAN", null),
	
	@RosettaEnumValue(value = "QURT") 
	QURT("QURT", null)
;
	private static Map<String, Frequency13Code> values;
	static {
        Map<String, Frequency13Code> map = new ConcurrentHashMap<>();
		for (Frequency13Code instance : Frequency13Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	Frequency13Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static Frequency13Code fromDisplayName(String name) {
		Frequency13Code value = values.get(name);
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
