package iso20022.auth030.fca;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies how an option can be exercised.
 * @version ${project.version}
 */
@RosettaEnum("OptionStyle6Code__1")
public enum OptionStyle6Code__1 {

	/**
	 * Option that can be exercised on expiry date only.
	 */
	@RosettaEnumValue(value = "EURO") 
	EURO("EURO", null),
	
	/**
	 * Option that can be exercised on multiple discrete dates prior to, or on expiry date.
	 */
	@RosettaEnumValue(value = "BERM") 
	BERM("BERM", null),
	
	/**
	 * Option can be exercised before or on expiry date.
	 */
	@RosettaEnumValue(value = "AMER") 
	AMER("AMER", null)
;
	private static Map<String, OptionStyle6Code__1> values;
	static {
        Map<String, OptionStyle6Code__1> map = new ConcurrentHashMap<>();
		for (OptionStyle6Code__1 instance : OptionStyle6Code__1.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionStyle6Code__1(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionStyle6Code__1 fromDisplayName(String name) {
		OptionStyle6Code__1 value = values.get(name);
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
