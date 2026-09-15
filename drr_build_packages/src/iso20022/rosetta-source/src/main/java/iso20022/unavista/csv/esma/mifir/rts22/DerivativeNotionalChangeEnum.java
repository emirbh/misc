package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Indication as to whether the transaction is an increase or decrease of notional of a derivative contract. Field only applies when there is change in notional for a derivative contract.
 * @version ${project.version}
 */
@RosettaEnum("DerivativeNotionalChangeEnum")
public enum DerivativeNotionalChangeEnum {

	/**
	 * Increase
	 */
	@RosettaEnumValue(value = "INCR") 
	INCR("INCR", null),
	
	/**
	 * Decrease
	 */
	@RosettaEnumValue(value = "DECR") 
	DECR("DECR", null)
;
	private static Map<String, DerivativeNotionalChangeEnum> values;
	static {
        Map<String, DerivativeNotionalChangeEnum> map = new ConcurrentHashMap<>();
		for (DerivativeNotionalChangeEnum instance : DerivativeNotionalChangeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DerivativeNotionalChangeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DerivativeNotionalChangeEnum fromDisplayName(String name) {
		DerivativeNotionalChangeEnum value = values.get(name);
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
