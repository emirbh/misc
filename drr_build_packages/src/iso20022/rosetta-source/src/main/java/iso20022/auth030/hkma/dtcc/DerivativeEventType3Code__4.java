package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Explanation or reason for the action being taken on the transaction reporting.
 * @version ${project.version}
 */
@RosettaEnum("DerivativeEventType3Code__4")
public enum DerivativeEventType3Code__4 {

	/**
	 * The process by which a derivative transaction is transferred to another trade repository using the same UTI.
	 */
	@RosettaEnumValue(value = "PTNG") 
	PTNG("PTNG", null)
;
	private static Map<String, DerivativeEventType3Code__4> values;
	static {
        Map<String, DerivativeEventType3Code__4> map = new ConcurrentHashMap<>();
		for (DerivativeEventType3Code__4 instance : DerivativeEventType3Code__4.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DerivativeEventType3Code__4(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DerivativeEventType3Code__4 fromDisplayName(String name) {
		DerivativeEventType3Code__4 value = values.get(name);
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
