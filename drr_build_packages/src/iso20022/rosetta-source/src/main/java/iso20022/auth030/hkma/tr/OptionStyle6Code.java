package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies how an option can be exercised.
 * @version ${project.version}
 */
@RosettaEnum("OptionStyle6Code")
public enum OptionStyle6Code {

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
	 * Option where the payoff is not determined by the underlying price at maturity but by the average underlying price over some pre-set period of time.
	 */
	@RosettaEnumValue(value = "ASIA") 
	ASIA("ASIA", null),
	
	/**
	 * Option can be exercised before or on expiry date.
	 */
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
