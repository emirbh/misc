package iso20022.auth030.mas;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("OptionParty1Code")
public enum OptionParty1Code {

	@RosettaEnumValue(value = "SLLR") 
	SLLR("SLLR", null),
	
	@RosettaEnumValue(value = "BYER") 
	BYER("BYER", null)
;
	private static Map<String, OptionParty1Code> values;
	static {
        Map<String, OptionParty1Code> map = new ConcurrentHashMap<>();
		for (OptionParty1Code instance : OptionParty1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionParty1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionParty1Code fromDisplayName(String name) {
		OptionParty1Code value = values.get(name);
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
