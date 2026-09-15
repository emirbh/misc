package iso20022.auth030.jfsa;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version ${project.version}
 */
@RosettaEnum("ClearingAccountType4Code")
public enum ClearingAccountType4Code {

	@RosettaEnumValue(value = "CLIE") 
	CLIE("CLIE", null),
	
	@RosettaEnumValue(value = "HOUS") 
	HOUS("HOUS", null)
;
	private static Map<String, ClearingAccountType4Code> values;
	static {
        Map<String, ClearingAccountType4Code> map = new ConcurrentHashMap<>();
		for (ClearingAccountType4Code instance : ClearingAccountType4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ClearingAccountType4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ClearingAccountType4Code fromDisplayName(String name) {
		ClearingAccountType4Code value = values.get(name);
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
