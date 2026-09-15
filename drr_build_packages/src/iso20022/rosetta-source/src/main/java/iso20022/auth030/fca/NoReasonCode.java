package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies that there is no reason available.
 * @version ${project.version}
 */
@RosettaEnum("NoReasonCode")
public enum NoReasonCode {

	/**
	 * No reason to report or no reason available to report.
	 */
	@RosettaEnumValue(value = "NORE") 
	NORE("NORE", null)
;
	private static Map<String, NoReasonCode> values;
	static {
        Map<String, NoReasonCode> map = new ConcurrentHashMap<>();
		for (NoReasonCode instance : NoReasonCode.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NoReasonCode(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NoReasonCode fromDisplayName(String name) {
		NoReasonCode value = values.get(name);
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
