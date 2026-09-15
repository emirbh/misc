package drr.standards.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 7.7.0
 */
@RosettaEnum("PaymentType4Code")
public enum PaymentType4Code {

	@RosettaEnumValue(value = "UFRO") 
	UFRO("UFRO", null),
	
	@RosettaEnumValue(value = "UWIN") 
	UWIN("UWIN", null),
	
	@RosettaEnumValue(value = "PEXH") 
	PEXH("PEXH", null)
;
	private static Map<String, PaymentType4Code> values;
	static {
        Map<String, PaymentType4Code> map = new ConcurrentHashMap<>();
		for (PaymentType4Code instance : PaymentType4Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PaymentType4Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PaymentType4Code fromDisplayName(String name) {
		PaymentType4Code value = values.get(name);
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
