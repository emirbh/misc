package drr.regulation.common;

import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The type of the transaction identifier
 * @version 7.7.0
 */
@RosettaEnum("HKMATransactionIdentifierEnum")
public enum HKMATransactionIdentifierEnum {

	/**
	 * Unique Swap Identifier
	 */
	@RosettaEnumValue(value = "USI") 
	USI("USI", null),
	
	/**
	 * Transaction Identifier
	 */
	@RosettaEnumValue(value = "TID") 
	TID("TID", null)
;
	private static Map<String, HKMATransactionIdentifierEnum> values;
	static {
        Map<String, HKMATransactionIdentifierEnum> map = new ConcurrentHashMap<>();
		for (HKMATransactionIdentifierEnum instance : HKMATransactionIdentifierEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	HKMATransactionIdentifierEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static HKMATransactionIdentifierEnum fromDisplayName(String name) {
		HKMATransactionIdentifierEnum value = values.get(name);
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
