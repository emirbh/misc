package iso20022.auth108.iso;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the role of a trading party in a transaction.
 * @version ${project.version}
 */
@RosettaEnum("TradingCapacity7Code")
public enum TradingCapacity7Code {

	/**
	 * Trading as Agent on behalf of a customer.
	 */
	@RosettaEnumValue(value = "AGEN") 
	AGEN("AGEN", null),
	
	/**
	 * Trading as Principal.
	 */
	@RosettaEnumValue(value = "PRIN") 
	PRIN("PRIN", null)
;
	private static Map<String, TradingCapacity7Code> values;
	static {
        Map<String, TradingCapacity7Code> map = new ConcurrentHashMap<>();
		for (TradingCapacity7Code instance : TradingCapacity7Code.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TradingCapacity7Code(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TradingCapacity7Code fromDisplayName(String name) {
		TradingCapacity7Code value = values.get(name);
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
