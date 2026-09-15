package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies special purpose codes.
 * @version ${project.version}
 */
@RosettaEnum("NotApplicable1Code")
public enum NotApplicable1Code {

	/**
	 * Not applicable (N/A).
	 */
	@RosettaEnumValue(value = "NOAP") 
	NOAP("NOAP", null)
;
	private static Map<String, NotApplicable1Code> values;
	static {
        Map<String, NotApplicable1Code> map = new ConcurrentHashMap<>();
		for (NotApplicable1Code instance : NotApplicable1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotApplicable1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotApplicable1Code fromDisplayName(String name) {
		NotApplicable1Code value = values.get(name);
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
