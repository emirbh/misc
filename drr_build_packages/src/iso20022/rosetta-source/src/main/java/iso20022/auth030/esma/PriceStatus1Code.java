package iso20022.auth030.esma;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the status of the price of a financial instrument.
 * @version ${project.version}
 */
@RosettaEnum("PriceStatus1Code")
public enum PriceStatus1Code {

	/**
	 * Price is pending.
	 */
	@RosettaEnumValue(value = "PNDG") 
	PNDG("PNDG", null),
	
	/**
	 * No price for transaction (e.g. transfer between accounts).
	 */
	@RosettaEnumValue(value = "NOAP") 
	NOAP("NOAP", null)
;
	private static Map<String, PriceStatus1Code> values;
	static {
        Map<String, PriceStatus1Code> map = new ConcurrentHashMap<>();
		for (PriceStatus1Code instance : PriceStatus1Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PriceStatus1Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PriceStatus1Code fromDisplayName(String name) {
		PriceStatus1Code value = values.get(name);
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
